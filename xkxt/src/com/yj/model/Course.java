package com.yj.model;
import java.util.*;
public class Course implements java.io.Serializable{
	private String kh;
	private String km;
	private Integer xf;
	private String yxh;
	private Set<Open> opencourses=new HashSet<Open>();
	public Course(){
	}
	public Course(String kh){
		this.kh=kh;
	}
	public Course(String kh,String km,int xf,String yxh)
	{
		this.kh=kh;
		this.km=km;
		this.xf=xf;
		this.yxh=yxh;
	}
	public String getKh() {
		return kh;
	}
	public void setKh(String kh) {
		this.kh = kh;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public int getXf() {
		return xf;
	}
	public void setXf(Integer xf) {
		this.xf = xf;
	}
	public String getYxh() {
		return yxh;
	}
	public void setYxh(String yxh) {
		this.yxh = yxh;
	}
	public Set<Open> getOpencourses() {
		return opencourses;
	}
	public void setOpencourses(Set<Open> opencourses) {
		this.opencourses = opencourses;
	}
    
}
