package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner 
{

	public static void main(String[] args) 
	{
		TestNG testng = new TestNG();
		
		XmlSuite mysuite = new XmlSuite();
		mysuite.setName("My Suite");
		
		List<XmlSuite> allSuites = new ArrayList<XmlSuite>();
		allSuites.add(mysuite);
		testng.setXmlSuites(allSuites);
		
		XmlTest test = new XmlTest(mysuite);
		test.setName("Login Test");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("testcases.Login"));
		test.setXmlClasses(classes);
		
		testng.run();
	}

}
