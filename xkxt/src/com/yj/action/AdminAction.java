package com.yj.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.yj.model.Open;
import com.yj.service.OpenService;

public class AdminAction {
	protected OpenService openservice;
	String kh;
	String gh;
	String sksj;
	Integer rs;
	Open open;
	Open course;
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		session.put("kh", kh);
		session.put("gh", gh);
		request.put("modal", "1");
		return "success";
	}
	public String editOpen() throws Exception{
		Map session = ActionContext.getContext().getSession();
		String kkh=(String) session.get("kh");
		String ggh=(String) session.get("gh");
		openservice.editOpen(kkh, ggh, sksj, rs);
		sksj="";
		rs=null;
		return "success";
	}
	public String addOpen() throws Exception{
		openservice.addOpen(open);
		return "success";
	}
	public String delOpen() throws Exception{
		openservice.delOpen(course.getKh(),course.getGh());
		return "success";
	}
	public OpenService getOpenservice() {
		return openservice;
	}
	public void setOpenservice(OpenService openservice) {
		this.openservice = openservice;
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
	public Open getOpen() {
		return open;
	}
	public void setOpen(Open open) {
		this.open = open;
	}
	public void setRs(Integer rs) {
		this.rs = rs;
	}
	public Integer getRs() {
		return rs;
	}
	public Open getCourse() {
		return course;
	}
	public void setCourse(Open course) {
		this.course = course;
	}
	
}
