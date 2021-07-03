package com.hdfc.loans.collections;

import java.util.HashMap;
import java.util.Hashtable;

public class TestDemo 
{

	public static void main(String[] args) 
	{
		/*
		 * HashMap<String , String> hm = new HashMap<String, String>(); hm.put(null,
		 * null); hm.put("key1", null); hm.put("key2", null); hm.put("key3", null);
		 * 
		 * System.out.println(hm);
		 */
		
		Hashtable<String , String> ht = new Hashtable<String, String>();
		
		ht.put("one", "1");
		System.out.println(ht);
		
	}

}
