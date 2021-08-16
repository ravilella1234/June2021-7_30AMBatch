package testcases;

import java.util.ArrayList;
import java.util.List;

public class Runner 
{

	public static void main(String[] args) 
	{
		//init the List<XMLSuite>
		TestNGRunner runner = new TestNGRunner(1);
		runner.createSuite("Booking Suite", false);
		
		//create the Test - with parameters 0
		System.out.println("**********  Create Booking Test - Apply Discount - pay@hotel  *************");
		runner.addTest("Create Booking Test - Apply Discount - pay@hotel");
		runner.addTestParameter("action", "pay@hotel");
		
        List<String> includedMethodsNames = new ArrayList<String>();
        includedMethodsNames.add("searchHotel");
        includedMethodsNames.add("selectHotel");
        includedMethodsNames.add("enterGuestInfo");
        runner.addTestClass("testcases.BookingSearch", includedMethodsNames);
        
        includedMethodsNames = new ArrayList<String>();
        includedMethodsNames.add("applyDiscount");
        includedMethodsNames.add("makePayment");
        runner.addTestClass("testcases.PaymentManager", includedMethodsNames);
        
        
        //2nd test
        System.out.println(" ***********  Create Booking Test - No Discount - pay@hotel *************");
        runner.addTest("Create Booking Test - No Discount - pay@hotel");
		runner.addTestParameter("action", "pay@hotel");
		
        List<String> includedMethodsNames1 = new ArrayList<String>();
        includedMethodsNames1.add("searchHotel");
        includedMethodsNames1.add("selectHotel");
        includedMethodsNames1.add("enterGuestInfo");
        runner.addTestClass("testcases.BookingSearch", includedMethodsNames1);
        
        includedMethodsNames1 = new ArrayList<String>();
        includedMethodsNames1.add("makePayment");
        runner.addTestClass("testcases.PaymentManager", includedMethodsNames1);
		
		runner.run();

	}

}
