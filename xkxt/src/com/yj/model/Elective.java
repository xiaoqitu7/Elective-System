package com.yj.model;
import java.util.*;
public class Elective implements java.io.Serializable{
	private String xh;
	private String kh;
	private String gh;
	private Integer pscj;
	private Integer kscj;
	private Integer zpcj;
	//private Student student;
	public Elective(){
	}
	public Elective(String xh,String kh,String gh){
		this.xh=xh;
		this.kh=kh;
		this.gh=gh;
	}
	public Elective(String xh,String kh,String gh,Integer pscj,Integer kscj,Integer zpcj){
		this.xh=xh;
		this.kh=kh;
		this.gh=gh;
		this.pscj=pscj;
		this.kscj=kscj;
		this.zpcj=zpcj;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public Integer getPscj() {
		return pscj;
	}
	public void setPscj(Integer pscj) {
		this.pscj = pscj;
	}
	public Integer getKscj() {
		return kscj;
	}
	public void setKscj(Integer kscj) {
		this.kscj = kscj;
	}
	public Integer getZpcj() {
		return zpcj;
	}
	public void setZpcj(Integer zpcj) {
		this.zpcj = zpcj;
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
	/*public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	*/
}
