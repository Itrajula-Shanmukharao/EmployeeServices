package com.chinna.employeeservices.service;

import java.util.List;

import com.chinna.employeeservices.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public Employee updateEmployee(Employee employee);
	
	public Employee assignProjectToEmployee(int empId,int projectId);
	
	public Employee assignEmployeeToDepartment(int deptId,int empId);
	
	public List<Employee> findByIsActive(boolean isActive);
	
	public List<Employee> findByName(String name);
	
	public List<Employee> findByEmail(String email);
	
	public List<Employee> findByAge(int age);
	
	public List<Employee> findBySalary(double salary);
	
	public List<Employee> getAllEmployeesByNativeQuery();

	public List<Employee> getActiveEmployeesByNativeQuery(boolean isActive);

	public List<Employee> getEmployeesBySalaryUsingNativeQuery(double salary);

	public List<Employee> getEmployeesByAgeUsingNativeQuery(int age);

	public List<Employee> getEmployeesByNameUsingNativeQuery(String name);

	public Employee assignAddressToEmployee(int empId, int addressId);

}
