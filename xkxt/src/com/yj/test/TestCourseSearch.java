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
public class TestCourseSearch {
	@Autowired
	private CourseInfoService info;
	@Test
	public void Testservice() {
	    List coursesinfo=info.findCourses("","","",true);
	    Iterator its=coursesinfo.iterator();  
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
	 //   boolean flag=student.validate("1101","123123");
	 //   System.out.println(flag);
	}
}