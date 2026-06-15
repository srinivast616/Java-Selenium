package com.java.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CharactersCount {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		try {

			System.out.println("Enter the string :");

			String str = in.nextLine();

			LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

			for (char ch : str.toCharArray()) {

				if (map.containsKey(ch))

				{

					int val = map.get(ch);

					map.put(ch, val + 1);

				}

				else

				{
					map.put(ch, 1);

				}
			}

			System.out.println(map);

			ArrayList<Integer> values = new ArrayList<Integer>();

			for (Entry entry : map.entrySet())

			{

				// System.out.println(entry.getKey() + "-" + entry.getValue());
				values.add((Integer) entry.getValue());

			}

			int max = values.get(0);
			for (int i : values) {
				if (values.get(i) > max) {
					max = values.get(i);
				}
			}
			
			for (Entry entry : map.entrySet())

			{

				if(entry.getValue().equals(max))
				{
					System.out.println("most repeated character:" +entry.getKey());
					
					
				}

			}
		}

		catch (Exception e) {

			System.out.println(e);

		}

		finally

		{

			in.close();

		}

	}

}
