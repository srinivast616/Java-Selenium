package com.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonElements {
	
	public static void main(String[] args)
	{
	
	ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1,2,4,5,10,20));
	ArrayList<Integer> a2 = new ArrayList<Integer>(List.of(1,3,5,6,10,30));
	
	ArrayList<Integer> a3 = new ArrayList<Integer>(List.of(1,2,10));
	
	ArrayList<Integer> common = new ArrayList<Integer>();
	for(int i:a1)
	{
		if(a2.contains(i) && a3.contains(i))
		{
			common.add(i);
		}
	}
	
	System.out.println(common);
	
//	a1.retainAll(a2);	
//	a1.retainAll(a3);	
//	System.out.println(a1);
	
		
	}
	
	
}
