package com.chinna.employeeservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinna.employeeservices.entity.Project;
import com.chinna.employeeservices.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}
	
	@GetMapping("/getAllProjects")
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@GetMapping("/getProject/{id}")
	public Project getProject(@PathVariable int id) {
		return projectService.getProject(id);
	}
	
	@PutMapping("/updateProject")
	public Project updateProject(@RequestBody Project project) {
		return projectService.updateProject(project);
	}

}
