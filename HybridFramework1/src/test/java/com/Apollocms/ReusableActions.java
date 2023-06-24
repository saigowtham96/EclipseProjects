package com.Apollocms;

import org.openqa.selenium.By;

import com.genericlibrary.BaseClass;

public class ReusableActions extends BaseClass{
	
	
	public void multiSelectDropdown() {
		driver.findElement(By.xpath("//*[@id=\"formly_14_select_ticket_tag_user_3\"]/div/div[3]")).click();
		driver.findElement(By.xpath("//*[@class ='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		
	} 
	
	
	public void clickCheckBox() {
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
	}
	
	
	

}
