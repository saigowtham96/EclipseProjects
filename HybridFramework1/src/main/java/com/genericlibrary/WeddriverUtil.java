package com.genericlibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeddriverUtil extends BaseClass {


	public static Select sl;
	public    static Actions ac;


	public void byIndex(WebElement ddadd,int index)
	{
		sl=new Select(ddadd);
		sl.selectByIndex(index);
	}

	public void byValue(WebElement ddadd,String value)
	{
		sl=new Select(ddadd);
		sl.selectByValue(value);
	}

	public void byText(WebElement ddadd,String text)
	{
		sl=new Select(ddadd);
		sl.selectByVisibleText(text);
	}

	public void printAllOptions(WebElement ddadd)
	{
		sl=new Select(ddadd);
		List<WebElement> allopt = sl.getOptions();
		for (WebElement opt : allopt) 
		{
			System.out.println(opt.getText());

		}

	}


	public void withoutSelectClass(String value) 
	{
		
		List<WebElement> allopt = driver.findElements(By.xpath("//li[@role ='option']"));
		boolean flag = true;
		for (WebElement opt : allopt) 
		{
			if(value.equalsIgnoreCase(opt.getText()))
			{
				opt.click();
				flag = false;
				break;
				
				
			}
			
			

		}
		System.out.println("flag value is "+flag);
		
		if(!flag ) {
			System.out.println("Customer selected");
		}
		else {
			System.out.println("no element exists");
		}
	}



	public void moveToElement(WebElement element_add)
	{
		ac=new Actions(BaseClass.driver);
		ac.moveToElement(element_add).perform();
	}
	
	
	public int randomNumber()
	{
		Random rn=new Random();
		int randomNumber = rn.nextInt();
		return randomNumber;
	}
	
	 public void waitForElement(int time)
	    {
	        BaseClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	    }
	 
	 
	    
	    public void waitForElement(Duration time,WebElement address)
	    {
	        WebDriverWait wait=new WebDriverWait(BaseClass.driver, time);
	                wait.until(ExpectedConditions.elementToBeClickable(address));
	    }
	    
	    
	    /*public void waitForElement(int time,WebElement address)
	    {
	        WebDriverWait wait=new WebDriverWait(BaseClass.driver, time);
	                wait.until(ExpectedConditions.elementToBeClickable(address));
	    }*/
	    
	    public void enterKey() throws Throwable
	    {
	        Robot rb=new Robot();
	        rb.keyPress(KeyEvent.VK_ENTER);
	    }

}
