package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo 
{
	
  @Test
  public void test1() 
  {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon";
	  
		SoftAssert a  = new SoftAssert();
		//a.assertEquals(actualTitle, expectedTitle);
		a.assertTrue(actualTitle.equals(expectedTitle), "Both titles are not equal...");
		driver.findElement(By.linkText("New Releases")).click();
		
		a.assertTrue(false, "err1");
		
		a.assertTrue(true, "err2");
		
		a.assertTrue(false, "err3");
		
		a.assertTrue(false, "err4");
		
		
		a.assertAll();
  }
}
