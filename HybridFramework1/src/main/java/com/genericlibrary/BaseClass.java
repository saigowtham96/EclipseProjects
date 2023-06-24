package com.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.genericlibrary.ITestListenerClass.class)
public class BaseClass implements Constants {
	public static WebDriver driver;
	public static FileUtil fu = new FileUtil();
	public static String ScreenshotSubFolder;
	 
	
	@BeforeClass
	public void setUp() throws IOException {
		
		String Browser = fu.readDataFromPropertyFile(propertiesPath, "browser");
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String url = fu.readDataFromPropertyFile(propertiesPath, "url");
			driver.get(url);
			
			
		}
		
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String url = fu.readDataFromPropertyFile(propertiesPath, "url");
			driver.get(url);
			
		}
		
		
		
		
		
		
	}
	
	
	public void CaptureScreenShot(String filename) {
		if(ScreenshotSubFolder == null) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

	    ScreenshotSubFolder = myDateObj.format(myFormatObj);
	    
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:/java files/HybridFramework1/Screenshots/"+ ScreenshotSubFolder+"/"+filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
	
	
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
//	
	
	
	


}