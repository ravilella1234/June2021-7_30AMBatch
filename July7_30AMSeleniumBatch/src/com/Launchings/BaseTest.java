package com.Launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\July Browser Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/DELL/Desktop/July Browser Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public static void navigate(String url)
	{
		driver.get(url);
	}

}
