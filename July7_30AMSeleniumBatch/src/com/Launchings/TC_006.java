package com.Launchings;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{
	
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		test = report.startTest("TC_006");
		test.log(LogStatus.PASS, "Initiating the Property Files...");
				
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
				
		navigate("amazonurl");
		test.log(LogStatus.FAIL, "Navigated to app :-" + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","Books");
		test.log(LogStatus.PASS, "Selected the option Books By using locator :-" + orProp.getProperty("amazondropdown_id"));
		
		type("amazonsearchtext_name","Harry Potter");
		test.log(LogStatus.PASS, "Entered the text Harry Potter By using locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_css");
		test.log(LogStatus.PASS, "Clicked on Button By using locator :- " + orProp.getProperty("amazonsearchbutton_css"));
			
		
		report.flush();
		report.endTest(test);
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
	}

}
