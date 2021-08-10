package assertions;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.July7_30AM_Maven_SeleniumBatch.BaseTest;

public class TestNGReporting extends BaseTest
{
	SoftAssert a;
	
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  System.out.println("startProcess");
	    init();
		Reporter.log("Initiating the Property Files...");
				
		launch(bType);
		Reporter.log("Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		
				
		navigate("amazonurl");
		Reporter.log("Navigated to app :-" + childProp.getProperty("amazonurl"));
  }

  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	    String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon";
	  
		a  = new SoftAssert();
		//a.assertEquals(actualTitle, expectedTitle);
		a.assertTrue(actualTitle.equals(expectedTitle), "Both titles are not equal...");
	  
	    System.out.println("amazon Test");
	    selectOption("amazondropdown_id","Books");
	    Reporter.log("Selected the option Books By using locator :-" + orProp.getProperty("amazondropdown_id"));
		
		type("amazonsearchtext_name","Harry Potter");
		Reporter.log("Entered the text Harry Potter By using locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_css");
		Reporter.log("Clicked on Button By using locator :- " + orProp.getProperty("amazonsearchbutton_css"));
  }
  
  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess()
  {
	  System.out.println("endProcess");
		a.assertAll();
		driver.quit();
  }

}
