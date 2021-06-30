package com.hdfc.loans.eduloans;

public class TwoDimenssionArray 
{

	public static void main(String[] args) 
	{
		int p[][] = {
						{1,2,3,4},
						{4,5,6},
						{7,8,9,1,2},
					};
		
		for(int i=0;i<p.length;i++)
		{
			for(int j=0;j<p[i].length;j++)
			{
				System.out.print(p[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------");
		
		for(int q[]:p)
		{
			for(int l:q)
			{
				System.out.print(l+"  ");
			}
			System.out.println();
		}
		

	}

}
