package com.yj.dao.imp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import com.yj.dao.*;
import com.yj.model.*;

public class StudentDaoImp extends BaseDao implements StudentDao{

	public Student validate(String xh,String kl){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
	    Query query=session.createQuery("from Student where xh=? and kl=?");
		query.setParameter(0,xh);
		query.setParameter(1,kl);
		Student student=(Student)query.uniqueResult();
		ts.commit();
		session.close();
		return student;
	}
	public Student findStudent(String xh){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
	    Query query=session.createQuery("from Student where xh=?");
		query.setParameter(0,xh);
		Student student=(Student)query.uniqueResult();
		ts.commit();
		session.close();
		return student;
	}
}
