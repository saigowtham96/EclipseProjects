package com.genericlibrary;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FileUtil   {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public String readDataFromPropertyFile(String path,String key) throws IOException
    {
        FileInputStream fis=new FileInputStream(path);
        Properties p=new Properties();
        p.load(fis);
        String value=p.getProperty(key);
        return value;
    }
	
	
	public String readDataFromExcel(String path, String sheet,int row,int column) throws Throwable, Throwable, IOException{
        FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheet);
        Row ro = sh.getRow(row);
        Cell ce = ro.getCell(column);
        String value = ce.getStringCellValue();
       return value;
    }
	
	 
	
	public int getLastRowCount(String sheetName) throws Throwable
    {
        FileInputStream fis=new FileInputStream(Constants.excelpath);
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        int lastRowNum = sh.getLastRowNum();
        return lastRowNum;
    }
	
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}
	
	public int getColumnCount(String sheetName) {
		 
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}
	
	
	
	 public IntStream randomNumber()
	  {
	      Random rn=new Random();
	     IntStream number = rn.ints(1000, 9999);
	     return number;
	  }
	 
	 
	 public void enterDataInExcelSheet(String path,String sheetname,int row,int cell,String data) throws Throwable
	  {
	      FileInputStream fis=new FileInputStream(path);
	         
	        //Get the control of the File
	        Workbook wb= WorkbookFactory.create(fis);
	    
	        //Go to the Particular Sheet
	        Sheet sh= wb.getSheet(sheetname);
	        
	        //Go to particular Row
	        Row r=sh.getRow(row);
	        
	        //Prepare the particular Cell
	        Cell c=r.createCell(cell);
	        
	        //Set the cell String Value
	        c.setCellValue(data);
	        
	        //Open the file in Write mode
	        FileOutputStream fos= new FileOutputStream(path);
	        
	        //Save the file
	        wb.write(fos);
	        //Print a message for our Confirmation
	        System.out.println("done writing");
	  }
	 
	 
	
	 
	 
	
}