package com.hdfc.loans.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapUserDefineObjects 
{

	public static void main(String[] args) 
	{
		Emp e1 = new Emp(100, "ravi");
		Emp e2 = new Emp(200, "sai");
		Emp e3 = new Emp(300, "varun");
		Emp e4 = new Emp(400, "kiran");
		
		//System.out.println(e1);
		//System.out.println(e2);
		//System.out.println(e3);
		//System.out.println(e4);
		
		//e1.display();
		//e2.display();
		//e3.display();
		//e4.display();
		
		
		HashMap<Integer, Emp> h = new HashMap<Integer, Emp>();
		h.put(e1.getEno(), e1);
		h.put(e2.getEno(), e2);
		h.put(e3.getEno(), e3);
		h.put(e4.getEno(), e4);
		
		/*
		 * Set<Entry<Integer, Emp>> entries = h.entrySet(); for(Entry<Integer, Emp>
		 * e:entries) { System.out.println(e.getKey()); Emp ee = e.getValue();
		 * ee.display(); }
		 */
		
		// Aletnative way to print by using Iteratots 
		Iterator<Integer> iterator = h.keySet().iterator();
		while(iterator.hasNext())
		{
			Emp e = h.get(iterator.next());
			e.display();
		}
		
		
	}

}
