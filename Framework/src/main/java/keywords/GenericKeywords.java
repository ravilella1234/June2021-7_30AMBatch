package keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords  extends ValidationKeywords
{
	public WebDriver driver;
	public String projectPath = System.getProperty("user.dir");
	public Properties mainProp;
	public Properties childProp;
	
	public void openBrowser(String browser)
	{
		System.out.println("Opening The Browser : " + browser);
		
		if(mainProp.getProperty(browser).equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(mainProp.getProperty(browser).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	public void navigateurl(String url)
	{
		driver.get(childProp.getProperty(url));
	}
	
	public void type(String locatorKey, String text)
	{
		getElement(locatorKey).sendKeys(text);
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void select(String locatorKey, String option)
	{
		
	}
	
	public void  getText(String locatorKey)
	{
		
	}
	
	public WebElement getElement(String locatorKey)
	{
		//check the presence of element
		if(!isElementPresent(locatorKey)) {
			//report the failure
			System.out.println("Element is not present :-" + locatorKey);
		}
		
		//check the visibility of element
		if(!isElementVisible(locatorKey)) {
			//report the failure
			System.out.println("Element is not visible :- " + locatorKey);
		}
		
		WebElement e =null;
		if(locatorKey.endsWith("_id")) {
			e = driver.findElement(By.id((mainProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_name")) {
			e = driver.findElement(By.name((mainProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_xpath")) {
			e = driver.findElement(By.xpath((mainProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_css")) {
			e = driver.findElement(By.cssSelector((mainProp.getProperty(locatorKey))));
		}
		
		return e;
	}
	
	public boolean isElementVisible(String locatorKey) 
	{
		System.out.println("Checking the visibility of Element :-" + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		try{			
			if(locatorKey.endsWith("_id")){
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_css")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(mainProp.getProperty(locatorKey))));
			}
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking the Presence of Element :-" + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			if(locatorKey.endsWith("_id")){
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mainProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_css")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(mainProp.getProperty(locatorKey))));
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
