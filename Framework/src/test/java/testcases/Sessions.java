package testcases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

public class Sessions 
{
	
	@Test
	public void doLogin()
	{
		System.out.println("Loging In...");
		ApplicationKeywords app = new ApplicationKeywords();
		app.openBrowser("chrome");
		app.navigateurl("https://portfolio.rediff.com/portfolio-login");
	}
	
	@Test
	public void doLogout()
	{
		System.out.println("Logging Out...");
		ApplicationKeywords app = new ApplicationKeywords();
		app.click("logout");
	}
	

}
