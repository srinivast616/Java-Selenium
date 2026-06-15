package com.java.programs;

public class SortArray {
	public static void main(String[] args) {
		int[] nums = { 10, 40, 30, 20, 60 };
		int temp;
		for (int i = 0; i <= nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i <= nums.length-1; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
