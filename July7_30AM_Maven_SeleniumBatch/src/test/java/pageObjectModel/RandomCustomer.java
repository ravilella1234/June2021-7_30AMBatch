package pageObjectModel;

import java.util.Random;

public class RandomCustomer
{

	public static void main(String[] args)
	{
		//qatest43434@gmail.com
		
		String firstName = "qa";
		String lastName = "test";
		String domainName = "@gmail.com";
		
		Random r = new Random();
		int rNum = r.nextInt(99999);
		System.out.println(rNum);
		System.out.println(firstName+lastName+rNum+domainName);
		

	}

}
