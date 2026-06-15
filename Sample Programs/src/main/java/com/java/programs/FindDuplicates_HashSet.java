package com.java.programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FindDuplicates_HashSet {

	public static void main(String[] args) {
		System.out.println("Enter the string:");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
//					System.out.println(str.charAt(i));
					set.add(str.charAt(i));
				}
			}
		}
		System.out.println(set);
		
		Iterator<Character> itr = set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}
}
