package com.java.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class CharCount {
	public static void main(String[] args) {
		System.out.println("Enter the string:");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		ArrayList<Character> chars = new ArrayList<Character>();
		for (int i = 0; i <= str.length() - 1; i++) {
			int count = 1;
			if (chars.contains(str.charAt(i))) {
				continue;
			}
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == (str.charAt(j))) {
						count++;
					}
				}
			
			chars.add(str.charAt(i));
			System.out.println("Occurance of character " + str.charAt(i) + " is: " + count);
		}

	}

}
