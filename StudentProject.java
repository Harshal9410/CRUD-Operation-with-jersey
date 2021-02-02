package com.spms.ws.pojo;

public class StudentProject {

	int student_no;
	int project_no;
	String Designation;
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	@Override
	public String toString() {
		return "StudentProject [student_no=" + student_no + ", project_no=" + project_no + ", Designation="
				+ Designation + "]";
	}
	
}
