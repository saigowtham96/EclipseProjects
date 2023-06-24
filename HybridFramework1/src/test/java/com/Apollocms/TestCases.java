package com.Apollocms;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericlibrary.BaseClass;
import com.genericlibrary.Constants;
import com.genericlibrary.FileUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases extends BaseClass {
	//	public static WebDriver driver ;
	//	public static FileUtil fu = new FileUtil();
	@Test(testName = "test")
	public void test() throws IOException, InterruptedException, AWTException {
       //Login page
		LoginPage lp = new LoginPage(driver);
		lp.login();

	
        //Ticket creation
		String departmentName = "IT";
		for(int i =0; i<1;i++) {
			switch(departmentName) {

			case "IT":
				ITticket department = new ITticket(driver);
				String ITticket = department.IT();
				System.out.println("Ticket created successfully-" + ITticket);
				break;
				//		case "Inventory":
				//			inventory depart = new inventory();
				//			String INticket = depart.INDepartment(driver);
				//			System.out.println("Ticket created successfully-" + INticket);
				//			break;
				//		case "Marketing":
				//			System.out.println("There is no such department");
				//			marketing dm = new marketing();
				//			String MKticket = dm.MKDepartment(driver);
				//			System.out.println("Ticket created successfully-" + MKticket);
				//			break;

			default:
				System.out.println("no such department");




			}


		}

	}
}
