package com.Launchings;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		selectOption("amazondropdown_id","Books");
		
		type("amazonsearchtext_name","Harry Potter");
		
		clickElement("amazonsearchbutton_css");
				
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
	}

}
