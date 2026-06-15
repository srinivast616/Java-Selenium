package com.java.programs;

import java.util.Arrays;

public class ArrayMaxElement {

	public static void main(String[] args) {
		
		int[] nums = {20,30,10,50,60};
		
		Arrays.sort(nums);
//		for(int i = 0;i<nums.length-1;i++)
//		{
//			System.out.print(nums[i]+",");
//		}
		System.out.println("max element: " +nums[nums.length-1]);
		
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]<=nums[j])
				{
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}			
		}
		
		System.out.println("max element: " +nums[0]);
	}

}
