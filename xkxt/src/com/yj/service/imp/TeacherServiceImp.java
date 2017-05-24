package com.yj.service.imp;

import com.yj.dao.TeacherDao;
import com.yj.model.Teacher;
import com.yj.service.TeacherService;

public class TeacherServiceImp implements TeacherService{
	private TeacherDao teacherdao;

	public Teacher validate(String gh, String kl) {
		return teacherdao.validate(gh, kl);
	}

	public TeacherDao getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}
	
	
}
