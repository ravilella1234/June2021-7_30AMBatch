package com.hdfc.loans.carloans;

public interface Rbi 
{
	int x =100;
	
	public void withdrawl();  // Abstract method
	public void deposit();
	
	public static void main(String[] args) 
	{
		//Rbi i = new Rbi();
		
		Rbi i;
		
		i = new Icici();
		i.deposit();
		i.withdrawl();
		
		i = new Hdfc();
		i.deposit();
		i.withdrawl();
	}

}
