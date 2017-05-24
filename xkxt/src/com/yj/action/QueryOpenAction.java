package com.yj.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yj.model.CourseInfo;
import com.yj.model.Teacher;
import com.yj.service.CourseInfoService;

public class QueryOpenAction extends ActionSupport{
	protected CourseInfoService courseinfoservice;
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Teacher teacher=(Teacher) session.get("teacher");
		List<CourseInfo> queryopen=courseinfoservice.findCourses(teacher);
		session.put("queryopen",queryopen);
		return "success";
	}
	public CourseInfoService getCourseinfoservice() {
		return courseinfoservice;
	}
	public void setCourseinfoservice(CourseInfoService courseinfoservice) {
		this.courseinfoservice = courseinfoservice;
	}
}
