package com.spms.ws.dao;

import java.util.List;

import com.spms.ws.pojo.Student;

public interface Stud_Int {

	public boolean add_stud(Student s);

	public boolean updateStudent(Student s);

	public boolean deleteStudent(Integer studentId);

	public List<Student> getStudents();

}