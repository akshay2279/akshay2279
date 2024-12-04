package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
public static String readCelData( int rowNum,int ColNum) throws Exception {
	
	
	DataFormatter df = new DataFormatter();// all type data fetch
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\com.Hybrid714_TNS\\Excel\\data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet("Login");
	
	return df.formatCellValue((sh.getRow(rowNum)).getCell(ColNum));
	
}
}
