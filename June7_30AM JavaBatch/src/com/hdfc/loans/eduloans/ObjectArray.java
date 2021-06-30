package com.hdfc.loans.eduloans;


class Student 
{
	int sno;
	String sname;
	
	
	public Student(int sno, String sname) 
	{
		super();
		this.sno = sno;
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + "]";
	}

}



public class ObjectArray 
{

	public static void main(String[] args) 
	{
		Student s1 = new Student(100, "ravilella");
		Student s2 = new Student(200, "sai");
		Student s3 = new Student(300, "kiran");
		
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s3);
		
		Student[] st = new Student[3];
		st[0]=s1;
		st[1]=s2;
		st[2]=s3;
		
		for(Student s:st)
		{
			System.out.println(s);
		}

	}

}
