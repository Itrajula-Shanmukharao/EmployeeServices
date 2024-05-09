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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinna.employeeservices.entity.Employee;
import com.chinna.employeeservices.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@PutMapping("/{empId}/address/{addressId}")
	public Employee assignaddressToEmployee(@PathVariable int empId,@PathVariable int addressId) {
		
		return employeeService.assignAddressToEmployee(empId,addressId);
	}
	
	@PutMapping("/{empId}/project/{projectId}")
	public Employee assignProjectToEmployee(@PathVariable int empId,@PathVariable int projectId) {
		
		return employeeService.assignProjectToEmployee(empId,projectId);
	}
	
	@PutMapping("/{deptId}/employee/{empId}")
	public Employee assignEmployeeToDepartment(@PathVariable int deptId,@PathVariable int empId) {
		return employeeService.assignEmployeeToDepartment(deptId, empId);
	}
	
	@GetMapping("/isActive")
	public ResponseEntity<List<Employee>> findByIsActive(@RequestParam("isActive") boolean isActive){
		return new ResponseEntity<>(employeeService.findByIsActive(isActive),HttpStatus.OK);
	}
	
	@GetMapping("/employeesByName")
	public ResponseEntity<List<Employee>> findByEmployeeName(@RequestParam("name") String name){
		return new ResponseEntity<>(employeeService.findByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/employeesByEmail")
	public ResponseEntity<List<Employee>> findByEmail(@RequestParam("email") String email){
		return new ResponseEntity<>(employeeService.findByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping("/employeesByAge")
	public ResponseEntity<List<Employee>> findByAge(@RequestParam("age") int age){
		return new ResponseEntity<>(employeeService.findByAge(age),HttpStatus.OK);
	}
	
	@GetMapping("/employeesBySalary")
	public ResponseEntity<List<Employee>> findBySalary(@RequestParam("salary") double salary){
		return new ResponseEntity<>(employeeService.findBySalary(salary),HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployeesByNativeQuery")
	public ResponseEntity<List<Employee>> getAllEmployeesByNativeQuery(){
		return new ResponseEntity<>(employeeService.getAllEmployeesByNativeQuery(),HttpStatus.OK);
	}
	
	@GetMapping("/getActiveEmployeesUsingNativeQuery")
	public ResponseEntity<List<Employee>> getActiveEmployees(@RequestParam("isActive") boolean isActive){
		return new ResponseEntity<>(employeeService.getActiveEmployeesByNativeQuery(isActive),HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeesBySalaryUsingNativeOuery")
	public ResponseEntity<List<Employee>> getEmployeesBySalaryUsingNativeQuery(@RequestParam("salary") double salary){
		return new ResponseEntity<>(employeeService.getEmployeesBySalaryUsingNativeQuery(salary),HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeesByAgeUsingNativeQuery")
	public ResponseEntity<List<Employee>> getEmployeesByAgeUsingNativeQuery(@RequestParam("age") int age){
		return new ResponseEntity<>(employeeService.getEmployeesByAgeUsingNativeQuery(age),HttpStatus.OK);
	}
	
	
	@GetMapping("/getEmployeesByNameUsingNativeQuery")
	public ResponseEntity<List<Employee>> getEmployeesByNameUsingNativeQuery(@RequestParam("name") String name){
		return new ResponseEntity<>(employeeService.getEmployeesByNameUsingNativeQuery(name),HttpStatus.OK);
	}

}
