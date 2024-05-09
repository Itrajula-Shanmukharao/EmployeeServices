package com.chinna.employeeservices.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/uploadFileOrImage")
	public String insertFile(@RequestParam("file") MultipartFile file, 
			                 @RequestParam("name") String name, 
			                 @RequestParam("type") String type)throws IOException {
		return fileService.insertFile(file,name,type);
	}
	
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(@RequestParam("name") String fileName){
		byte[] file = fileService.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(file);
	}
	

}
