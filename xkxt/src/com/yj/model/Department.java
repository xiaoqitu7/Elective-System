package com.yj.model;
import java.util.*;
public class Department implements java.io.Serializable{
	private String yxh;
	private String mc;
	public Department(){
	}
	public Department(String yxh){
		this.yxh=yxh;
	}
	public Department(String yxh,String mc){
		this.yxh=yxh;
		this.mc=mc;
	}
	public String getYxh() {
		return yxh;
	}
	public void setYxh(String yxh) {
		this.yxh = yxh;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
}
