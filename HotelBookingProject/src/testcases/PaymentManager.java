package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager 
{
	@Test
	public void applyDiscount()
	{
		System.out.println("Apply Discount");
	}
	
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType,ITestContext context)
	{
		if(paymentType.equals("instantpay"))
			System.out.println("making Instant Payment");
		else
			System.out.println("Pay@Hotel Booking");
		
		// booking number
		String bookingID = "ravilella1234";
		System.out.println(bookingID);
		context.setAttribute("bookingID", bookingID);
	}

}
