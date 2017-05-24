package com.yj.model;
import java.util.*;
public class Teacher implements java.io.Serializable{
	private String gh;
	private String xm;
	private String yxh;
	private String kl;
	private Set<Open> opencourses=new HashSet<Open>();
	private Department department;
	public Teacher(){
	}
	public Teacher(String gh){
		this.gh=gh;
	}
	public Teacher(String gh,String xm,String yxh,String kl){
		this.gh=gh;
		this.xm=xm;
		this.yxh=yxh;
	    this.kl=kl;
	}
	public String getGh() {
		return gh;
	}
	public void setGh(String gh) {
		this.gh = gh;
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
	public Set<Open> getOpencourses() {
		return opencourses;
	}
	public void setOpencourses(Set<Open> opencourses) {
		this.opencourses = opencourses;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
