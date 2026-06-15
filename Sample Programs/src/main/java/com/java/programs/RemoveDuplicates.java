package com.java.programs;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = in.nextLine();	
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for(int i=0;i<=str.length()-1;i++)
		{
			set.add(str.charAt(i));
		}
		
		System.out.println(set);
		
		
		
		String final_string = "";
		
//		for(char ch:set)
//		{
//			final_string = final_string + ch;
//		}
		
		Iterator<Character> itr = set.iterator();
		
		while(itr.hasNext())
		{
			final_string = final_string + itr.next();
		}
		
		System.out.println(final_string);
	}

}
