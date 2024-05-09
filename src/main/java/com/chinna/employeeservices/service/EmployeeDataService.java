package com.chinna.employeeservices.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.entity.EmployeeData;

public interface EmployeeDataService {

	public void save(MultipartFile file)throws IOException;

	public List<EmployeeData> getAllEmployeeRecords();

}
