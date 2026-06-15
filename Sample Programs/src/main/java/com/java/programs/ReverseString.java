package com.java.programs;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the value");

		String input = in.nextLine();

		reverse(input);

	}

	public static void reverse(String s)

	{

		String[] words = s.split("\\s");

		for (int i = words.length - 1; i >= 0; i--)

		{

			System.out.print(words[i] + " ");

		}
		

	}
}
