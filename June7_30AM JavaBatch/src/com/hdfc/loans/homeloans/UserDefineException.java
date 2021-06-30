package com.hdfc.loans.homeloans;

import java.util.Scanner;

public class UserDefineException extends Exception
{

	public UserDefineException(String msg) 
	{
		super(msg);
	}

	public static void main(String[] args) 
	{
		String str=null;
		Scanner sc = new Scanner(System.in);
		
		
		while (true) 
		{
			System.out.println("Enter the 10 charter String : ");
			str = sc.next();
			try 
			{
				if (str.length() != 10) 
				{
					throw new UserDefineException("String should be 10 charter String");
				} 
				else 
				{
					System.out.println(str);
					break;
				}
			} 
			catch (UserDefineException e) 
			{
				e.printStackTrace();
			} 
		}
			

	}

}
