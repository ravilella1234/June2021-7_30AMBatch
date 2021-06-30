package com.hdfc.loans.eduloans;

import java.util.Scanner;

public class DebuggingDemo 
{

	public int m1()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Array Size : ");
		int aSize = sc.nextInt();
		
		int[] a = new int[aSize];
		int sum=0;
			
		System.out.println("Enter the Array Element/Objects : ");
		for(int i=0;i<a.length;i++)
		{
			a[i] = sc.nextInt();
			System.out.println("a["+i+"]="+a[i]);
			sum = sum+a[i];
		}
		System.out.println("Sum of the array is : " + sum);
		return sum;
	}
	
	
	public static void main(String[] args) 
	{		
		DebuggingDemo obj = new DebuggingDemo();
		int count = obj.m1();
		System.out.println("Sum of Array in outside : " + count);
	}

}
