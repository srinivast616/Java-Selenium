package com.java.programs;

import java.util.Scanner;
import java.util.ArrayList;
public class DigCount
{
    public static void main(String[] args)
    {
        System.out.println("Enter the number");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(num!=0)
        {
            int rem = num%10;
            digits.add(rem);
            num = num/10;
        }
        
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int i=0;i<digits.size()-1;i++)
        {
            if(lst.contains(digits.get(i)))
            {
                continue;
            }
            int count = 1;
            for(int j=i+1;j<=digits.size()-1;j++)
            {
                if(digits.get(i)==digits.get(j))
                {
                    count++;
                    lst.add(digits.get(i));
                }
            }
            System.out.println("Occurance of integer "+digits.get(i)+" is:" +count);
        }     
     }
}