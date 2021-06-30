package com.hdfc.loans.collections;

import java.util.ArrayList;

public class ListDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(10);
		a.add("ravilella");
		a.add(12.34f);
		a.add(10);
		a.add(20);
		a.add(30);
		
		System.out.println(a);
		System.out.println(a.get(1));
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		
		System.out.println(a.indexOf("ravilella"));
		System.out.println(a.contains("ravilella"));
		System.out.println(a.hashCode());
		
		System.out.println(a.subList(1, 5));
		
		System.out.println(a);
		a.add(100);
		System.out.println(a);
		
		a.add(1, "keerthan");
		System.out.println(a);
		
		a.set(1, "sai");
		System.out.println(a);
		
		a.remove(1);
		System.out.println(a);
		
		a.remove("ravilella");
		System.out.println(a);
		
		a.clear();
		System.out.println(a);
	}
	
	// byte, short, int, long, float, double, boolean, char

}
