package testbases;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import keywords.ApplicationKeywords;

public class BaseTest 
{
	public ApplicationKeywords app;
	public int x;
	
	
	@BeforeTest
	public void beforeTest(ITestContext context) throws Exception
	{
		System.out.println("############## Before Test  #############");
		app = new ApplicationKeywords();//This app reference will share to entire test methods
		context.setAttribute("app", app);
	}

	
	@BeforeMethod
	public void beforeMethod(ITestContext context)
	{
		System.out.println("############## Before Method #############");
		app = (ApplicationKeywords) context.getAttribute("app");
	}
}
