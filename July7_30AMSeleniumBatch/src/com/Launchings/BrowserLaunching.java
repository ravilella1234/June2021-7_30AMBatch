package com.Launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunching 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\July Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/DELL/Desktop/July Browser Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.bestbuy.com");
		
		//webdriver.edge.driver
		//webdriver.ie.driver
	}

}
