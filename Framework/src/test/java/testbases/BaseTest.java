package testbases;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest 
{
	public ApplicationKeywords app;
	public int x;
	public ExtentReports rep;
	public ExtentTest test;
	
	
	@BeforeTest
	public void beforeTest(ITestContext context) throws Exception
	{
		System.out.println("############## Before Test  #############");
		app = new ApplicationKeywords();//This app reference will share to entire test methods
		context.setAttribute("app", app);
		
		//init the reporting for the test
		rep = ExtentManager.getReports();
		test = rep.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Test" + context.getCurrentXmlTest().getName());
		context.setAttribute("report", rep);
		context.setAttribute("test", test);
	}

	
	@BeforeMethod
	public void beforeMethod(ITestContext context)
	{
		System.out.println("############## Before Method #############");
		app = (ApplicationKeywords) context.getAttribute("app");
		rep = (ExtentReports)context.getAttribute("report");
		test = (ExtentTest)context.getAttribute("test");
	}
	
	@AfterTest
	public void afterTest()
	{
		if(rep!=null)
			rep.flush();
	}
}
