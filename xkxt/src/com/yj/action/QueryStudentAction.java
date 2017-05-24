package com.yj.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yj.model.*;
import com.yj.service.ElectiveService;
import com.yj.service.StudentService;

public class QueryStudentAction extends ActionSupport {
	protected ElectiveService electiveservice;
	CourseInfo open;
	Integer pscj;
	Integer kscj;
	String xh;
	int bili;
	protected StudentService studentservice;
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Teacher teacher=(Teacher) session.get("teacher");
		session.put("kh", open.getKh());
		List<Elective> electives=electiveservice.findElectives(open.getKh(), teacher.getGh());
		Iterator<Elective> its=electives.iterator();
		List<StudentInfo> studentsinfo=new ArrayList<StudentInfo>();
		while(its.hasNext()){
			Elective elective=its.next();
			StudentInfo studentinfo=new StudentInfo();
			studentinfo.setXh(elective.getXh());
			studentinfo.setXm(studentservice.findStudent(elective.getXh()).getXm());
			studentinfo.setPscj(elective.getPscj());
			studentinfo.setKscj(elective.getKscj());
			studentinfo.setZpcj(elective.getZpcj());
			studentsinfo.add(studentinfo);
		}
		session.put("querystudent",studentsinfo);
		return "success";
	}
	public String editGrade() throws Exception{
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		Teacher teacher=(Teacher) session.get("teacher");
		String kh=(String) session.get("kh");
		String xxxh=(String) session.get("xxxh");
		electiveservice.updateElective(xxxh, kh, teacher.getGh(), pscj, kscj);
		pscj=null;
		kscj=null;
		return "success";
	}
	public String modal()throws Exception{
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		session.put("xxxh", xh);
		request.put("modal", "1");
		return "success";
	}
	public String computezpcj()throws Exception{
		Map session = ActionContext.getContext().getSession();
		Teacher teacher=(Teacher) session.get("teacher");
		String kh=(String) session.get("kh");
		electiveservice.compute(kh, teacher.getGh(), bili);
		return "success";
	}
	public ElectiveService getElectiveservice() {
		return electiveservice;
	}
	public void setElectiveservice(ElectiveService electiveservice) {
		this.electiveservice = electiveservice;
	}
	public CourseInfo getOpen() {
		return open;
	}
	public void setOpen(CourseInfo open) {
		this.open = open;
	}
	public StudentService getStudentservice() {
		return studentservice;
	}
	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
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
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public int getBili() {
		return bili;
	}
	public void setBili(int bili) {
		this.bili = bili;
	}
	
}
