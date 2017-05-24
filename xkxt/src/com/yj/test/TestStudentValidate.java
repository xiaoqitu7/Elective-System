package com.yj.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yj.model.*;
import com.yj.service.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestStudentValidate{
	@Autowired
	private StudentService student;
	@Test
	public void Testservice() {
	   Student student1=student.validate("1101","123123");
	   if(student1!=null)
		   System.out.println("1");
	}
}