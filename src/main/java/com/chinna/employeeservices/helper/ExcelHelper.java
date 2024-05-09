package com.chinna.employeeservices.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.chinna.employeeservices.entity.EmployeeData;

public class ExcelHelper {
	
	public static boolean checkFileFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
	}
	public static List<EmployeeData> convertExcelToListOfData(InputStream is){
		List<EmployeeData> list = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("EmployeeData");
			int rowNumber = 1;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==1) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				EmployeeData e = new EmployeeData();
				while(cells.hasNext()) {
					Cell cell = cells.next();
					switch(cid) {
					case 0:
						e.setEmpId((int)cell.getNumericCellValue());
						break;
					case 1:
						e.setEmpName(cell.getStringCellValue());
						break;
					case 2:
						e.setEmpDepartment(cell.getStringCellValue());
						break;
					case 3:
						e.setEmpDesignation(cell.getStringCellValue());
						break;
					case 4:
						e.setEmpSalary(cell.getNumericCellValue());
						break;
						default:
							break;
					}
					cid++;
				}
			 list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
