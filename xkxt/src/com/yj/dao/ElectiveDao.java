package com.yj.dao;

import java.util.*;

import com.yj.model.Elective;

public interface ElectiveDao {
	public Elective findElective(String xh,String kh,String gh);
	public Elective findIfElective(String xh,String kh);
	//public List<Elective> findElectives(String xh);
	public void addElective(String xh,String kh,String gh);
	public void delElective(String xh,String kh,String gh);
	public List<Elective> findElectives(String kh,String gh);
	public void updateElective(String xh,String kh,String gh,Integer pscj,Integer kscj);
	public void compute(String kh,String gh,int bili);
	public int sumxf(String xh);
}
