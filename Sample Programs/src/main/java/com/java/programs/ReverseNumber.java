package com.java.programs;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = in.nextInt();
		int rev = 0;
		while(n>0)
		{
			int rem = n%10;
			rev = 10*rev + rem;
			int div = n/10;
			n = div;
		}

		System.out.println(rev);
	
	}	

}
