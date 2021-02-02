package com.spms.ws.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {

	static Connection con = null;

	public static Connection getcon() {

		try {
			if (con == null) {

				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_project", "root", "");

				return con;

			} else {
				return con;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
//		Student_Impl si=new Student_Impl();
//		Student student = new Student();
//		student.setStudent_dob("1995-08-03");
//		student.setStudent_doj("2020-02-15");
//		student.setStudent_name("Harshal");
//		student.setStudent_no(6);
//  	System.out.println(si.add_stud(student));
///		System.out.println(si.updateStudent(student));
///		System.out.println(si.deleteStudent(6));
//		for(Student student1:si.getStudents()) {
//			System.out.println(student1.getStudent_no()+"---"+student1.getStudent_name()+"---"
//			+student1.getStudent_dob()+"---"+student1.getStudent_doj());
//		}

		System.out.println(DbUtility.getcon());
	}
}
