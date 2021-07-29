package com.Launchings;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;



public class ExtentManager extends BaseTest
{
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			report = new ExtentReports(projectPath+"//HtmlReports//htmlreport.html");
			report.loadConfig(new File(projectPath+"//extentReportconfig.xml"));
			report.addSystemInfo("Language Binging", "3.141.59").addSystemInfo("Instance Environment", mainProp.getProperty("env"));
		}
		
		return report;
	}

}
