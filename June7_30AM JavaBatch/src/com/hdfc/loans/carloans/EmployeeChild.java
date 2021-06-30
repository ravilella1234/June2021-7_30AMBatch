package com.hdfc.loans.carloans;

public class EmployeeChild extends Employee
{
	String address;
	
	public EmployeeChild(String address) 
	{
		//super();
		super(1746,"sai",23.34f);
		this.address = address;
		
		System.out.println(this.address);
	}
	
	public void m3()
	{
		
	}

	public static void main(String[] args) 
	{
		EmployeeChild ec = new EmployeeChild("hyderabad");
	}

}
