package com.yj.test;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yj.model.CourseInfo;
import com.yj.service.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestQueryCourse {
	@Autowired
	private CourseInfoService info2;
	@Test
	public void Testservice() {
	    List opens=info2.getCourses();
	    Iterator its=opens.iterator();  
	   // System.out.println(opens.size());
	    while(its.hasNext()){
	      CourseInfo courseinfo=(CourseInfo)its.next();
		  System.out.println(courseinfo.getKm());
		  System.out.println(courseinfo.getKh());
		  System.out.println(courseinfo.getXm());
		  System.out.println(courseinfo.getXf());
		  System.out.println(courseinfo.getSksj());
		  System.out.println(courseinfo.getRs());
		  System.out.println(courseinfo.getDqrs());
	    }
	}
}
