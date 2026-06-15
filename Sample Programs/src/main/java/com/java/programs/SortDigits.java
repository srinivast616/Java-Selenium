package com.java.programs;

import java.util.ArrayList;

public class SortDigits {
	public static void main(String[] args) {
		int number = 947863;
		ArrayList<Integer>digits = new ArrayList<Integer>();
					
			while(number>0) {
				int rem = number % 10;
				digits.add(rem);
				number = number / 10;								
			}		

		for (int i = 0; i < digits.size() - 1; i++) {
			for (int j = i + 1; j < digits.size(); j++) {
				int x = digits.get(i);
				int y = digits.get(j);
				if (digits.get(i) > digits.get(j)) {
					int temp = digits.get(i);
					temp = x;
					x = y;
					y = temp;
				}
			}
		}
		
		int sorted_num = 0;
		for (int i = 0; i <= digits.size() - 1; i++) {
			sorted_num = 10*sorted_num+digits.get(i);
		}
		System.out.println(sorted_num);
		
//		for (int i = 0; i <= digits.size() - 1; i++) {
//			System.out.print(digits.get(i));
//		}
	}
}


/*
class Main {
 public static void main(String[] args) {
     int number = 947863;
     int[] digits = new int[6];
     for(int i=1;i<=digits.length;i++)
     {
     while(number>10)
     {
         int rem = number%10;
         int num = number/10;
         number = num;
         digits[i-1] = rem;
     }
     }
     
    for(int i=0;i<digits.length-1;i++)
    {
        for(int j=i+1;j<digits.length; j++)
        {
            if(digits[i]>digits[j])
            {
                int temp = digits[i];
                digits[i] = digits[j];
                digits[j] = temp;
            }
        }
        
    }
    for(int i=0;i<=digits.length-1;i++)
    {
        System.out.print(digits[i]);
    }
 }
}
*/
