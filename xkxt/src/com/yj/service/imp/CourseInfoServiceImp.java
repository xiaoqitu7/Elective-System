package com.yj.service.imp;

import java.util.*;
import com.yj.model.*;
import com.yj.service.*;
import com.yj.dao.*;

public class CourseInfoServiceImp implements CourseInfoService {
	private CourseDao coursedao;
	private OpenDao opendao;
	private StudentDao studentdao;
	public List<CourseInfo> getCourses(){
		 List<CourseInfo> coursesinfo=new ArrayList<CourseInfo>();
		 List<Open> opencourses=opendao.getOpencourses();
		 Iterator<Open> its=opencourses.iterator();
		 while(its.hasNext()){
			 Open opencourse=its.next();
			 CourseInfo courseinfo=new CourseInfo();
			 courseinfo.setKh(opencourse.getKh());
			 courseinfo.setGh(opencourse.getGh());
			 courseinfo.setKm(opencourse.getCourse().getKm());
			 courseinfo.setRs(opencourse.getRs());
			 courseinfo.setSksj(opencourse.getSksj());
			 courseinfo.setXf(opencourse.getCourse().getXf());
			 courseinfo.setXm(opencourse.getTeacher().getXm());
			 courseinfo.setDqrs(opencourse.getElectstudents().size());
			 coursesinfo.add(courseinfo);
		 }
		 return coursesinfo;
	}
	public List<CourseInfo> findCourses(Teacher teacher){
		 List<CourseInfo> coursesinfo=new ArrayList<CourseInfo>();
		 Set<Open> opencourses=teacher.getOpencourses();
		 List<Open> opens=new ArrayList<Open>(opencourses);
		 Collections.sort(opens, new Comparator<Open>(){  
			 public int compare(Open o1,Open o2) {  
				 return o1.getKh().compareTo(o2.getKh());
			    }
		 });
		 Iterator<Open> its=opens.iterator();
		 while(its.hasNext()){
			 Open opencourse=its.next();
			 CourseInfo courseinfo=new CourseInfo();
			 courseinfo.setKh(opencourse.getKh());
			 //courseinfo.setGh(opencourse.getGh());
			 courseinfo.setKm(opencourse.getCourse().getKm());
			 //courseinfo.setRs(opencourse.getRs());
			 courseinfo.setSksj(opencourse.getSksj());
			 courseinfo.setXf(opencourse.getCourse().getXf());
			 //courseinfo.setXm(opencourse.getTeacher().getXm());
			 //courseinfo.setDqrs(opencourse.getElectstudents().size());
			 coursesinfo.add(courseinfo);
		 }
		 return coursesinfo;
		
	}
	public List<CourseInfo> findCourses(Student student){
		 List<CourseInfo> coursesinfo=new ArrayList<CourseInfo>();
		 Student stu=studentdao.findStudent(student.getXh());
		 Set<Open> opencourses=stu.getElectcourses();
		 List<Open> opens=new ArrayList<Open>(opencourses);
		 Collections.sort(opens, new Comparator<Open>(){  
			 public int compare(Open o1,Open o2) {  
				 return o1.getKh().compareTo(o2.getKh());
			    }
		 });
		 Iterator<Open> its=opens.iterator();
		 while(its.hasNext()){
			 Open opencourse=its.next();
			 CourseInfo courseinfo=new CourseInfo();
			 courseinfo.setKh(opencourse.getKh());
			 courseinfo.setGh(opencourse.getGh());
			 courseinfo.setKm(opencourse.getCourse().getKm());
			 //courseinfo.setRs(opencourse.getRs());
			 courseinfo.setSksj(opencourse.getSksj());
			 courseinfo.setXf(opencourse.getCourse().getXf());
			 courseinfo.setXm(opencourse.getTeacher().getXm());
			 //courseinfo.setDqrs(opencourse.getElectstudents().size());
			 coursesinfo.add(courseinfo);
		 }
		 return coursesinfo;
		
	}
	public List<CourseInfo> findCourses(String km,String kh,int xf,String xm,boolean rswm){
		 List<CourseInfo> coursesinfo=new ArrayList<CourseInfo>();
		 List<Course> courses=coursedao.findCourses(km,kh,xf);
		 Iterator<Course> its=courses.iterator();  
		 while(its.hasNext()){
			 Course course=its.next();
			 Set<Open> opencourses=course.getOpencourses();
			 Iterator<Open> iter=opencourses.iterator();  
			 while(iter.hasNext()){
				 Open opencourse=iter.next();
				 if(opencourse.getTeacher().getXm().indexOf(xm)!=-1){
					 if(rswm==false||(rswm==true&&opencourse.getElectstudents().size()!=opencourse.getRs())){
				    	 CourseInfo courseinfo=new CourseInfo();
				         courseinfo.setKh(course.getKh());
		                 courseinfo.setKm(course.getKm());
			             courseinfo.setXf(course.getXf());
			             courseinfo.setSksj(opencourse.getSksj());
			             courseinfo.setRs(opencourse.getRs());
			             courseinfo.setGh(opencourse.getGh());
			             courseinfo.setXm(opencourse.getTeacher().getXm());
				         courseinfo.setDqrs(opencourse.getElectstudents().size());
				         coursesinfo.add(courseinfo);
					 }
				 }
			 }
		 }
		 return coursesinfo;
	}
	public List<CourseInfo> findCourses(String km,String kh,String xm,boolean rswm){
		List<CourseInfo> coursesinfo=new ArrayList<CourseInfo>();
		 List<Course> courses=coursedao.findCourses(km,kh);
		 Iterator<Course> its=courses.iterator();  
		 while(its.hasNext()){
			 Course course=its.next();
			 Set<Open> opencourses=course.getOpencourses();
			 Iterator<Open> iter=opencourses.iterator();  
			 while(iter.hasNext()){
				 Open opencourse=iter.next();
				 if(opencourse.getTeacher().getXm().indexOf(xm)!=-1){
					 if(rswm==false||(rswm==true&&opencourse.getElectstudents().size()!=opencourse.getRs())){
				    	 CourseInfo courseinfo=new CourseInfo();
				         courseinfo.setKh(course.getKh());
		                 courseinfo.setKm(course.getKm());
			             courseinfo.setXf(course.getXf());
			             courseinfo.setSksj(opencourse.getSksj());
			             courseinfo.setRs(opencourse.getRs());
			             courseinfo.setGh(opencourse.getGh());
			             courseinfo.setXm(opencourse.getTeacher().getXm());
				         courseinfo.setDqrs(opencourse.getElectstudents().size());
				         coursesinfo.add(courseinfo);
					 }
				 }
			 }
		 }
		 return coursesinfo;
	}
	public CourseDao getCoursedao() {
		return coursedao;
	}
	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}
	public OpenDao getOpendao() {
		return opendao;
	}
	public void setOpendao(OpenDao opendao) {
		this.opendao = opendao;
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	
	
}
