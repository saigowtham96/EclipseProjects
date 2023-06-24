package com.Apollocms;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlibrary.BaseClass;


@Listeners(com.genericlibrary.ITestListenerClass.class)
public class ITticket extends BaseClass {

	public ITticket(WebDriver driver) {
		this.driver = driver;
	}



	By Section = By.xpath("//*[text() = 'CMS']");
	By Menu = By.xpath("//a[@class='icon-bars sidebar-toggle']");
	By Module = By.xpath("//*[@id=\"menu-my-tickets\"]");
	By AddNewTicket = By.xpath("//span[normalize-space()='Add New Ticket']");
	By CreateTicket = By.xpath("//button[@id='btnCreate']");
	By department = By.xpath("//h2[text()='IT']");
	By Next = By.xpath("//div[@id='field-button_2451']//span[@class='ng-star-inserted'][normalize-space()='Next']");
	By SelectReason = By.xpath("//*[text()='Select reason']");
	By SearchReason = By.xpath("//*[@id=\"formly_9_select_reasons_1\"]/div/div[3]/div[1]/input");
	By Selectoption = By.xpath("//div[contains(text(),'Ledger Issue | Ledger Issue | Ledger Issue')]");
	By ClickNext = By.xpath("//div[@id='field-button_5071']//button[@id='btnNext']");
	By Searchstore = By.xpath("//input[@placeholder='Search store name']");
	By selectstore = By.xpath("//*[@id=\"field-autocomplete_3841\"]/zc-autocomplete/div/p-autocomplete/span/div/ul/li/div/div[2]");
	By Description = By.xpath("//textarea[@id='description']");
	By clicknext  = By.xpath("//div[@id='field-button_1551']//span[@class='ng-star-inserted'][normalize-space()='Next']");
	By submit = By.xpath("//button[@id='btnSubmitIt']//span[@class='ng-star-inserted'][normalize-space()='Submit']");
	Actions act = new Actions(driver);
	ReusableActions actions = new ReusableActions();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	@Test(testName = "IT")
	public String IT() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(Section).click();
		driver.findElement(Module).click();
		driver.findElement(AddNewTicket).click();
		driver.findElement(CreateTicket).click();
		driver.findElement(department).click();
		driver.findElement(Next).click();
		driver.findElement(SelectReason).click();
		driver.findElement(SearchReason).sendKeys("Ledger");
		driver.findElement(Selectoption).click();

		boolean user = driver.findElement(By.xpath("//*[@id = 'field-contain-ticket_tag_user']")).isDisplayed();
		if(user == true) {
			actions.multiSelectDropdown();

		}
		else {
			System.out.println("ticket tag user field not there");
		}

		System.out.println("the element is present"+user);
		boolean checkbox =  driver.findElement(By.xpath("//input[@type = 'checkbox']")).isDisplayed();
		if(checkbox == true) {
			actions.clickCheckBox();

		}
		else {
			System.out.println("Checkbox  field not there");
		}
		driver.findElement(ClickNext).click();
		driver.findElement(Searchstore).sendKeys("19000");
		driver.findElement(selectstore).click();
		driver.findElement(Description).sendKeys("ok");
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("scroll down performed");
		Thread.sleep(2000);
		boolean next = driver.findElement(By.xpath("//*[@title='Next']")).isDisplayed();
		System.out.println(next);

		WebElement button =  driver.findElement(By.xpath("//div[@id='field-button_1551']//span[@class='ng-star-inserted'][normalize-space()='Next']"));
		//nextbutton.click();
		//driver.findElement(clicknext).click();
		js.executeScript("arguments[0].click();", button);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(submit).click();
		String Ticketnumber = driver.findElement(By.xpath("//*[@id=\"field-text_8959\"]/zc-text/label/div/div[2]/strong")).getText();
		String result =  Ticketnumber.replaceAll("^\"|\"$", "");
		return result;



	}




}
