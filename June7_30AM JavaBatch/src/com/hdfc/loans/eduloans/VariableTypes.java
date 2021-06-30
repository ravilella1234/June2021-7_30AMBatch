package com.hdfc.loans.eduloans;

public class VariableTypes 
{
	//primitive variable
	int x = 100; // instance (or) instance-global (or) non-static variable
	static String cname = "vmware"; // static (or) static-global
	static VariableTypes obj;
	
	public void m1()
	{
		int x = 200; // local variable
		//System.out.println(y);
		
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(VariableTypes.cname);
	}
	
	public static void m2()
	{
		obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
	}
	
	
	public static void main(String[] args) 
	{
		obj = new VariableTypes(); // reference variable
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
	}

}
