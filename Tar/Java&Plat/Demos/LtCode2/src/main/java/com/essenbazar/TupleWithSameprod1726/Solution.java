
package com.essenbazar.TupleWithSameprod1726;

/*

Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d)
such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d

Example 1:

Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (3,4,2,6) , (3,4,6,2) , (4,3,6,2)

*/

/*

Basic idea is that once we have found a pair (a,b,c,d) such that ab = cd
    we can arrange this pair in 4 ways

    (a,b,c,d)
    (a,b,d,c)
    (b,a,c,d)
    (b,a,d,c)

    (c,d,a,b)
    (d,c,a,b)
    (c,d,b,a)
    (d,c,b,a)

    For every distinct abcd, I have 4 ways

*/

import java.util.*;

public class Solution {

	public int tupleSameProduct(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				res += 8 * map.getOrDefault(nums[i] * nums[j], 0);
				map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
				System.out.println(res);
				System.out.println("-------");
				System.out.println(map.getOrDefault(nums[i] * nums[j], 0));

			}
		}
		System.out.println(map.toString());
		return res;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] nums = { 2, 3, 4, 6 };
		my_obj.tupleSameProduct(nums);
	}

}
