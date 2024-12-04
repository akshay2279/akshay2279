package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static void main(String[] args) throws Exception, InvalidFormatException, IOException 
	
	{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\com.Hybrid714_TNS\\Excel\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Login");
	    int rows = sh.getLastRowNum();
	    
	    for(int i =0;i<=rows;i++)
	    {
	    	int cols = sh.getRow(i).getLastCellNum();
	    	for(int j=0;j<=cols;j++)
	    	{
	    		Cell c = sh.getRow(i).getCell(j);
	    		
	    		System.out.println(df.formatCellValue(c));
	    		
	    	}
	    }

	}

}
