package com.chinna.employeeservices.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File,Long>{
   
	 File findByName(String name);
}
