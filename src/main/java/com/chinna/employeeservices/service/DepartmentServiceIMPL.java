package com.chinna.employeeservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinna.employeeservices.entity.Department;
import com.chinna.employeeservices.reposiory.DepartmentRepository;

@Service
public class DepartmentServiceIMPL implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
	
	public Department getDepartment(int id) {
		return departmentRepository.findById(id).get();
	}
	
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
}
