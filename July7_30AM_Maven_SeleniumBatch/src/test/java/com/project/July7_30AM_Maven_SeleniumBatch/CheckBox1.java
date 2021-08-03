package com.project.July7_30AM_Maven_SeleniumBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1  extends BaseTest
{
  
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		System.out.println("startProcess");
	    init();
		test = report.startTest("CheckBox1");
		test.log(LogStatus.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
						
		navigate("chekboxurl");
		test.log(LogStatus.PASS, "Navigated to app :-" + childProp.getProperty("chekboxurl"));
	}
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("endProcess");
	  	report.flush();
		report.endTest(test);
		
		driver.quit();
  }

}
