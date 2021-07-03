package com.hdfc.loans.collections;

public class Employee1 
{
	private int eno=100;
	private String ename="sai";
	
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public static void main(String[] args) 
	{
		Employee1 e1 = new Employee1();
		//System.out.println(e1.eno);
		//System.out.println(e1.ename);
		
		e1.setEno(1744);
		e1.setEname("ravilella");
		
		System.out.println(e1.getEno());
		System.out.println(e1.getEname());
	}

}
