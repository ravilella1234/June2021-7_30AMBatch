package testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlSuite.ParallelMode;

public class TestNGRunner {
	
	/*
		TestNG - complete testng
		XmlSuite - test Suite
		XmlTest - test case under a suite
		XmlClass - class under test
		XmlInclude - include method under class 
	*/ 
    TestNG testNg;
    XmlSuite suite;// 1 suite
    List<XmlSuite> allSuites;// all the suites
    XmlTest test;// test case
    List<XmlTest> testCases;// all test cases under suite
    Map<String,String> testParameters;
    List<XmlClass> testClasses;
    
	
	public TestNGRunner(int suiteThreadPoolSize) {
		testNg = new TestNG();
		allSuites = new ArrayList<XmlSuite>();// all suites- initialized empty
		testNg.setXmlSuites(allSuites);
		testNg.setSuiteThreadPoolSize(suiteThreadPoolSize);// parallel suites
	}


	public void createSuite(String suiteName,boolean parallelTests) {
		suite = new XmlSuite();
		suite.setName(suiteName);
		if(parallelTests)
			suite.setParallel(ParallelMode.TESTS);
		allSuites.add(suite);
			
	}
	
	
	public void addTest(String testName) {
		test = new XmlTest(suite);
		test.setName(testName);
		testParameters = new HashMap<String, String>();// init test para- blank
		testClasses = new ArrayList<XmlClass>();// empty test classes
		test.setParameters(testParameters);// blank-0 parameters
		test.setXmlClasses(testClasses);// blank - 0 claasses
		
	}
	
	public void addTestParameter(String name, String value) {
		testParameters.put(name, value);
	}
	
	public void addTestClass(String className, List<String> includedMethodNames) {
		XmlClass testClass=new XmlClass(className);
		List<XmlInclude> classMethods = new ArrayList<XmlInclude>();
		int priority=1;
		for(String methodName: includedMethodNames) {
			XmlInclude method = new XmlInclude(methodName, priority);
			classMethods.add(method);
			priority++;
		}
		testClass.setIncludedMethods(classMethods);
		
		testClasses.add(testClass);
	}
	
	public void addListener(String listenerFile) {
		suite.addListener("listener.MyTestNGListener");
	}
	
	
	public void run() {
		testNg.run();
	}
}
