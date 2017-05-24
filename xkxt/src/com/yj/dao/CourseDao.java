package com.yj.dao;
import java.util.*;
import com.yj.model.*;

public interface CourseDao {
	public List<Course> getCourses();
	public List<Course> findCourses(String km,String kh,int xf);
	public List<Course> findCourses(String km,String kh);
}
