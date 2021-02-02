package com.spms.ws.dao;

import java.util.List;

import com.spms.ws.pojo.Project;

public interface Project_Int {

	public boolean add_Project(Project p);

	public boolean updateProject(Project p);

	public boolean deleteProject(Integer projectId);

	public List<Project> getProjectp();

}
