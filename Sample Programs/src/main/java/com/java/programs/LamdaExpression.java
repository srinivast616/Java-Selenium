package com.java.programs;

public class LamdaExpression {

	    public static void main(String[] args) {
	        // Traditional way
	        Runnable r1 = new Runnable() {
	            public void run() {
	                System.out.println("Running thread - traditional way");
	            }
	        };
	        r1.run();

	        // Lambda way
	        Runnable r2 = () -> System.out.println("Running thread - lambda way");
	        r2.run();
	    }
	}


