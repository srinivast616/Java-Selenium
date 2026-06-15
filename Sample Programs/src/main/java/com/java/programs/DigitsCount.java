package com.java.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class DigitsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number:");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList<Integer> digits = new ArrayList<Integer> ();
		while(num>0)
		{
			int rem = num%10;
			digits.add(rem);
			num = num/10;
			
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i:digits)
		{
			if (map.containsKey(i))
			{
				int val = map.get(i);
				map.put(i,val+1);
			}
			else
			{
				map.put(i,1);
			}
		}
		
		for(Entry<Integer, Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}

}
