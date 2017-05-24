package com.yj.service.imp;

import com.yj.service.*;

import java.util.Set;

import com.yj.dao.*;
import com.yj.model.*;

public class StudentServiceImp implements StudentService{
	private StudentDao studentdao;
	public Student validate(String xh, String kl) {
		return studentdao.validate(xh, kl);
	}
	public Student findStudent(String xh){
		return studentdao.findStudent(xh);
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	
}
