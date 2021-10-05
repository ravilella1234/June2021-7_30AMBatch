package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	public static ExtentReports reports;
	public static String screenshotFolderPath;
	
	public static ExtentReports getReports()
	{
		if(reports == null)
		{
			reports = new ExtentReports();
			//init the report folder
			Date d = new Date();
			String reportsFolder = d.toString().replaceAll(":", "_")+"//screenshots";
			
			screenshotFolderPath = System.getProperty("user.dir")+"//reports//"+reportsFolder;
			System.out.println(screenshotFolderPath);
			String reportFolderPath = System.getProperty("user.dir")+"//reports//"+d.toString().replaceAll(":", "-");	
			System.out.println(reportFolderPath);
			File f = new File(screenshotFolderPath);
			f.mkdirs();
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);
			sparkReporter.config().setReportName("Production Regression Testing...");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			reports.attachReporter(sparkReporter);
		}
		return reports;
	}
	
	

}
