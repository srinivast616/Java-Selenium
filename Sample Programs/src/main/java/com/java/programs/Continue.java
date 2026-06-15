package com.java.programs;

public class Continue {

	public static void main(String[] args) {
		
		 System.out.println("Numbers from 1 to 10, skipping multiples of 3:");

	        for (int i = 1; i <= 10; i++) {
	            if (i % 3 == 0) {
	                continue; // skip multiples of 3
	            }
	            System.out.print(i + " ");
	        }
		}
	}
