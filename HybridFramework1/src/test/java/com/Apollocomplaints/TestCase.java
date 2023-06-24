package com.Apollocomplaints;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Apollocms.LoginPage;
import com.genericlibrary.BaseClass;

public class TestCase extends BaseClass {
	
	@Test(testName = "test")
	public void test() throws IOException, InterruptedException, AWTException {
       //Login page
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		Complaints cp = new Complaints(driver);
		cp.createComplaint();
		
//		DeleteComplaints dc = new DeleteComplaints(driver);
//		dc.delete("AP0623-10000637");
	}
}
