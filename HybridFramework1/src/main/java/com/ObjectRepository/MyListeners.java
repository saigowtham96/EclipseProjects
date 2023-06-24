package com.ObjectRepository;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.genericlibrary.BaseClass;
import com.google.common.io.Files;

public class MyListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" Started");
        
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+" Success");
        
    }
    
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+" Failed");
        TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst=new File("Constants.screenshot_Path"+"result.getName()"+".jpg");
        try {
            Files.copy(src, dst);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName()+" Skipped");
        
    }

    public void onStart(ITestContext context) {
        System.out.println(context.getName()+" Start");
        
    }

    public void onFinish(ITestContext context) {
        System.out.println(context.getName()+" Finish");
        
    }


}
