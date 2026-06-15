package com.java.programs;

import java.util.HashMap;
import java.util.Map.Entry;

public class StringProgram_intw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This company is very very good";		
		String[] words = str.split("\\s+");	
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String st: words)
		{
			if(map.containsKey(st))
			{
				int val = map.get(st);
				map.put(st,val+1);				
			}
			else
			{
				map.put(st, 1);
			}
		}
		
		System.out.println(map);
		
		for(Entry entry:map.entrySet())
		{
			if(entry.getKey().equals("very"))
			{
				System.out.println(entry.getKey()+"-"+entry.getValue());
			}
		}
		
//path parameter, how you will create a request in rest assured		
		

	}

}
