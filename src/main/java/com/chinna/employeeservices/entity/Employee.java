package com.chinna.employeeservices.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity

public class Employee {
	
	
	@Id
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private double salary;
	@Column(nullable=false)
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="employee_project",
               joinColumns=@JoinColumn(name="employee_id"),
               inverseJoinColumns=@JoinColumn(name="project_id")
		       )
	private List<Project> projects;
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address2) {
		this.address = address2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
