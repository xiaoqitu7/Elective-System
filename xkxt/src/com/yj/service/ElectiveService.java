package com.yj.service;

import java.util.List;

import com.yj.model.Elective;

public interface ElectiveService {
	public Elective findElective(String xh,String kh,String gh);
	public Elective findIfElective(String xh,String kh);
    public List<Elective> findElectives(String kh,String gh);
	public void addElective(String xh,String kh,String gh);
	public void delElective(String xh,String kh,String gh);
	public void updateElective(String xh,String kh,String gh,Integer pscj,Integer kscj);
	public void compute(String kh,String gh,int bili);
	public int sumxf(String xh);
}
