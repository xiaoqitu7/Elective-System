package com.yj.dao.imp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import com.yj.dao.*;
import com.yj.model.Open;

public class OpenDaoImp extends BaseDao implements OpenDao{
	public List<Open> getOpencourses() {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Open order by kh");
		    List list=query.list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Open getOpencourse(String kh,String gh) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Open where kh= ? and gh= ? ");
		    query.setParameter(0, kh);
			query.setParameter(1, gh);
		    Open open=(Open)query.uniqueResult();
			ts.commit();
			session.close();
			return open;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void editOpen(String kh,String gh,String sksj,Integer rs){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Open open=getOpencourse(kh,gh);
		    if(rs!=null)
		    open.setRs(rs);
		    if(!sksj.equals(""))
		    open.setSksj(sksj);
		    session.update(open);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void addOpen(Open open){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    session.save(open);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delOpen(String kh,String gh){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Open open=getOpencourse(kh,gh);
		    session.delete(open);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}