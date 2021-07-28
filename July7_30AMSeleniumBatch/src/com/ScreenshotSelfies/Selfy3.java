package com.ScreenshotSelfies;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy3 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		
		for(int i=0;i<links.size();i++)
		{
			String linkName = links.get(i).getText();
			links.get(i).click();
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File("C:\\Users\\DELL\\Desktop\\screenshots\\"+linkName+".png"));
			
			links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		}
		
		
		//driver.get("https://www.bbc.com");
		
		//driver.findElement(By.linkText("Sport"));
		
		//List<WebElement> links1 = driver.findElements(By.tagName("a"));
		//System.out.println(links1.size());
			
		
		//List<WebElement> links2 = driver.findElements(By.xpath("//div[@id='orb-nav-links']/ul/li"));
		//System.out.println(links2.size());
		

	}

}
