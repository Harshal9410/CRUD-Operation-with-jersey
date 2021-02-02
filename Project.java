package com.spms.ws.pojo;

public class Project {
	int project_no;
	String prj_name;
	String prj_dur;
	String prj_platform;

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public String getPrj_name() {
		return prj_name;
	}

	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}

	public String getPrj_dur() {
		return prj_dur;
	}

	public void setPrj_dur(String prj_dur) {
		this.prj_dur = prj_dur;
	}

	public String getPrj_platform() {
		return prj_platform;
	}

	public void setPrj_platform(String prj_platform) {
		this.prj_platform = prj_platform;
	}

	@Override
	public String toString() {
		return "Project [project_no=" + project_no + ", prj_name=" + prj_name + ", prj_dur=" + prj_dur
				+ ", prj_platform=" + prj_platform + "]";
	}

}
