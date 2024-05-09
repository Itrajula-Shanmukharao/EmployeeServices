package com.chinna.employeeservices.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
