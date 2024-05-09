package com.chinna.employeeservices.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.entity.File;
import com.chinna.employeeservices.reposiory.FileRepository;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileRepository fileRepository;

	@Override
	public String insertFile(MultipartFile file, String name, String type) throws IOException 
	{
		File files = new File();
		files.setName(name);
		files.setType(type);
		files.setFile(file.getBytes());
	    fileRepository.save(files);
	    return "File Uploaded Successfully";
	}

	@Override
	public byte[] downloadFile(String name) {
		
		return fileRepository.findByName(name).getFile();
	}

	
	

}
