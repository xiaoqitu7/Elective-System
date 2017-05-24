package com.yj.service;

import java.util.*;
import com.yj.model.*;

public interface OpenService {
	public List<Open> getOpencourses();
	public Open getOpencourse(String kh,String gh);
	public void editOpen(String kh,String gh,String sksj,Integer rs);
	public void addOpen(Open open);
	public void delOpen(String kh,String gh);
}
