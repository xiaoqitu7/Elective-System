package com.yj.dao;

import java.util.*;
import com.yj.model.*;

public interface StudentDao {
	public Student validate(String xh,String kl);
	public Student findStudent(String xh);
}
