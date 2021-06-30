package com.hdfc.loans.eduloans;

public class StringDemo 
{

	public static void main(String[] args) 
	{
		String s1 = "ravikanth";
		System.out.println(s1);
		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf('i'));
		System.out.println(s1.length());
		System.out.println(s1.hashCode());
		
		
		String s2 = new String("Ravikan");
		System.out.println(s2);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.contains(s2));
		
		System.out.println(s2);
		System.out.println(s2.toLowerCase());
		System.out.println(s2.toUpperCase());
		
		System.out.println(s1.contains(s2.toLowerCase()));
		
		//System.out.println(s1+s2);
		System.out.println(s1.concat(s2));
		
		System.out.println(s1);
		//System.out.println(s1.replace('r', 'k'));
		
		String s3 = " ravikanth";
		System.out.println(s3);
		System.out.println(s1.equals(s3));
		System.out.println(s1.contains(s3));
		//System.out.println(s3.trim());
		System.out.println(s1.equals(s3.trim()));
		
		System.out.println(s1);
		System.out.println(s1.substring(2, 7));
		
		String s4 = "ravi kanth lella";
		String[] str = s4.split(" ");
		for(String s:str)
		{
			System.out.println(s);
		}
		
		
		String s5= "ravikanth";
		System.out.println(s5.startsWith("ravi"));
		
		System.out.println(s5.endsWith("anth"));
		
	}

}
