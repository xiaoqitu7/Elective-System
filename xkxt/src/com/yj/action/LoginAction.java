package com.yj.action;

import java.util.*;

import com.yj.model.*;
import com.yj.service.*;
import com.opensymphony.xwork2.*;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	protected StudentService studentservice;
	protected TeacherService teacherservice;

	public String execute() throws Exception {
		int validated = 0;
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		char sf = username.charAt(0);
		if (sf == '1') {
			Student student = studentservice.validate(username, password);
			if (student != null) {
				session.put("student", student);
				Department department = student.getDepartment();
				session.put("department", department);
				validated = 1;
			}
		}
		if (sf == '2') {
			Teacher teacher = teacherservice.validate(username, password);
			if (teacher != null) {
				session.put("teacher", teacher);
				Department department = teacher.getDepartment();
				session.put("department", department);
				validated = 2;
			}
		}
		if(sf =='3')
		{
			if(username.equals("3101")&&password.equals("31223122")){
				validated=3;
				session.put("admin", 1);
			}
		}
		if (validated == 1)
			return "successs";
		else if (validated == 2)
			return "successt";
		else if(validated==3)
			return "successa";
		else{
			request.put("tipMessage", "账号或密码错误!");
			return "error";
		}
	}

	public StudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherService getTeacherservice() {
		return teacherservice;
	}

	public void setTeacherservice(TeacherService teacherservice) {
		this.teacherservice = teacherservice;
	}
	
}
