package com.java.programs;

import java.util.HashSet;
import java.util.Scanner;

public class AdjacentDuplicates {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the value:");

		String input = in.nextLine();

		adjacentDuplicates(input);

	}

	public static void adjacentDuplicates(String str)

	{
		HashSet<Character> charset = new HashSet<Character>();
		
		for(int i=0;i<str.length()-1;i++)
		{
			if (str.charAt(i)==str.charAt(i+1))
					{
//						charset.add(str.charAt(i));
//						System.out.println(str.charAt(i));
					}
		}
		
		System.out.println(charset);
		
	}
}
