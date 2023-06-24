package com.Apollocomplaints;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.genericlibrary.BaseClass;

public class ReusableMethod extends BaseClass  {
	
	public  String splitString(String inputString) {
		String[] parts = inputString.split("-");
		String name = parts[0].trim();
		String email = parts[1].trim();
		String phone = parts[2].trim();
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
	    String result = email.replaceAll("[(){}]","");

		return result;
		}
	
	
	
	public  void getAllRecords() {
        List<WebElement> records = new ArrayList<>();
        
        // Add code to locate and collect the records on the current page
        List<WebElement> currentRecords = driver.findElements(By.xpath("//*[@id=\"table-complaint_list_list\"]/div[2]/div/p-table/div/div/table/tbody/tr")); // Replace with the XPath to locate the record elements on the current page
        
        
        List<WebElement> pagination = driver.findElements(By.xpath("//*[@id=\"table-complaint_list_list\"]/div[2]/div/p-table/div/p-paginator/div/span/a[1]"));
        String firstPage = driver.findElement(By.xpath("//*[@id=\\\"table-complaint_list_list\\\"]/div[2]/div/p-table/div/p-paginator/div/span/a")).getText();
        System.out.println(firstPage);
        // Add code to check if there is a next page
      
        // Iterate through the pages if a next page is found
         // Replace with the XPath to locate the element representing the next page button or link
//        int i = 1;
//        while()
//        System.out.println("pagination size is"+ s);
//        System.out.println(currentRecords.size());
//        driver.findElement(By.xpath("//*[@id=\"table-complaint_list_list\"]/div[2]/div/p-table/div/p-paginator/div/a[3]/span")).click();
//        return records;
//        for(int i=1;i<=s;i++){
//         
//        	pagination.get(i).click();
//        	records.addAll(currentRecords);
//
//            pagination = driver.findElements(By.xpath("//div[@class='pagination-container']//a"));
//            
//            Thread.sleep(5000);
//
//       
   }
	
	    



}
