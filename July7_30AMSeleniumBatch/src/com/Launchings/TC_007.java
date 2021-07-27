package com.Launchings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_007
{
	//ExtentHtmlReporter
	static ExtentHtmlReporter htmlReport;
	//ExtentReports
	static ExtentReports report;
	//ExtentTest
	static ExtentTest test;
	
	public static void main(String[] args) 
	{
		htmlReport = new ExtentHtmlReporter("E://July2021//July7_30AMSeleniumBatch//HtmlReports//index.html");
		htmlReport.config().setDocumentTitle("Automation Report");
		htmlReport.config().setReportName("Functional testing Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Tester Name", "Ravikanth Lella");
		report.setSystemInfo("Browser", "Chrome");
		
		test = report.createTest("TC_007");
		test.log(Status.PASS, "step1");
		test.log(Status.INFO, "step2");
		test.log(Status.FAIL, "step3");
		test.log(Status.PASS, "step4");
		
		report.flush();
		
	}

}
