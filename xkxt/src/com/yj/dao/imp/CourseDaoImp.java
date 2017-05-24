package com.yj.dao.imp;

import java.util.*;
import com.yj.dao.*;
import com.yj.model.Course;

import org.hibernate.*;
import org.hibernate.query.Query;

public class CourseDaoImp extends BaseDao implements CourseDao{
	public List<Course> getCourses(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
		    Query query=session.createQuery("from Course order by kh");
		    List<Course> list=query.list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List<Course> findCourses(String km,String kh,int xf){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Course where km like ? and kh like ? and xf= ? ");
			query.setParameter(0, "%"+km+"%");
			query.setParameter(1, "%"+kh+"%");
			query.setParameter(2, xf);
			List<Course> opencourses=query.list();
			ts.commit();
			session.close();
			return opencourses;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
		public List<Course> findCourses(String km,String kh){
			try{
				Session session=getSession();
				Transaction ts=session.beginTransaction();
				Query query=session.createQuery("from Course where km like ? and kh like ?");
				query.setParameter(0, "%"+km+"%");
				query.setParameter(1, "%"+kh+"%");
				List<Course> opencourses=query.list();
				ts.commit();
				session.close();
				return opencourses;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}
}
