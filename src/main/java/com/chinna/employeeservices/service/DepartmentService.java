package com.chinna.employeeservices.service;

import java.util.List;

import com.chinna.employeeservices.entity.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department);
	public List<Department> getAllDepartments();
	public Department getDepartment(int id);
	public Department updateDepartment(Department department);

}
