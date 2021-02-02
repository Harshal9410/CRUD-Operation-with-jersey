package com.spms.ws.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.spms.ws.dao.Student_Impl;
import com.spms.ws.pojo.Response;
import com.spms.ws.pojo.Student;

@Path("/student")
public class StudentController {

	Student_Impl si = new Student_Impl();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> list() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = si.getStudents();
		return studentList;
	}

	@POST
	@Path("/addStudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		Response response = new Response();
		Boolean isAdded = si.add_stud(student);
		if (isAdded) {
			response.setMessage("Student added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Student added failed");
			response.setStatus(false);
		}
		return response;
	}

	@PUT
	@Path("/updateStudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(Student student) {
		Response response = new Response();
		Boolean isUpdate = si.updateStudent(student);
		if (isUpdate) {
			response.setMessage("Student added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Student added failed");
			response.setStatus(false);
		}
		return response;
	}

	@DELETE
	@Path("{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
//	@PathParam("{studentId}")
	public Response deleteStudent(@PathParam("studentId") int studentId) {
		Response response = new Response();
		Boolean isDelete = si.deleteStudent(studentId);
		if (isDelete) {
			response.setMessage("Student added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Student added failed");
			response.setStatus(false);
		}
		return response;
	}
}
