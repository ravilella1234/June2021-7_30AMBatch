package com.hdfc.loans.carloans;

public class ThirdClass 
{

	//data -- properties
	int a=10, b=20, result;
	
	//operation -- behaviuors
	public void add()
	{
		result = a+b;
		System.out.println("Add of A & B is  :" + result);
	}
	
	
	public void sub()
	{
		result = a-b;
		System.out.println("Sub of A & B is : " + result);
	}
	
	
	public static void main(String[] args) 
	{
		//int x = 100;
		//String  name = "vmware";
		
		ThirdClass obj = new ThirdClass();
		obj.add();
		obj.sub();
		
		ThirdClass obj1 = new ThirdClass();
		obj1.add();
		obj1.sub();
	}
	
}


