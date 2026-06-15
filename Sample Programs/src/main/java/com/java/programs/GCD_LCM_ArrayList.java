package com.java.programs;

import java.util.ArrayList;
import java.util.Scanner;
public class GCD_LCM_ArrayList{
	public static int findGCD(int x, int y)
    {
        while(y!=0)
        {
//        int temp = x%y; 10
        int temp = y;
//        y=x;   10
        y = x%y;
        x = temp; //10
        }
        return x;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Enter the number of inputs:");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=1;i<=count;i++){
            System.out.println("enter the number:");
            int num = in.nextInt();
            nums.add(num);
        }
        
        int gcd = nums.get(0);
        int lcm = 1;
        
        for(int k=0;k<nums.size()-1;k++)
        {
             gcd = findGCD(gcd,nums.get(k));
             lcm = (gcd*nums.get(k))/gcd;
            
        }
        
        System.out.println("GCD: " +gcd);
        System.out.println("LCM: " +lcm);
    }
}