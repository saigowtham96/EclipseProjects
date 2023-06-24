package com.Apollocms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericlibrary.BaseClass;

public class AddPineLabs extends BaseClass {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public AddPineLabs(WebDriver driver) {
		this.driver = driver;
	}


	By Section = By.xpath("//*[text() = 'CMS']");
	By Menu = By.xpath("//a[@class='icon-bars sidebar-toggle']");
	By Module = By.xpath("//span[normalize-space()='Pine Lab Issues']");
	By CreatePineLab = By.xpath("//button[@title='Create New Pine Lab Issue']");
	By StoreName = By.xpath("//input[@placeholder='Search for store name']");
	Actions act = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public void createPineLab() throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(Section).click();
		driver.findElement(Menu).click();
		driver.findElement(Module).click();
		driver.findElement(Menu).click();
		driver.findElement(CreatePineLab).click();
		driver.findElement(StoreName).sendKeys("10000");
		driver.findElement(By.xpath("//*[@role = 'option']")).click();
		 
		 
		String date = "24-April-2023";
		String[] dateParts = date.split("-");
		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];
		//driver.findElement(By.xpath("//input[placeholder='dd/mm/yy MM:SS']")).clear();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"field-datetime_3681\"]/zc-date-time/p-calendar/span/input")))).click();
		 act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Select objSelect = new Select(driver.findElement(By.xpath("//*[@id=\"field-datetime_3681\"]/zc-date-time/p-calendar/span/div/div[1]/div[1]/div/select[1]")));
		List<WebElement> elementCount = objSelect.getOptions();
		System.out.println(elementCount.size());
		for(int i = 0;i<elementCount.size();i++) {
			
			if(elementCount.get(i).getText().equalsIgnoreCase(month)) {
				elementCount.get(i).click();
				break;
			}
			
		}
		
		Select objSelect2 = new Select(driver.findElement(By.xpath("//*[@id=\"field-datetime_3681\"]/zc-date-time/p-calendar/span/div/div[1]/div[1]/div/select[2]")));
		List<WebElement> elementCount1 = objSelect2.getOptions();
		System.out.println(elementCount1.size());
		for(int i = 0;i<elementCount1.size();i++) {
			
			if(elementCount1.get(i).getText().equalsIgnoreCase(year)) {
				elementCount1.get(i).click();
				break;
			}
			
		}
		
		System.out.println("Selected year");
		
		List<WebElement> elementCount2 = driver.findElements(By.xpath("//a[@class='ui-state-default ng-tns-c30-9 ng-star-inserted' or @class='ui-state-default ng-tns-c30-9 ui-state-active ui-state-highlight ng-star-inserted']"));
		System.out.println(elementCount2.size());
		for(int i = 0;i<elementCount2.size();i++) {
		if(elementCount2.get(i).getText().equalsIgnoreCase(day)) {
			elementCount2.get(i).click();
			break;
		}
		
	}
		
		
		
		
		
//		List<WebElement> elementCount2;
//		try {
//			 elementCount2 = driver.findElements(By.xpath("//a[@class='ui-state-default ng-tns-c30-9 ng-star-inserted' or @class='ui-state-default ng-tns-c30-9 ui-state-active ui-state-highlight ng-star-inserted']"));
//			 for(int i = 0;i<elementCount2.size();i++) {
//					
//					if(elementCount2.get(i).getText().equalsIgnoreCase(day)) {
//						elementCount2.get(i).click();
//					}
//					
//				}
//		
//		}
//		catch(StaleElementReferenceException e){
//			
//		}
//		 
//		
//        
		driver.findElement(By.xpath("//*[@id=\"field-datetime_3681\"]/zc-date-time/p-calendar/span/div/p-footer/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder = 'Select category']")).click();
		String categoryname = "Mixed Category";
		List<WebElement> category = driver.findElements(By.xpath("//*[@role= 'option']"));
		System.out.println(category.size());
		for(int i = 0;i<category.size();i++) {
		if(category.get(i).getText().equalsIgnoreCase(categoryname)) {
			category.get(i).click();
			break;
		}
		
	}
		
		
		driver.findElement(By.xpath("//*[@placeholder= 'Select device TID']")).click();
		String devicetid ="Tid 77";
		List<WebElement> deviceTid = driver.findElements(By.xpath("//*[@role= 'option']"));
		System.out.println(deviceTid.size());
		for(int i = 0;i<deviceTid.size();i++) {
		if(deviceTid.get(i).getText().equalsIgnoreCase(devicetid)) {
			deviceTid.get(i).click();
			break;
		}
	
	}
		
		WebElement element = driver.findElement(By.id("cmplnt_desc"));
		String largeData = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
		for(int i=0;i<largeData.length();i+=100) {
		   element.sendKeys(largeData.substring(i, Math.min(i+100, largeData.length())));
		}
		
		 act.sendKeys(Keys.PAGE_DOWN).build().perform();
		 
		 driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\palla\\Downloads\\FqcM0I1aAAARD5Z.jpeg");
		
         driver.findElement(By.id("btn_save")).click();


	}

}
