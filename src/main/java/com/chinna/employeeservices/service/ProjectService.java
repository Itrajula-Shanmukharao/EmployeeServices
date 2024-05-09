package com.chinna.employeeservices.service;

import java.util.List;

import com.chinna.employeeservices.entity.Project;

public interface ProjectService {
	
	public Project addProject(Project project);
	public List<Project> getAllProjects();
	public Project getProject(int id);
	public Project updateProject(Project project);
}
