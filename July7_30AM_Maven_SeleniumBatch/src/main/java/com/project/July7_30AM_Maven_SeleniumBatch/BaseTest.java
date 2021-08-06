package com.project.July7_30AM_Maven_SeleniumBatch;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report; 
	public static ExtentTest test;
	public static String filePath;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
	}
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath+"/data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"/environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"/"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectPath+"//or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis  = new FileInputStream(projectPath+"//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report =ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Selenium\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs//chromelog.log");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 23");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			option.addArguments("--ignore-certificate-errors");
			//option.addArguments("--proxy-server=http://192.168.10.1:9090");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:/Users/DELL/Desktop/July Browser Drivers/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			
			
			//Binaries
			//logs
			//Notifications
			//Certificate errors
			//work with proxy settings
			
			WebDriverManager.firefoxdriver().setup();
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("julyffprofile");
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			//Binaries
			option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefoxlogs.log");
			
			//Notifications
			profile.setPreference("dom.webnotifications.enabled", false);
				
			//Certificate errors
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			//work with proxy settings
			//profile.setPreference("network.proxy.type", 1);
			//profile.setPreference("network.proxy.socks;", "192.156.10.1");
			//profile.setPreference("network.proxy.socks_port;0", 1765);
			
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigate(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void clickElement(String locatorKey)
	{
		//driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}

	
	public static void type(String locatorKey, String text) 
	{
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		//check for Presence of Element
		if(!isElementPresent(locatorKey)) {
			//report failure
			System.out.println("Element is not present :" + locatorKey);
		}
		
		//check for the visibility of Element
		if(!isElementVisible(locatorKey)) {
			//report failure
			System.out.println("Element is not visible : " + locatorKey);
		}
				
		
		WebElement element=null;
		element = driver.findElement(getLocator(locatorKey));
		/*
		 * if(locatorKey.endsWith("_id")) { element =
		 * driver.findElement(By.id(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_name")) { element =
		 * driver.findElement(By.name(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_classname")) { element =
		 * driver.findElement(By.className(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_xpath")) { element =
		 * driver.findElement(By.xpath(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_css")) { element =
		 * driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_linktext")) { element =
		 * driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_partiallinktext")) { element =
		 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey))); }
		 */
		return element;
	}

	//true  - visible
	//false - not-visible
	public static boolean isElementVisible(String locatorKey) 
	{
		System.out.println("Checking Visibility of : " + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
			
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			 * orProp.getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linktext"))
			 * {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partiallinktext"))
			 * {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
			 
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
		
	}

	//true - present
	//false - not-present
	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking presence of : " + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partiallinktext"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
	
	// ************************  Verifications  *******************
	public static boolean isLinksEqual(String expectedtxt1) 
	{
		String actualtxt1 = driver.findElement(By.linkText("Customer Service")).getText();
		
		if(actualtxt1.equals(expectedtxt1))
			return true;
		else
			return false;
	}
	
	//  ***********************  Reportings  ************************
	
	public static void testPass(String passMessage) 
	{
		test.log(LogStatus.PASS, passMessage);		
	}

	public static void testFail(String failMessage) throws Exception 
	{
		test.log(LogStatus.FAIL, failMessage);
		takesScreenshot();
	}

	private static void takesScreenshot() throws Exception 
	{
		Date dt=new Date();
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectPath+"\\failurescreenshots\\"+dateFormat));
		
		test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectPath+"\\failurescreenshots\\"+dateFormat));
		
	}
	
}
