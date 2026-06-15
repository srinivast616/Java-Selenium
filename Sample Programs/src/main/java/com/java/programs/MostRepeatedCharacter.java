package com.java.programs;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Collections;

public class MostRepeatedCharacter {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter the string :");
			
			String str = in.nextLine();
			
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
			
			for (char ch : str.toCharArray()) {
				
				if (map.containsKey(ch)) {
					
					int val = map.get(ch);
					
					map.put(ch, val + 1);
					
				} else {
					
					map.put(ch, 1);
				}
			}

			System.out.println(map);
			
			for (Entry<Character, Integer> entry : map.entrySet()) {
				
				System.out.println(entry.getKey()+"-"+entry.getValue());
			}

			LinkedHashSet<Integer> values = new LinkedHashSet<Integer>();			

			for (Entry<Character, Integer> entry : map.entrySet()) {
				
				values.add(entry.getValue());
			}
			
			int max = Collections.max(values);

			for (Entry<Character, Integer> entry : map.entrySet()) {
				
				if (entry.getValue().equals(max)) {
					
					System.out.println("most repeated character:" + entry.getKey());
				}
			}
		}

		catch (Exception e) {
			
			System.out.println(e);
		}

		finally {
			
			in.close();
		}

	}

}
