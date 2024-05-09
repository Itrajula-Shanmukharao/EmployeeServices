package com.chinna.employeeservices.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
