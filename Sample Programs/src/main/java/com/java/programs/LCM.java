package com.java.programs;

import java.util.Scanner;

public class LCM {	

		    // Method to find GCD using Euclidean algorithm
	public static int findGCD(int a, int b) {
		while (b != 0) {
		int temp = b; 
		b = a % b;	
		a = temp;  
		}
		  return a;
		}

		    // Method to find LCM of two numbers
	public static int findLCM(int a, int b) {
		    return (a * b) / findGCD(a, b);
		    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		 // Read three numbers
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();

		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();

		System.out.print("Enter third number: ");
		int num3 = scanner.nextInt();

		// Find LCM of three numbers
		int lcm12 = findLCM(num1, num2);
		int finalLCM = findLCM(lcm12, num3);

		        // Display result
		  System.out.println("LCM of " + num1 + ", " 
		        + num2 + ", and " + num3 + " is: " + finalLCM);

		  scanner.close();
	}
}


