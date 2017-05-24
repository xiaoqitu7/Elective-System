package com.yj.dao.imp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import com.yj.dao.*;
import com.yj.model.Student;
import com.yj.model.Teacher;

public class TeacherDaoImp extends BaseDao implements TeacherDao{
	public Teacher validate(String gh,String kl){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
	    Query query=session.createQuery("from Teacher where gh=? and kl=?");
		query.setParameter(0,gh);
		query.setParameter(1,kl);
		Teacher teacher=(Teacher)query.uniqueResult();
		ts.commit();
		session.close();
		return teacher;
	}
}
