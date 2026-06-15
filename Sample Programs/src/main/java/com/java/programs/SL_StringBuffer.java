package com.java.programs;

public class SL_StringBuffer {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer("welcome");
		
		System.out.println("sb1 capacity before append:" +sb1.capacity());
		sb1.append("Hello, ");
		System.out.println("sb1 capacity after first append:" +sb1.capacity());
		sb1.append("Java is my favourite language");
		System.out.println("sb1 capacity after second append:" +sb1.capacity());
		
		System.out.println("sb2 capacity before revers:" +sb2.capacity());
		sb2.reverse();
		System.out.println("sb2 capacity after reverse:" +sb2.capacity());
		
		System.out.println(sb1);
		System.out.println(sb2);

	}

}
