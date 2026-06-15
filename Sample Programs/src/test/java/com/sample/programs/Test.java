package com.sample.programs;

class Test {
	
	static void show()
	{
		System.out.println("Super class show");
		
	}
	
	static class staticmethods
	{
		void show()
		{
			System.out.println("sub class show");
		}
	}
	
 public static void main(String[] args)
 {
	 Test.show();
	 new Test.staticmethods().show();
 }
}
