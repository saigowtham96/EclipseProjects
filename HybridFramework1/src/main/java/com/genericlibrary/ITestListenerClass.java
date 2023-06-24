package com.genericlibrary;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ITestListenerClass extends BaseClass implements ITestListener {
    
//	public void onStart(ITestContext context) {	
//		System.out.println("onStart method started");
//	}

//	public void onFinish(ITestContext context) {
//		System.out.println("onFinish method started");
//	}

//	public void onTestStart(ITestResult result) {
//		System.out.println("New Test Started" +result.getName());
//	}

//	public void onTestSuccess(ITestResult result) {
//		System.out.println("onTestSuccess Method" +result.getName());
//	}

	public void onTestFailure(ITestResult result) {
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
	     Test test = method.getAnnotation(Test.class);
	     String testname = test.testName();
		//System.out.println("onTestFailure Method" +result.getTestName());
		CaptureScreenShot(testname+".jpg");
	}
    
    

//	public void onTestSkipped(ITestResult result) {
//		System.out.println("onTestSkipped Method" +result.getName());
//	}
//    
//	
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
//	}

}
