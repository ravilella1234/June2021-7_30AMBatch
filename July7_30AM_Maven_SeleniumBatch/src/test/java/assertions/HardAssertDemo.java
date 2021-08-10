package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.July7_30AM_Maven_SeleniumBatch.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertDemo extends BaseTest
{
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		String actualLink = driver.findElement(By.linkText("New Releases")).getText();
		String expectedLink = "New Release";
		
		//Assert.assertEquals(actualLink, expectedLink);
		Assert.assertTrue(actualLink.equals(expectedLink), "Both links are not equal...");
		
		driver.findElement(By.linkText("New Releases")).click();
		
		
	}

}
