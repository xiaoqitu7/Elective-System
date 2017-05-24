package com.yj.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	protected SessionFactory sessionFactory;
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public Session getSession(){
		Configuration config = new Configuration();  
	    config.configure("/hibernate.cfg.xml");  
	    sessionFactory= config.buildSessionFactory(); 
		Session session=sessionFactory.openSession();
		return session;
	}
}
