package com.java.programs;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		System.out.println("Enter two numbers:");
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();

		System.out.println("Enter the operator:");
		char op = in.next().charAt(0);

		switch (op) {
		case ('+'): {
			System.out.println(n1 + n2);
			break;
		}
		case ('-'): {
			System.out.println(n1 - n2);
			break;
		}
		case ('*'): {
			System.out.println(n1 * n2);
			break;
		}
		case ('/'): {
			System.out.println(n1 / n2);
			break;
		}
		}
	}

}
