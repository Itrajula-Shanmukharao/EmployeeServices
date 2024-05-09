package com.chinna.employeeservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinna.employeeservices.entity.Project;
import com.chinna.employeeservices.reposiory.ProjectRepository;

@Service
public class ProjectServiceIMPL implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project getProject(int id) {
		return projectRepository.findById(id).get();
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

}
