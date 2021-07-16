package com.Launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		

		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		//driver.findElement(By.id("twotabsearchtextbox")).clear();
		
		//WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		
		//loc.sendKeys("sony");
		
		//Thread.sleep(5000);
		
		//loc.clear();
		
		//driver.findElement(By.name("field-keywords")).sendKeys("philips");
		
		//Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		
		//driver.findElement(By.linkText("New Releases")).click();
		
		//driver.findElement(By.partialLinkText("New Release")).click();
		
		List<WebElement> loc = driver.findElements(By.tagName("a"));
		for(int i=0;i<loc.size();i++)
		{
			if(!loc.get(i).getText().isEmpty())
			{
				System.out.println(loc.get(i).getText());
			}
			
		}
		
		
	}

}
