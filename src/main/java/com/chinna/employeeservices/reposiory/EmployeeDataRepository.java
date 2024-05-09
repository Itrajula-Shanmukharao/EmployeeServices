package com.chinna.employeeservices.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.EmployeeData;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData,Integer>{

}
