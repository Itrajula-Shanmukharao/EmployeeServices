package com.chinna.employeeservices.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.entity.EmployeeData;
import com.chinna.employeeservices.helper.ExcelHelper;
import com.chinna.employeeservices.reposiory.EmployeeDataRepository;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{
	
	@Autowired
	private EmployeeDataRepository employeeDataRepository;
	
	public void save(MultipartFile file) throws IOException {
		List<EmployeeData> dataList = ExcelHelper.convertExcelToListOfData(file.getInputStream());
		employeeDataRepository.saveAll(dataList);
	}
	public List<EmployeeData> getAllEmployeeRecords(){
		return employeeDataRepository.findAll();
	}

}
