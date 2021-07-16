package com.Launchings;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		selectOption("searchDropdownBox","Books");
		
		type("twotabsearchtextbox","Harry Potter");
		
		clickElement("#nav-search-submit-button");
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
	}

}
