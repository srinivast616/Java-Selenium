package com.java.programs;

import java.util.Scanner;

public class GCD2 {	
	
	    // Program to find gcd of three numbers
	    public static int findGCD(int a, int b) {
	        while (b != 0) {
	            int temp = b;
	            b = a % b; 
	            a = temp; 	        }
	        return a;
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

	        // Step 1: Find GCD of first two numbers
	        int gcd12 = findGCD(num1, num2);

	        // Step 2: Find GCD of the result and the third number
	        int finalGCD = findGCD(gcd12, num3);

	        // Display result
	        System.out.println("GCD of " + num1 + ", " + num2 + ", and " + num3 + " is: " + finalGCD);

	        scanner.close();
	    }
	}


