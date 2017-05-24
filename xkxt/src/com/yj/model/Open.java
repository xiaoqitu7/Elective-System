package com.yj.model;
import java.util.*;
public class Open implements java.io.Serializable{
	private String kh;
	private String gh;
	private String sksj;
	private Integer rs;
	private Teacher teacher;
	private Course course;
	private Set<Student> electstudents=new HashSet<Student>();
	public Open(){
	}
	public Open(String kh,String gh){
		this.kh=kh;
		this.gh=gh;
	}
	public Open(String kh,String gh,String sksj,Integer rs){
		this.kh=kh;
		this.gh=gh;
		this.sksj=sksj;
		this.rs=rs;
	}

	public String getKh() {
		return kh;
	}
	public void setKh(String kh) {
		this.kh = kh;
	}
	public String getGh() {
		return gh;
	}
	public void setGh(String gh) {
		this.gh = gh;
	}
	public String getSksj() {
		return sksj;
	}
	public void setSksj(String sksj) {
		this.sksj = sksj;
	}
	public Integer getRs() {
		return rs;
	}
	public void setRs(Integer rs) {
		this.rs = rs;
	}
	public Set<Student> getElectstudents() {
		return electstudents;
	}
	public void setElectstudents(Set<Student> electstudents) {
		this.electstudents = electstudents;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
