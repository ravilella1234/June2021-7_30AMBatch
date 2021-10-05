package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbases.BaseTest;

public class PortfolioManagment extends BaseTest
{
	@Test
	public void createPortfolio(ITestContext context)
	{
		System.out.println("createPortfolio");
		test.log(Status.INFO, "Creating  Portfolio");
		System.out.println(x);
		System.out.println(context.getAttribute("x_val"));
	}
	
	@Test
	public void deletePortfolio()
	{
		System.out.println("deletePortfolio");
	}

}
