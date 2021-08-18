package com.essenbazar._235;

/*
Project for solving some weekly contest problems
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author himanshu
 */

/*
 *
 * Algo:
 *
 * Suppose we have two arrays and we have calculate their absolute sum
 * difference without replacing any element in array1
 *
 * e.g. suppose arr1 = {1, 10, 4, 4, 2, 7} arr2 = {9, 8, 5, 1, 7, 4}
 *
 * diff = {8, 7, 1, 3, 5, 3} --> sum of their difference is 27
 *
 * Now if I want to minimize the sum of the I can replace at most one element in
 * arr1
 *
 * For individual element in arr1, I basically have to minimize the difference
 * so to mimimize the difference let'S say for example for {1, 9}
 *
 * I should choose a number, that is closest to 9 (element in arr2) in arr1
 *
 * so the element closest to 9 is 10 (at index 1 in arr1)
 *
 * Another example, suppose I want to minimize the difference for {4, 1}
 *
 * I should choose a number, that is closest to 1 (element in arr2) in arr1
 *
 * so the element closest to 1 is 2 (at index 4 in arr1)
 *
 * Best diff = {1, 1, 1, 0, 0, 0}
 *
 * -------
 *
 * After calculating the best diff I will calculate how much I have saved as
 * regard to the previous diff
 *
 * saved = {7, 6, 0, 2, 5, 3}
 *
 * Finally the best saved will be the 7 points
 *
 *
 */
class SolutionNC {

	public int binarySearch(int[] nums1Copy, int value) {
		int l = 0;
		int r = nums1Copy.length - 1;
		while (l < r) {
			int m = l + ((r - l) / 2);
			if (nums1Copy[m] == value) {
				return m;
			} else if (nums1Copy[m] > value) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return l;
	}

	static int LowerBound(int a[], int x) { // x is the target value or key
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m] >= x) {
				r = m;
			} else {
				l = m;
			}
		}
		return r;
	}

	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int sum = 0;
		int n = nums1.length;
		int mod = 1_000_000_007;

		List<Integer> diff = new ArrayList<>();

		List<Integer> bestDiff = new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < n; ++i) {
			diff.add(Math.abs(nums1[i] - nums2[i]));
			sum += (diff.get(i)) % mod; // because it can be integer overflow
		}

		Arrays.sort(nums1); // now we can use Lower Bound method

		for (int i = 0; i < n; ++i) {
			// calculating lower Bound

			// num1 = {1, 10, 4, 4, 2, 7} num2 = {9, 8, 5, 1, 7, 4}
			// for example suppose we are at element 5 in nums2
			// Now we want to get the index of the number that is closest to 5 and which is
			// not less than 5 in nums1
			// int j = lower_bound(nums1.begin(), nums1.end(), nums2[i]) - nums1.begin();
			// nums1.begin() is the range --> from where to where I have to locate
			int j = binarySearch(nums1, nums2[i]);

			if (j != 0 && j != n) {
				bestDiff.set(i, Math.min(Math.abs(nums2[i] - nums1[j]), Math.abs(nums2[i] - nums1[j - 1])));
			} else if (j == 0) {
				bestDiff.set(i, Math.abs(nums2[i] - nums1[j]));
			} else if (j == n) {
				bestDiff.set(i, Math.abs(nums2[i] - nums1[j - 1]));
			}
		}

		int bestSave = 0;
		for (int i = 0; i < n; ++i) {

			bestSave = Math.max(bestSave, diff.get(i) - bestDiff.get(i));
		}

		return (sum - bestSave) % mod;
	}
}
