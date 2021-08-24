package pageObjectModel;

import org.testng.annotations.Test;

import com.project.July7_30AM_Maven_SeleniumBatch.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class POM_001 extends BaseTest
{
	
  @BeforeClass
  @Parameters("browser")
  public void beforeClass(String bType) throws Exception 
  {
	    System.out.println("startProcess");
	    init();
		test = report.startTest("POM_001");
		test.log(LogStatus.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
				
		navigate("automationurl");
		test.log(LogStatus.PASS, "Navigated to app :-" + childProp.getProperty("automationurl"));
  }
  
  @Test
  public void login() 
  {
	  LoginPage page = new LoginPage(driver);
	  page.loginPage();
	  Assert.assertEquals(page.getLoginError(), "Authentication failed.");
  }

  @AfterClass
  public void afterClass() 
  {
	  
  }

}
