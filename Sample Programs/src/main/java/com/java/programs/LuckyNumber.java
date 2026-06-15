package com.java.programs;
import java.util.Scanner;
public class LuckyNumber {

	public static int sumofdigits(int n) {
		int sod = 0;
		while (n > 0) {
			int div = n / 10;
			int rem = n % 10;
			sod = sod + rem;
			n = div;
		}
		return sod;
	}

	public static void main(String[] args) {
		System.out.println("Enter the number:");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int sum = 0;
		while (num > 10) {
			sum = sumofdigits(num);
			num = sum;
		}
		System.out.println(num);
	}
}
