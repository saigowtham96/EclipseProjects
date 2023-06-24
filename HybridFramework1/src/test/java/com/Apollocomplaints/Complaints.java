package com.Apollocomplaints;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.genericlibrary.BaseClass;
import com.genericlibrary.WeddriverUtil;

@Listeners(com.genericlibrary.ITestListenerClass.class)
public class Complaints extends BaseClass {
	WeddriverUtil actions = new WeddriverUtil();
	ReusableMethod method = new ReusableMethod();
	String originalEmail = "saigowtham1290@gmail.com";
	String region = "chennai";
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	String origin = "Call";

	public Complaints(WebDriver driver) {
		this.driver = driver;
	}



	By Section = By.xpath("//*[text() = 'CMS']");
	By Menu = By.xpath("//a[@class='icon-bars sidebar-toggle']");
	By MarketingManagement = By.xpath("//*[@id=\"menu-marketing-mgmnt\"]");
	By Module = By.xpath("//span[normalize-space()='Complaints']");
	By clickCreate = By.xpath("//span[normalize-space()='Create New Complaint']");
	By SearchCustomer = By.xpath("//input[@placeholder='Search for customer']");
	By CustomerRemarks = By.xpath("//textarea[@id='customer_remarks']");


	public void createComplaint() throws InterruptedException {
		driver.findElement(Section).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement mm = driver.findElement(MarketingManagement );
		actions.moveToElement(mm);
		Thread.sleep(3000);
		driver.findElement(Module).click();
//		for(int i =1;i<=1;i++) {
//			System.out.println("test case"+"-"+i);
//
//			driver.findElement(clickCreate).click();
//			try {
//			driver.findElement(SearchCustomer).sendKeys("saigowtham");
//
//			List<WebElement> options = driver.findElements(By.xpath("//ul/li[@role ='option']"));
//			System.out.println(options.size());
//			for(WebElement option:options) {
//				String word = option.getText();
//				System.out.println(word);
//				String result = method.splitString(word);
//				if(result.equalsIgnoreCase(originalEmail)) {
//					option.click();
//					break;
//				}
//				else {
//					System.out.println("email not matched");
//				}
//			}
//
//			driver.findElement(CustomerRemarks).sendKeys("ok");
//			act.sendKeys(Keys.PAGE_DOWN).build().perform();
//
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
//			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='formly_25_select_region_12']/div/label")));
//
//			js.executeScript("arguments[0].click();", element);
//
//			// selecting region 
//			try {
//				actions.withoutSelectClass(region);
//			}
//			
//			catch(StaleElementReferenceException e) {
//				System.out.println("entered catch block for region");
//				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='formly_25_select_region_12']/div/label")));
//				js.executeScript("arguments[0].click();", element);
//				actions.withoutSelectClass(region);
//
//			}
//
//
//			WebElement origins = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_25_select_origin_16\"]/div/label")));
//			js.executeScript("arguments[0].click();", origins);
//			try {
//				actions.withoutSelectClass(origin);
//			}
//			catch(StaleElementReferenceException e) {
//				System.out.println("entered catch block for origin");
////				origins = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_25_select_origin_16\"]/div/label")));
////				js.executeScript("arguments[0].click();", origins);
//				actions.withoutSelectClass(origin);
//
//			}
//			driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("ok");
//			act.sendKeys(Keys.PAGE_DOWN).build().perform();
//
//			WebElement create = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btn_save\"]/span[2]/span")));
//			js.executeScript("arguments[0].click();", create);
//			Thread.sleep(3000);
//
//
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		}
		method.getAllRecords();
//		System.out.println("Records list count is "+recordslist.size());
	}


}
