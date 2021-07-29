package com.verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		String actualtxt1 = driver.findElement(By.linkText("Customer Service")).getText();
		System.out.println("Actual Link : "+ actualtxt1);
		
		//String actualtxt2 = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		//System.out.println("Actual Test : " + actualtxt2);
		
		String expectedtxt1 = "Customer Ser";
		System.out.println("Expected Link : "+ expectedtxt1);
		
		//if(actualtxt1.equals(expectedtxt1))
		//if(actualtxt1.equalsIgnoreCase(expectedtxt1))
		if(actualtxt1.contains(expectedtxt1))
			System.out.println("Both links are equal....");
		else
			System.out.println("Both Links are not equal....");
	}

}
