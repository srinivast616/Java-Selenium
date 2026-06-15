package com.java.programs;

public class SL_LambdaExpression1 {
	
	public static void main(String[] args)
	{
		SL_LambdaExpression_Interface display = (int a) -> a;
		System.out.println("Returns value from lambda expression = " +display.show(100));
	}

}
