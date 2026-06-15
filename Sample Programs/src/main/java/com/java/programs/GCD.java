	package com.java.programs;
	
	import java.util.ArrayList;
	import java.util.Collections;
		
	public class GCD {
	
		public static ArrayList<Integer> getFactors(int num) {
			ArrayList<Integer> factors = new ArrayList<Integer>();
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					factors.add(i);
				}
			}
			return factors;
		}
	
		public static void main(String[] args) {
			int num1 = 10;
			int num2 = 20;
			int num3 = 30;
					
			ArrayList<Integer> f1 = getFactors(num1);
			ArrayList<Integer> f2 = getFactors(num2);
			ArrayList<Integer> f3 = getFactors(num3);
			ArrayList<Integer> common = new ArrayList<Integer>();
			
			for(int i:f1)
			{
				if(f2.contains(i)&&f3.contains(i))
				{
					common.add(i);
				}
			}
			
			int gcd = Collections.max(common);
			System.out.println(gcd);
			
			/*		
			for (int i = 0; i <count; i++) 
			{
				System.out.println("Enter the number:");
				int num = in.nextInt();
				nums.add(num);
			}		
			
	
	//		GCD gcd = new GCD();
			for (int i = 0; i < nums.size(); i++) 
			{
				ArrayList<Integer> factors = getFactors(nums.get(i));
				for(int k=0;k<factors.size();k++)
				{
					System.out.println(factors.get(k));
				}
			}
		  */
		}
	}
