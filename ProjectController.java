package com.spms.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spms.ws.dao.Project_Impl;
import com.spms.ws.pojo.Project;
import com.spms.ws.pojo.Response;
import com.spms.ws.pojo.Student;

@Path("/project")
public class ProjectController {

	Project_Impl pi = new Project_Impl();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> list() {
		List<Project> projectList = new ArrayList<Project>();
		projectList = pi.getProjectp();
		return projectList;
	}

	@POST
	@Path("/addProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(Project project) {
		Response response = new Response();
		Boolean isAdded = pi.add_Project(project);
		if (isAdded) {
			response.setMessage("Project added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Project added failed");
			response.setStatus(false);
		}
		return response;
	}

	@PUT
	@Path("/updateProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProject(Project project) {
		Response response = new Response();
		Boolean isUpdate = pi.updateProject(project);
		if (isUpdate) {
			response.setMessage("Project added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Project added failed");
			response.setStatus(false);
		}
		return response;
	}

	@DELETE
	@Path("{projectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response deleteProject(@PathParam("projectId") int projectId) {
		Response response = new Response();
		Boolean isDelete = pi.deleteProject(projectId);
		if (isDelete) {
			response.setMessage("Project added successfully");
			response.setStatus(true);
		} else {
			response.setMessage("Project added failed");
			response.setStatus(false);
		}
		return response;
	}
}