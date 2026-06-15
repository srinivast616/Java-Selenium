package com.java.programs;

import java.util.Scanner;

public class ReverseStringWords {

	public static String reverseword(String str)

	{

		String words[] = str.split("\\s");

		String revWord = " ";

		for (String w : words)

		{

			StringBuilder sb = new StringBuilder(w);

			sb.reverse();

			revWord = revWord + sb.toString() + " ";

		}

		return revWord.trim();

	}

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		try

		{

			System.out.println("Enter the string");

			String st = in.nextLine();

			String rev = reverseword(st);

			System.out.println(rev);

		}

		catch (Exception e)

		{

			System.out.println(e);

		}

		finally

		{

			in.close();

		}

	}

}
