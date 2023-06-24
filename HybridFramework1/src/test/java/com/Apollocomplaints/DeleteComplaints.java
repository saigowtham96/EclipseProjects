package com.Apollocomplaints;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import com.genericlibrary.BaseClass;
import com.genericlibrary.WeddriverUtil;
@Listeners(com.genericlibrary.ITestListenerClass.class)
public class DeleteComplaints extends BaseClass {
	WeddriverUtil actions = new WeddriverUtil();
	public DeleteComplaints(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By Section = By.xpath("//*[text() = 'CMS']");
	By Menu = By.xpath("//a[@class='icon-bars sidebar-toggle']");
	By MarketingManagement = By.xpath("//*[@id=\"menu-marketing-mgmnt\"]");
	By Module = By.xpath("//span[normalize-space()='Complaints']");
	By SearchBox = By.xpath("//*[@id=\"table-complaint_list_list\"]/div[1]/div[2]/div[1]/zc-data-list-filter/div[2]/div[1]/div/div/div/input");
	By clickSearch = By.xpath("//*[@id=\"table-complaint_list_list\"]/div[1]/div[2]/div[1]/zc-data-list-filter/div[2]/div[2]/div/div/button/span");
	By ActionsClick = By.xpath("//*[@id=\"table-complaint_list_list\"]/div[2]/div/p-table/div/div/table/tbody/tr/td[9]/zc-actions/div/div/div/div");
	By Delete = By.xpath("//i[@class = 'icon-delete']");
	By confirmDelete = By.xpath("//*[@id=\"dialog-okay-btn\"]");
	public void delete(String complaint) throws InterruptedException {
		driver.findElement(Section).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement mm = driver.findElement(MarketingManagement );
		actions.moveToElement(mm);
		Thread.sleep(3000);
		driver.findElement(Module).click();
		driver.findElement(SearchBox).sendKeys(complaint);
		driver.findElement(clickSearch).click();
		Thread.sleep(3000);
//		WebElement action = driver.findElement(ActionsClick);
//		actions.moveToElement(action);
		driver.findElement(ActionsClick).click();
		driver.findElement(Delete).click();
		driver.findElement(confirmDelete).click();
		
		
		
		
		
		
	}


}
