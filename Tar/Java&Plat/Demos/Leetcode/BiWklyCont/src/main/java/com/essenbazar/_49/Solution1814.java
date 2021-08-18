package com.essenbazar._49;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * You are given an array nums that consists of non-negative integers.
 * 
 * Let us define rev(x) as the reverse of the non-negative integer x.
 * 
 * For example, rev(123) = 321, and rev(120) = 21.
 * 
 * A pair of indices (i, j) is nice if it satisfies all of the following
 * conditions:
 * 
 * 0 <= i < j < nums.length nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 
 * Return the number of nice pairs of indices. Since that number can be too
 * large, return it modulo 10^9 + 7.
 * 
 * Input: nums = [42,11,1,97] Output: 2 Explanation: The two pairs are: - (0,3)
 * : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121. - (1,2) : 11 +
 * rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
 * 
 */

/*
 * 
 * Algo:
 * 
 * We are asked to find pair (i, j) such that i < j and num[i] + rev(nums[j]) =
 * num[j] + rev(num[i])
 * 
 * Obviously looking for each pair (i, j) won't work
 * 
 * It will lead to the time complexity of O(n^2)
 * 
 * The above equation can be modified as:
 * 
 * num[i] - rev(num[i]) = num[j] - rev(num[j])
 * 
 * We can see we are required to find number the pairs whose 'difference between
 * original and reversed number is the same'
 * 
 * So we can just find the frequency of numbers having a particular n - rev(n)
 * value and store them in a hashmap
 * 
 * Finally we just have to count the pairs which can be formed which is:
 * 
 * freq[i] * (freq[i] - 1) / 2
 */

public class Solution1814 {

	public int countNicePairs(int[] A) {
		int res = 0, mod = (int) 1e9 + 7;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : A) {
			int b = rev(num);
			// for each integer count it's current frequency for final result
			// in other words, get hold of the current count
			int v = map.getOrDefault(num - b, 0);
			// map helps to accumulate and find the frequency
			map.put(num - b, map.getOrDefault(num - b, 0) + 1);
			System.out.println(v);
			System.out.println(map.toString());
			System.out.println("-------");
			// for each individual count, make changes to the result
			res = (res + v) % mod;
		}
		return res;
	}

	public int rev(int a) {
		int b = 0;
		while (a > 0) {
			b = b * 10 + (a % 10);
			a /= 10;
		}
		return b;
	}
}