package com.verifications;

import com.Launchings.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.startTest("Verify3");
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		String expectedtxt1 = "Customer Ser";
		System.out.println("Expected Link : "+ expectedtxt1);
		
		if(!isLinksEqual(expectedtxt1))
			testFail("Both Links are not equal....");
			//System.out.println("Both Links are not equal....");
		else
			testPass("Both Links are equal....");
			//System.out.println("Both Links are equal....");

		report.flush();
		report.endTest(test);
	}
}
