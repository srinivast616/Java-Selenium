package com.java.programs;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FindDuplicates_HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the String:");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] chars = str.toCharArray();
		LinkedHashMap<Character,Integer> map = new LinkedHashMap();
		for(char ch:chars)
		{
			if(map.containsKey(ch)) 
			{
				int val = map.get(ch);
				map.put(ch, val+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		
		for(Entry<Character,Integer> entry:map.entrySet())
		{
			 if(entry.getValue()>=2)
			 {
				System.out.println(entry.getKey());
			 }
			
		}
		

	}

}
