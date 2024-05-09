package com.chinna.employeeservices.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {

	public String insertFile(MultipartFile file, String name, String type) throws IOException;
	
	public byte[] downloadFile(String name);

}
