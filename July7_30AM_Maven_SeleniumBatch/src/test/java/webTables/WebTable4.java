package webTables;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable4 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\May 3PM Batch Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
		
		int pageMaxSize = driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		System.out.println("Pages :" +pageMaxSize);
		List<String> names = new ArrayList<String>();
		
		for(int i=1;i<=pageMaxSize;i++)
		{
			 String pageSelector = "div#example_paginate>span>a:nth-child("+i+")";
			 driver.findElement(By.cssSelector(pageSelector)).click();
			 List<WebElement> elementNames = driver.findElements(By.cssSelector("table#example >tbody >tr >td:nth-child(1)"));
			 
			 for(WebElement elementName :elementNames)
			 {
				 names.add(elementName.getText());
			 }
			 
			 for(String name:names)
			 {
				 System.out.println(name);
			 }
		}

	}

}
