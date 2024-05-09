package com.chinna.employeeservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinna.employeeservices.entity.Address;
import com.chinna.employeeservices.entity.Department;
import com.chinna.employeeservices.entity.Employee;
import com.chinna.employeeservices.entity.Project;
import com.chinna.employeeservices.reposiory.AddressRepository;
import com.chinna.employeeservices.reposiory.DepartmentRepository;
import com.chinna.employeeservices.reposiory.EmployeeRepository;
import com.chinna.employeeservices.reposiory.ProjectRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee assignProjectToEmployee(int empId,int projectId) {
		List<Project> projectList = null;
		Employee employee = employeeRepository.findById(empId).get();
		Project project = projectRepository.findById(projectId).get();
		projectList = employee.getProjects();
		projectList.add(project);
		employee.setProjects(projectList);
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee assignEmployeeToDepartment(int deptId,int empId) {
		Employee employee = employeeRepository.findById(empId).get();
		Department dept = departmentRepository.findById(deptId).get();
		employee.setDepartment(dept);
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> findByIsActive(boolean isActive){
		return employeeRepository.findByIsActive(isActive);
	}
	
	@Override
	public List<Employee> findByName(String name){
		return employeeRepository.findByName(name);
	}
	
	@Override
	public List<Employee> findByEmail(String email){
		return employeeRepository.findByEmail(email);
	}
	
	@Override
	public List<Employee> findByAge(int age){
		return employeeRepository.findByAge(age);
	}
	
	@Override
	public List<Employee> findBySalary(double salary){
		return employeeRepository.findBySalary(salary);
	}
	
	@Override
	public List<Employee> getAllEmployeesByNativeQuery(){
		return employeeRepository.getAllEmployeesByNativeQuery();
	}

	@Override
	public List<Employee> getActiveEmployeesByNativeQuery(boolean isActive) {
		return employeeRepository.getActiveEmployeesByNativeQuery(isActive);
	}

	@Override
	public List<Employee> getEmployeesBySalaryUsingNativeQuery(double salary) {
		return employeeRepository.getEmployeesBySalaryUsingNativeQuery(salary);
	}

	@Override
	public List<Employee> getEmployeesByAgeUsingNativeQuery(int age) {
		return employeeRepository.getEmployeesByAgeUsingNativeQuery(age);
	}

	@Override
	public List<Employee> getEmployeesByNameUsingNativeQuery(String name) {
		return employeeRepository.getEmployeesByNameUsingNativeQuery(name);
	}

	@Override
	public Employee assignAddressToEmployee(int empId, int addressId) {
		Employee employee = employeeRepository.findById(empId).get();
		Address address = addressRepository.findById(addressId).get();
		employee.setAddress(address);

		return employeeRepository.save(employee);
	}


}
