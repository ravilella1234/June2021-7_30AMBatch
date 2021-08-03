package com.project.July7_30AM_Maven_SeleniumBatch;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_003 extends BaseTest
{
	
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  System.out.println("startProcess");
	    init();
		test = report.startTest("TC_006");
		test.log(LogStatus.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
				
		navigate("amazonurl");
		test.log(LogStatus.FAIL, "Navigated to app :-" + childProp.getProperty("amazonurl"));
  }

  @Test
  public void amazon() 
  {
	    System.out.println("amazon Test");
	    selectOption("amazondropdown_id","Books");
		test.log(LogStatus.PASS, "Selected the option Books By using locator :-" + orProp.getProperty("amazondropdown_id"));
		
		type("amazonsearchtext_name","Harry Potter");
		test.log(LogStatus.PASS, "Entered the text Harry Potter By using locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_css");
		test.log(LogStatus.PASS, "Clicked on Button By using locator :- " + orProp.getProperty("amazonsearchbutton_css"));
  }
  
  @AfterMethod
  public void endProcess()
  {
	  
	  System.out.println("endProcess");
	  	report.flush();
		report.endTest(test);
		
		driver.quit();
  }

}
