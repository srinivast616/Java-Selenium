package com.java.programs;

public class Test {

	public static void main(String[] args) {

		String x = "Srinivas";
		String y = new String("Srinivas");
		
		System.out.println(x==y);
		System.out.println(x.equals(y));
		
		System.out.println("'srinivas'");
		
		Integer n1 = 10;
		Integer n2 = Integer.valueOf(10);
		
		System.out.println(n1==n2);
		System.out.println(n1.equals(n2));		
		
	}

}
