package com.yj.model;

import java.util.*;

public class Student implements java.io.Serializable{
	private String xh;
	private String xm;
	private String yxh;
	private String kl;
	private Set<Open> electcourses=new HashSet<Open>();
	private Department department;
	public Student(){	
	}
	public Student(String xh){
		this.xh=xh;
	}
	public Student(String xh,String xm,String yxh,String kl){
		this.xh=xh;
		this.xm=xm;
		this.yxh=yxh;
		this.kl=kl;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getYxh() {
		return yxh;
	}
	public void setYxh(String yxh) {
		this.yxh = yxh;
	}	
	public String getKl() {
		return kl;
	}
	public void setKl(String kl) {
		this.kl = kl;
	}
	public Set<Open> getElectcourses() {
		return electcourses;
	}
	public void setElectcourses(Set<Open> electcourses) {
		this.electcourses = electcourses;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
