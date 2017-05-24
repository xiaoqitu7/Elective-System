package com.yj.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.yj.dao.BaseDao;
import com.yj.dao.ElectiveDao;
import com.yj.model.Elective;


public class ElectiveDaoImp extends BaseDao implements ElectiveDao{

	public Elective findElective(String xh, String kh,String gh) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Elective where xh= ? and kh= ? and gh= ? ");
		    query.setParameter(0, xh);
			query.setParameter(1, kh);
			query.setParameter(2, gh);
			Elective elective=(Elective)query.uniqueResult();
			ts.commit();
			session.close();
			return elective;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Elective findIfElective(String xh, String kh) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Elective where xh= ? and kh= ? ");
		    query.setParameter(0, xh);
			query.setParameter(1, kh);
			Elective elective=(Elective)query.uniqueResult();
			ts.commit();
			session.close();
			return elective;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List<Elective> findElectives(String kh,String gh){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Elective where kh= ? and gh= ? order by xh");
		    query.setParameter(0, kh);
			query.setParameter(1, gh);
		    List list=query.list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	public void addElective(String xh, String kh, String gh) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Elective elective=new Elective();
		    elective.setXh(xh);
		    elective.setGh(gh);
		    elective.setKh(kh);
		    session.save(elective);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void delElective(String xh, String kh,String gh) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Elective elective=findElective(xh,kh,gh);
		    session.delete(elective);
		    ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void updateElective(String xh,String kh,String gh,Integer pscj,Integer kscj){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Elective elective=findElective(xh,kh,gh);
		    if(kscj!=null)
		    elective.setKscj(kscj);
		    if(pscj!=null)
		    elective.setPscj(pscj);
		    session.update(elective);
		    ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void compute(String kh,String gh,int bili){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    List<Elective> electives=findElectives(kh,gh);
		    Iterator<Elective> iter=electives.iterator();
		    while(iter.hasNext()){
		    	Elective elective=iter.next();
		    	double cj1=elective.getPscj()*bili*0.1;
		    	double cj2=elective.getKscj()*(10-bili)*0.1;
		    	double cj3=cj1+cj2;
		    	int zpcj=(int)cj3;
		    	elective.setZpcj(zpcj);
		    	session.update(elective);
		    }
		    ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int sumxf(String xh){
		try{
			Session session=getSession();
			return session.doReturningWork(new ReturningWork<Integer>() {
				public Integer execute(Connection connection) throws SQLException {
					 CallableStatement cs = connection.prepareCall("{call sumxuefen(?,?)}");
					 cs.setObject(1,xh);
					 cs.registerOutParameter(2, Types.INTEGER);
					 cs.executeUpdate();
					 return cs.getInt(2);
				}
			});
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
