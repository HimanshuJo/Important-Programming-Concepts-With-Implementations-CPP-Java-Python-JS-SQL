
package com.essenbazar.maxNumKSumPairs;

/*

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and
remove them from the array.

Return the maximum number of operations you can perform on the array.

*/
import java.util.Arrays;

public class Solution {
	public int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int count = 0;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum > k)
				end--;
			else if (sum < k)
				start++;
			else {
				end--;
				start++;
				count++;
			}
		}
		return count;
	}
}
