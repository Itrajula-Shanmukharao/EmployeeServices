package com.chinna.employeeservices.reposiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
 
	List<Employee> findByIsActive(boolean isActive);
	
	List<Employee> findByName(String name);
	
	List<Employee> findByEmail(String email);
	
	List<Employee> findByAge(int age);
	
	List<Employee> findBySalary(double salary);
	
	@Query(value="select * from employee",nativeQuery=true)
	List<Employee> getAllEmployeesByNativeQuery();

	@Query(value="select * from employee where is_active=:isActive",nativeQuery=true)
	List<Employee> getActiveEmployeesByNativeQuery(@Param("isActive") boolean isActive);

	@Query(value="select * from employee where salary=:salary",nativeQuery=true)
	List<Employee> getEmployeesBySalaryUsingNativeQuery(@Param("salary") double salary);

	@Query(value="select * from employee where age=:age",nativeQuery=true)
	List<Employee> getEmployeesByAgeUsingNativeQuery(@Param("age") int age);

	@Query(value="select * from employee where name=:name",nativeQuery=true)
	List<Employee> getEmployeesByNameUsingNativeQuery(@Param("name") String name);
}
