package com.yj.dao;

import java.util.*;
import com.yj.model.*;

public interface OpenDao {
	public List<Open> getOpencourses();
	public Open getOpencourse(String kh,String gh);
	public void editOpen(String kh,String gh,String sksj,Integer rs);
	public void addOpen(Open open);
	public void delOpen(String kh,String gh);
}
