package com.yj.action;

import java.util.*;
import com.yj.model.*;
import com.yj.service.*;
import com.opensymphony.xwork2.*;

public class QueryCourseAction extends ActionSupport {
	protected CourseInfoService courseinfoservice;
	protected ElectiveService electiveservice;
	protected OpenService openservice;
	private String kh;
	private String km;
	private String xm;
	private boolean rswm;
	private Integer xf;
	CourseInfo course;

	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		List<CourseInfo> querycourses = courseinfoservice.getCourses();
		session.put("querycourses", querycourses);
		Student student = (Student) session.get("student");
		if(student!=null)
		return "success";
		else 
			return "successa";
	}

	public String searchCourse() throws Exception {
		Map session = ActionContext.getContext().getSession();
		List<CourseInfo> querycourses = new ArrayList<CourseInfo>();
		if (kh == null)
			kh = "";
		if (km == null)
			km = "";
		if (xm == null)
			xm = "";
		if (xf == null)
			querycourses = courseinfoservice.findCourses(km, kh, xm, rswm);
		else
			querycourses = courseinfoservice.findCourses(km, kh, xf, xm, rswm);
		session.put("querycourses", querycourses);
		kh = null;
		km = null;
		xm = null;
		xf = null;
		rswm = false;
		return "success";
	}

	public String addElective() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		Student student = (Student) session.get("student");
		if (electiveservice.findIfElective(student.getXh(), course.getKh()) == null) {
			int table[][] = new int[10][20];
			List<CourseInfo> queryelective = courseinfoservice.findCourses(student);
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
						if (j + 1 != fgjs.length) {
							int js1 = Integer.parseInt(fgjs[j]);
							int js2 = Integer.parseInt(fgjs[j + 1]);
							if ((js2 - js1) != 1) {
								fgjs = Arrays.copyOf(fgjs, fgjs.length + 1);
								fgjs[j + 2] = fgjs[j + 1];
								fgjs[j + 1] = Integer.toString(js1 + 1);
							}
						}
						if (fgjs[j].equals("1")) {
							if (skxq == '一')
								table[1][1] = 1;
							if (skxq == '二')
								table[2][1] = 1;
							if (skxq == '三')
								table[3][1] = 1;
							if (skxq == '四')
								table[4][1] = 1;
							if (skxq == '五')
								table[5][1] = 1;
						}
						if (fgjs[j].equals("2")) {
							if (skxq == '一')
								table[1][2] = 1;
							if (skxq == '二')
								table[2][2] = 1;
							if (skxq == '三')
								table[3][2] = 1;
							if (skxq == '四')
								table[4][2] = 1;
							if (skxq == '五')
								table[5][2] = 1;

						}
						if (fgjs[j].equals("3")) {
							if (skxq == '一')
								table[1][3] = 1;
							if (skxq == '二')
								table[2][3] = 1;
							if (skxq == '三')
								table[3][3] = 1;
							if (skxq == '四')
								table[4][3] = 1;
							if (skxq == '五')
								table[5][3] = 1;

						}
						if (fgjs[j].equals("4")) {
							if (skxq == '一')
								table[1][4] = 1;
							if (skxq == '二')
								table[2][4] = 1;
							if (skxq == '三')
								table[3][4] = 1;
							if (skxq == '四')
								table[4][4] = 1;
							if (skxq == '五')
								table[5][4] = 1;

						}
						if (fgjs[j].equals("5")) {
							if (skxq == '一')
								table[1][5] = 1;
							if (skxq == '二')
								table[2][5] = 1;
							if (skxq == '三')
								table[3][5] = 1;
							if (skxq == '四')
								table[4][5] = 1;
							if (skxq == '五')
								table[5][5] = 1;
						}
						if (fgjs[j].equals("6")) {
							if (skxq == '一')
								table[1][6] = 1;
							if (skxq == '二')
								table[2][6] = 1;
							if (skxq == '三')
								table[3][6] = 1;
							if (skxq == '四')
								table[4][6] = 1;
							if (skxq == '五')
								table[5][6] = 1;
						}
						if (fgjs[j].equals("7")) {
							if (skxq == '一')
								table[1][7] = 1;
							if (skxq == '二')
								table[2][7] = 1;
							if (skxq == '三')
								table[3][7] = 1;
							if (skxq == '四')
								table[4][7] = 1;
							if (skxq == '五')
								table[5][7] = 1;
						}
						if (fgjs[j].equals("8")) {
							if (skxq == '一')
								table[1][8] = 1;
							if (skxq == '二')
								table[2][8] = 1;
							if (skxq == '三')
								table[3][8] = 1;
							if (skxq == '四')
								table[4][8] = 1;
							if (skxq == '五')
								table[5][8] = 1;

						}
						if (fgjs[j].equals("9")) {
							if (skxq == '一')
								table[1][9] = 1;
							if (skxq == '二')
								table[2][9] = 1;
							if (skxq == '三')
								table[3][9] = 1;
							if (skxq == '四')
								table[4][9] = 1;
							if (skxq == '五')
								table[5][9] = 1;
						}
						if (fgjs[j].equals("10")) {
							if (skxq == '一')
								table[1][10] = 1;
							if (skxq == '二')
								table[2][10] = 1;
							if (skxq == '三')
								table[3][10] = 1;
							if (skxq == '四')
								table[4][10] = 1;
							if (skxq == '五')
								table[5][10] = 1;
						}
						if (fgjs[j].equals("11")) {
							if (skxq == '一')
								table[1][11] = 1;
							if (skxq == '二')
								table[2][11] = 1;
							if (skxq == '三')
								table[3][11] = 1;
							if (skxq == '四')
								table[4][11] = 1;
							if (skxq == '五')
								table[5][11] = 1;
						}
						if (fgjs[j].equals("12")) {
							if (skxq == '一')
								table[1][12] = 1;
							if (skxq == '二')
								table[2][12] = 1;
							if (skxq == '三')
								table[3][12] = 1;
							if (skxq == '四')
								table[4][12] = 1;
							if (skxq == '五')
								table[5][12] = 1;
						}
						if (fgjs[j].equals("13")) {
							if (skxq == '一')
								table[1][13] = 1;
							if (skxq == '二')
								table[2][13] = 1;
							if (skxq == '三')
								table[3][13] = 1;
							if (skxq == '四')
								table[4][13] = 1;
							if (skxq == '五')
								table[5][13] = 1;
						}
					}
				}
			}
			String[] esksj = course.getSksj().split(" ");
			boolean flag = true;
			for (int i = 0; i < esksj.length; i++) {
				char skxq = esksj[i].charAt(0);
				String skjs = esksj[i].substring(1);
				String[] fgjs = skjs.split("-");
				for (int j = 0; j < fgjs.length; j++) {
					if (fgjs[j].equals("1")) {
						if (skxq == '一')
							if (table[1][1] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][1] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][1] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][1] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][1] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("2")) {
						if (skxq == '一')
							if (table[1][2] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][2] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][2] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][2] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][2] == 1) {
								flag = false;
								break;
							}

					}
					if (fgjs[j].equals("3")) {
						if (skxq == '一')
							if (table[1][3] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][3] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][3] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][3] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][3] == 1) {
								flag = false;
								break;
							}

					}
					if (fgjs[j].equals("4")) {
						if (skxq == '一')
							if (table[1][4] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][4] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][4] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][4] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][4] == 1) {
								flag = false;
								break;
							}

					}
					if (fgjs[j].equals("5")) {
						if (skxq == '一')
							if (table[1][5] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][5] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][5] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][5] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][5] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("6")) {
						if (skxq == '一')
							if (table[1][6] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][6] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][6] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][6] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][6] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("7")) {
						if (skxq == '一')
							if (table[1][7] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][7] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][7] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][7] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][7] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("8")) {
						if (skxq == '一')
							if (table[1][8] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][8] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][8] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][8] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][8] == 1) {
								flag = false;
								break;
							}

					}
					if (fgjs[j].equals("9")) {
						if (skxq == '一')
							if (table[1][9] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][9] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][9] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][9] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][9] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("10")) {
						if (skxq == '一')
							if (table[1][10] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][10] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][10] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][10] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][10] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("11")) {
						if (skxq == '一')
							if (table[1][11] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][11] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][11] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][11] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][11] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("12")) {
						if (skxq == '一')
							if (table[1][12] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][12] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][12] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][12] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][12] == 1) {
								flag = false;
								break;
							}
					}
					if (fgjs[j].equals("13")) {
						if (skxq == '一')
							if (table[1][13] == 1) {
								flag = false;
								break;
							}
						if (skxq == '二')
							if (table[2][13] == 1) {
								flag = false;
								break;
							}
						if (skxq == '三')
							if (table[3][13] == 1) {
								flag = false;
								break;
							}
						if (skxq == '四')
							if (table[4][13] == 1) {
								flag = false;
								break;
							}
						if (skxq == '五')
							if (table[5][13] == 1) {
								flag = false;
								break;
							}
					}
					if (j + 1 != fgjs.length) {
						int js1 = Integer.parseInt(fgjs[j]);
						int js2 = Integer.parseInt(fgjs[j + 1]);
						if ((js2 - js1) != 1) {
							fgjs = Arrays.copyOf(fgjs, fgjs.length + 1);
							fgjs[j + 2] = fgjs[j + 1];
							fgjs[j + 1] = Integer.toString(js1 + 1);
						}
					}
				}
				if (flag == false)
					break;
			}
			if (flag == true) {
				Open open = openservice.getOpencourse(course.getKh(), course.getGh());
				if (open.getElectstudents().size() == open.getRs()) {
					request.put("tipMessage", "课程人数已满!");
					return "error";
				} else {
					electiveservice.addElective(student.getXh(), course.getKh(), course.getGh());
					return "success";
				}
			} else {
				request.put("tipMessage", "课时冲突!");
				return "error";
			}
		} else {
			request.put("tipMessage", "重复选课!");
			return "error";
		}
	}

	public CourseInfoService getCourseinfoservice() {
		return courseinfoservice;
	}

	public void setCourseinfoservice(CourseInfoService courseinfoservice) {
		this.courseinfoservice = courseinfoservice;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public boolean getRswm() {
		return rswm;
	}

	public void setRswm(boolean rswm) {
		this.rswm = rswm;
	}

	public int getXf() {
		return xf;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

	public void setXf(Integer xf) {
		this.xf = xf;
	}

	public CourseInfo getCourse() {
		return course;
	}

	public void setCourse(CourseInfo course) {
		this.course = course;
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
