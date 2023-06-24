package com.Apollocms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlibrary.BaseClass;
import com.genericlibrary.Constants;
import com.genericlibrary.FileUtil;
@Listeners(com.genericlibrary.ITestListenerClass.class)
public class LoginPage extends BaseClass {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	

	
	public void login() throws InterruptedException, IOException {
		
	
		//System.out.println(rowCount);
		
	    String username;
		String password;
		FileInputStream fis=new FileInputStream(Constants.excelpath);
		 workbook = new XSSFWorkbook(fis);
		 sheet = workbook.getSheet("Sheet1");
		 int noOfRows = sheet.getLastRowNum();
		 //int noOfColumns = sheet.getRow(0).getLastCellNum();
		 for (int i = 1; i <= noOfRows; i++) {
				
					DataFormatter df = new DataFormatter();
					username = df.formatCellValue(sheet.getRow(i).getCell(0));
					password = df.formatCellValue(sheet.getRow(i).getCell(1));
					driver.findElement(By.xpath("//input[@id='appUserName']")).sendKeys(username);
					driver.findElement(By.xpath("//input[@id='appPassword']")).sendKeys(password);
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
					
			}
		 
		 workbook.close();
		 fis.close();
		
		
		
	}
	
	
	
//	 @DataProvider(name="loginData")
//	 public String[][] GetData() throws IOException {
//		 
//		 FileInputStream fis=new FileInputStream(Constants.excelpath);
//		 workbook = new XSSFWorkbook(fis);
//		 sheet = workbook.getSheet("Sheet1");
//		 int noOfRows = sheet.getLastRowNum();
//		 int noOfColumns = sheet.getRow(0).getLastCellNum();
//		 
//		 String[][] data = new String[noOfRows-1][noOfColumns];
//			for (int i = 0; i < noOfRows-1; i++) {
//				for (int j = 0; j < noOfColumns; j++) {
//					DataFormatter df = new DataFormatter();
//					data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
//				}
//			}
//			
//			workbook.close();
//			fis.close();
//			
//	 		for (String[] dataArr : data) {
//	 			System.out.println(Arrays.toString(dataArr));
//	 		}
//			return data;
//	
//		 
//	 }
	

}
