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

import com.chinna.employeeservices.entity.Department;
import com.chinna.employeeservices.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.OK);
	}
	
	@GetMapping("/getDepartment/{id}")
	public Department getDepartment(@PathVariable int id) {
		return departmentService.getDepartment(id);
	}
	
	@PutMapping("/updateDepartment")
	public Department updateDepartment(@RequestBody Department department){
		return departmentService.updateDepartment(department);
	}
	
}
