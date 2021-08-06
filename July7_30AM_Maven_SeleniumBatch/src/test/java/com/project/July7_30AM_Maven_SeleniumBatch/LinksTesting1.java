package com.project.July7_30AM_Maven_SeleniumBatch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LinksTesting1 extends BaseTest
{
	
	@BeforeMethod(groups = {"regression"})
	@Parameters("browser")
	public void setup(String bType) throws Exception
	{
		System.out.println("startProcess");
	    init();
		test = report.startTest("LinksTesting1");
		test.log(LogStatus.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
						
		navigate("googleurl");
		test.log(LogStatus.PASS, "Navigated to app :-" + childProp.getProperty("googleurl"));
	}
	
	
	@Test(groups = {"regression"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Image")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups = {"regression"})
	public void tearDown()
	{
		 System.out.println("endProcess");
		  	report.flush();
			report.endTest(test);
			
			driver.quit();
	}

}
