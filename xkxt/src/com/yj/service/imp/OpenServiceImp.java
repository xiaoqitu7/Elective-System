package com.yj.service.imp;

import java.util.List;

import com.yj.model.Open;
import com.yj.service.*;
import com.yj.dao.*;

public class OpenServiceImp implements OpenService{
	private OpenDao opendao;
	public void addOpen(Open open){
		opendao.addOpen(open);
	}
	public void editOpen(String kh,String gh,String sksj,Integer rs){
		opendao.editOpen(kh, gh, sksj, rs);
	}
	public List<Open> getOpencourses() {
		return opendao.getOpencourses();
	}
	public void delOpen(String kh,String gh){
		opendao.delOpen(kh, gh);
	}
	public Open getOpencourse(String kh, String gh) {
		return opendao.getOpencourse(kh, gh);
	}

	public OpenDao getOpendao() {
		return opendao;
	}

	public void setOpendao(OpenDao opendao) {
		this.opendao = opendao;
	}
}
