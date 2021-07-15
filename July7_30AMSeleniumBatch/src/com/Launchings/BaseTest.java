package com.Launchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	
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
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\July Browser Drivers\\chromedriver.exe");
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
		else if(p.getProperty(browser).equals("firefox"))
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
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks;", "192.156.10.1");
			profile.setPreference("network.proxy.socks_port;0", 1765);
			
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigate(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}

}
