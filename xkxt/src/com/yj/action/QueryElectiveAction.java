package com.yj.action;

import java.util.*;
import com.yj.model.*;
import com.yj.service.*;
import com.opensymphony.xwork2.*;

public class QueryElectiveAction extends ActionSupport {
	protected CourseInfoService courseinfoservice;
	protected OpenService openservice;
	protected ElectiveService electiveservice;
	CourseInfo elective;

	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Student student = (Student) session.get("student");
		List<CourseInfo> queryelective = courseinfoservice.findCourses(student);
		session.put("queryelective", queryelective);
		int xf=electiveservice.sumxf(student.getXh());
		session.put("xuefen",xf);
		return "success";
	}

	public String CourseTable() throws Exception {
		//int table[][] = new int[5][13];
		Map session = ActionContext.getContext().getSession();
		Student student = (Student) session.get("student");
		List<CourseInfo> queryelective = courseinfoservice.findCourses(student);
		CourseTable coursetable1 = new CourseTable();
		CourseTable coursetable2 = new CourseTable();
		CourseTable coursetable3 = new CourseTable();
		CourseTable coursetable4 = new CourseTable();
		CourseTable coursetable5 = new CourseTable();
		CourseTable coursetable6 = new CourseTable();
		CourseTable coursetable7 = new CourseTable();
		CourseTable coursetable8 = new CourseTable();
		CourseTable coursetable9 = new CourseTable();
		CourseTable coursetable10 = new CourseTable();
		CourseTable coursetable11 = new CourseTable();
		CourseTable coursetable12 = new CourseTable();
		CourseTable coursetable13 = new CourseTable();
		Iterator<CourseInfo> iter = queryelective.iterator();
		while (iter.hasNext()) {
			CourseInfo elective = iter.next();
			String sksj = elective.getSksj();
			String[] coursesksj = sksj.split(" ");
			for (int i = 0; i < coursesksj.length; i++) {
				char skxq = coursesksj[i].charAt(0);
				String skjs = coursesksj[i].substring(1);
				String[] fgjs = skjs.split("-");
				for (int j = 0; j < fgjs.length; j++) {
					if(j+1!=fgjs.length){
				    	int js1=Integer.parseInt(fgjs[j]);
					    int js2=Integer.parseInt(fgjs[j+1]);
					    if((js2-js1)!=1)
				    	{
					    	fgjs=Arrays.copyOf(fgjs,fgjs.length+1);
						    fgjs[j+2]=fgjs[j+1];
						    fgjs[j+1]=Integer.toString(js1+1);
					    }
					}
					if (fgjs[j].equals("1")) {
						if (skxq == '一')
							coursetable1.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable1.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable1.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable1.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable1.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("2")) {
						if (skxq == '一')
							coursetable2.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable2.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable2.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable2.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable2.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("3")) {
						if (skxq == '一')
							coursetable3.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable3.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable3.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable3.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable3.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("4")) {
						if (skxq == '一')
							coursetable4.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable4.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable4.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable4.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable4.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("5")) {
						if (skxq == '一')
							coursetable5.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable5.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable5.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable5.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable5.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("6")) {
						if (skxq == '一')
							coursetable6.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable6.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable6.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable6.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable6.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("7")) {
						if (skxq == '一')
							coursetable7.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable7.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable7.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable7.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable7.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("8")) {
						if (skxq == '一')
							coursetable8.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable8.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable8.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable8.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable8.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("9")) {
						if (skxq == '一')
							coursetable9.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable9.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable9.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable9.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable9.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("10")) {
						if (skxq == '一')
							coursetable10.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable10.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable10.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable10.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable10.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("11")) {
						if (skxq == '一')
							coursetable11.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable11.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable11.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable11.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable11.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("12")) {
						if (skxq == '一')
							coursetable12.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable12.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable12.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable12.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable12.setKm5(elective.getKm());
					}
					if (fgjs[j].equals("13")) {
						if (skxq == '一')
							coursetable13.setKm1(elective.getKm());
						if (skxq == '二')
							coursetable13.setKm2(elective.getKm());
						if (skxq == '三')
							coursetable13.setKm3(elective.getKm());
						if (skxq == '四')
							coursetable13.setKm4(elective.getKm());
						if (skxq == '五')
							coursetable13.setKm5(elective.getKm());
					}
				}
			}
		}
		session.put("coursetable1", coursetable1);
		session.put("coursetable2", coursetable2);
		session.put("coursetable3", coursetable3);
		session.put("coursetable4", coursetable4);
		session.put("coursetable5", coursetable5);
		session.put("coursetable6", coursetable6);
		session.put("coursetable7", coursetable7);
		session.put("coursetable8", coursetable8);
		session.put("coursetable9", coursetable9);
		session.put("coursetable10", coursetable10);
		session.put("coursetable11", coursetable11);
		session.put("coursetable12", coursetable11);
		session.put("coursetable13", coursetable13);
		return "success";
	}

	public String delElective() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Student student = (Student) session.get("student");
		electiveservice.delElective(student.getXh(), elective.getKh(),elective.getGh());
		return "success";
	}

	public CourseInfoService getCourseinfoservice() {
		return courseinfoservice;
	}

	public void setCourseinfoservice(CourseInfoService courseinfoservice) {
		this.courseinfoservice = courseinfoservice;
	}

	public CourseInfo getElective() {
		return elective;
	}

	public void setElective(CourseInfo elective) {
		this.elective = elective;
	}

	public OpenService getOpenservice() {
		return openservice;
	}

	public void setOpenservice(OpenService openservice) {
		this.openservice = openservice;
	}

	public ElectiveService getElectiveservice() {
		return electiveservice;
	}

	public void setElectiveservice(ElectiveService electiveservice) {
		this.electiveservice = electiveservice;
	}

}
