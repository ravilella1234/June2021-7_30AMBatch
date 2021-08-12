package com.launchings;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		selectOption("amazondropoption_id","Books");
		
		type("amazonsearchtext_id","Harry Potter");
		
		click("amazonsearchbutton_xpath");
		
					
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}
}
