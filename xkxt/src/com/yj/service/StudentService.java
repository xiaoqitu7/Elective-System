package com.yj.service;

import java.util.Set;

import com.yj.model.*;

public interface StudentService {
	public Student validate(String xh,String kl);
	public Student findStudent(String xh);
}
