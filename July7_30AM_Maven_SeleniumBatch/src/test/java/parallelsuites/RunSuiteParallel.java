package parallelsuites;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallel 
{

	public static void main(String[] args) 
	{
		/*
		 * String[] str = new String[10]; str[0]="ravi"; str[1]="lella";
		 * 
		 * String[] s1= {"ravi","lella"};
		 * 
		 * String[] s2 = new String[] {"ravi","lella"};
		 */
		
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
