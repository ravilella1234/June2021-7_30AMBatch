package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import testbases.BaseTest;

public class Sessions extends BaseTest
{
	
	@Test
	public void doLogin(ITestContext context)
	{
		System.out.println("Loging In...");
		x=10;
		System.out.println(x);
		context.setAttribute("x_val", x);
		app.openBrowser("chromebrowser");
		app.navigateurl("rediffurl");
		app.type("user_id", "ravilella2021@rediffmail.com");
		app.type("userpassword_id", "Sai@2015");
		app.click("loginbutton_id");
	}
	
	@Test
	public void doLogout(ITestContext context)
	{
		System.out.println("Logging Out...");
	}
	

}
