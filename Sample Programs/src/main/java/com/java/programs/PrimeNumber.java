package com.java.programs;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {		
		System.out.println("Enter the number:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean isPrime1 = true;
		if (n <= 1) {
			isPrime1 = false;
		} else {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					isPrime1 = false;
					break;
				}
			}
		}

		if (isPrime1) {
			System.out.println("number is prime");
		} else {
			System.out.println("number is not prime");
		}

		System.out.println("Prime numbers between 1 to 100:");

		for (int num = 2; num <= 100; num++) {
			boolean isPrime2 = true;
			for (int j = 2; j <= num / 2; j++) {
				if (num % j == 0) {
					isPrime2 = false;
					break;
				}
			}
			if (isPrime2) {
				System.out.println(num);
			}

		}

	}

}
