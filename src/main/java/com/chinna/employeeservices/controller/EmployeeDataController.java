package com.chinna.employeeservices.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.entity.EmployeeData;
import com.chinna.employeeservices.helper.ExcelHelper;
import com.chinna.employeeservices.service.EmployeeDataService;

@RestController
public class EmployeeDataController {
	
	@Autowired
	private EmployeeDataService employeeDataService;
	
	@PostMapping("/uploadExcelFile")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException{
		if(ExcelHelper.checkFileFormat(file)) {
			employeeDataService.save(file);
			return ResponseEntity.ok(Map.of("message","data saved successfully"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload Excel Format File Only");
	}
	
	@GetMapping("/getAllEmployeeRecords")
	public ResponseEntity<List<EmployeeData>> getAllEmployeeRecords(){
		return new ResponseEntity<>(employeeDataService.getAllEmployeeRecords(),HttpStatus.OK);
	}

}
