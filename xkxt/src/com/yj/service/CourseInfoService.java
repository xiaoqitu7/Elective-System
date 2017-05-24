package com.yj.service;

import java.util.*;

import com.yj.model.CourseInfo;
import com.yj.model.Student;
import com.yj.model.Teacher;

public interface CourseInfoService {
	public List<CourseInfo> getCourses();
	public List<CourseInfo> findCourses(Teacher teacher);
	public List<CourseInfo> findCourses(Student student);
	public List<CourseInfo> findCourses(String km,String kh,int xf,String xm,boolean rswm);
	public List<CourseInfo> findCourses(String km,String kh,String xm,boolean rswm);
}
