package com.yj.service.imp;

import java.util.List;

import com.yj.dao.ElectiveDao;
import com.yj.model.Elective;
import com.yj.service.ElectiveService;

public class ElectiveServiceImp implements ElectiveService{
	private ElectiveDao electivedao;
	public int sumxf(String xh){
		return electivedao.sumxf(xh);
	}
	public Elective findIfElective(String xh,String kh){
		return electivedao.findIfElective(xh, kh);
	}
	public void addElective(String xh, String kh, String gh) {
		electivedao.addElective(xh, kh, gh);
	}

	public void delElective(String xh, String kh,String gh) {
		electivedao.delElective(xh, kh,gh);
	}
	
	public Elective findElective(String xh, String kh,String gh) {
		return electivedao.findElective(xh, kh,gh);
	}
	public List<Elective> findElectives(String kh, String gh) {
		return electivedao.findElectives(kh, gh);
	}

	public ElectiveDao getElectivedao() {
		return electivedao;
	}

	public void setElectivedao(ElectiveDao electivedao) {
		this.electivedao = electivedao;
	}

	public void updateElective(String xh,String kh,String gh,Integer pscj,Integer kscj){
		electivedao.updateElective(xh, kh, gh, pscj, kscj);
	}
	public void compute(String kh,String gh,int bili){
		electivedao.compute(kh, gh, bili);
	}

}
