package com.java.programs;

//yorh#sjfoj$dohf%

import java.util.Scanner;

public class Replace {
	
	public static void main(String[] args)
	{
		System.out.println("Enter the StringProgram_intw");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
	
//		StringProgram_intw new_string = str.replaceAll("[@#$%^&]", "");
//		System.out.println(str.replaceAll("[@#$%^&]", ""));
//		System.out.println(str);
//		System.out.println(new_string);
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(str);
		System.out.println(sb);
		
	}

}
