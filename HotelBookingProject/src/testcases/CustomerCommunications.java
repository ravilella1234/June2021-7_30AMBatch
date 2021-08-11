package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunications 
{
	
	@Test
	public void checkEmail(ITestContext context)
	{
		String bookingid = (String)context.getAttribute("bookingID");
		System.out.println("Checking mail for confirmation....  :" + bookingid);
	}

}
