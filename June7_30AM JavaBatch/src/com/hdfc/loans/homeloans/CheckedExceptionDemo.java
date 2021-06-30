package com.hdfc.loans.homeloans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionDemo 
{
	
	public static void m1() throws FileNotFoundException
	{
		BufferedReader obj = new BufferedReader(new FileReader("c://abc.txt"));
	}

	public static void main(String[] args) 
	{
		m1();
	}

}
