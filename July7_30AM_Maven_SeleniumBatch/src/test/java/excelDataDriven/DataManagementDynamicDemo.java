package excelDataDriven;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataManagementDynamicDemo 
{
	
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> str) 
  {
	  if(str.get("RunMode").equals("N"))
		  throw new SkipException("Testcase is skipped...");
	  
		  System.out.println(str.get("UserName"));
		  System.out.println(str.get("Pasword"));
		  
		    WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str.get("UserName"));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(str.get("Pasword"));
	  
	    
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	    ExcelAPI e = new ExcelAPI("C:\\Users\\DELL\\Desktop\\suitea.xlsx");
		String sheetName = "Data";
		String testCaseName = "LoginTest";
		
		return DataUtils.getTestData(e, sheetName, testCaseName);
  }
}
