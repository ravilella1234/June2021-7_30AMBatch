package com.hdfc.loans.carloans;

public class Hdfc implements Rbi
{

	@Override
	public void withdrawl() {
		System.out.println("iam overriden withdrawl in HDFC");
	}

	@Override
	public void deposit() {
		System.out.println("iam overriden deposit in HDFC");
	}
	
	public static void main(String[] args) 
	{
		Hdfc h = new Hdfc();
		h.deposit();
		h.withdrawl();
		
	}

}
