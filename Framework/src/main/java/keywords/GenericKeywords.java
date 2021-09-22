package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords  extends ValidationKeywords
{
	public WebDriver driver;
	
	public void openBrowser(String browser)
	{
		System.out.println("Opening The Browser : " + browser);
		
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	public void navigateurl(String url)
	{
		
	}
	
	public void type(String locator, String text)
	{
		
	}
	
	public void click(String locator)
	{
		
	}
	
	public void select(String locator, String option)
	{
		
	}
	
	public void  getText(String locator)
	{
		
	}

}
