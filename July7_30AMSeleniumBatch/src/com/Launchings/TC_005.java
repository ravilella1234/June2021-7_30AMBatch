package com.Launchings;

import org.apache.log4j.Logger;

public class TC_005 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_005.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initiating the Property Files...");
		
		launch("chromebrowser");
		log.info("Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		log.info("Navigated to app :-" + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","Books");
		log.info("Selected the option Books By using locator :-" + orProp.getProperty("amazondropdown_id") );
		
		type("amazonsearchtext_name","Harry Potter");
		log.info("Entered the text Harry Potter By using locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_css");
		log.info("Clicked on Button By using locator :- " + orProp.getProperty("amazonsearchbutton_css"));
				
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
	}

}
