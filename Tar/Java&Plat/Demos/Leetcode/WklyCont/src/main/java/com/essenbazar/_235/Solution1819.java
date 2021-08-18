package com.essenbazar._235;

/*
Project for solving some weekly contest problems
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*
 *
 * You are given an array nums that consists of positive integers.
 *
 * The GCD of a sequence of numbers is defined as the greatest integer that
 * divides all the numbers in the sequence evenly.
 *
 * For example, the GCD of the sequence [4,6,16] is 2.
 *
 * A subsequence of an array is a sequence that can be formed by removing some
 * elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 *
 * Return the number of different GCDs among all non-empty subsequences of nums.
 *
 * Input: nums = [6,10,3] Output: 5 Explanation: The figure shows all the
 * non-empty subsequences and their GCDs. The different GCDs are 6, 10, 3, 2,
 * and 1.
 *
 */

/*
 *
 * Algo:
 *
 * Generating all subsets and finding the gcd will give you to TLE
 *
 * We can try to build optimization around based on the constraint 1 <= nums[i]
 * <= 2 * 10 ^ 5
 *
 * The limit is 200_000 and we can find GCD for all the numbers available
 * between them we can limit to the 'max' number in the input array, nums
 *
 * Making a set exist for easy existence check for the number in the nums
 *
 * Increment the counter count if the gcd between the numbers matches
 *
 */
public class Solution1819 {
	int max = 0;
	Set<Integer> set = new HashSet<>();

	public int countDifferentSubsequenceGCDs(int[] nums) {
		getMax(nums); // get max elemenet from the nums array

		for (int num : nums)
			set.add(num);

		int count = 0;

		for (int i = 1; i <= max; ++i)
			if (findGCD(i))
				count++;

		return count;
	}

	public void getMax(int[] nums) {
		for (int i : nums)
			max = Math.max(max, i);
	}

	public int gcd(int a, int b) {
		return (a == 0) ? b : gcd(b % a, a);
	}

	public boolean findGCD(int num) {
		int val = 0;
		for (int i = num; i <= max; i += num)
			if (set.contains(i))
				val = gcd(i, val);
		return (val == num);
	}
}
