
package com.essenbazar.longSubArraySumDivByK;

import java.util.HashMap;

/*
 *
 * Given an arr [] containing n integers and a positive integer k
 *
 * The problem is to find the length of the longest subarray with sum of the
 * elements divisible by the given value k
 *
 * Input: arr [] = {2, 7, 6, 1, 4, 5}
 *
 * K = 3;
 *
 * Output: 4
 *
 * The subarray is {7, 6, 1, 4} with sum 18 which is divisible by 3
 *
 */

public class Main {

	public static int longSubarrayWithSumDivByK(int[] arr, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] modArr = new int[n];
		int max = 0;
		int curSum = 0;

		// building here the modArray
		for (int i = 0; i < n; ++i) {
			curSum += arr[i];

			// as the sum can be negative, therefore we need to take the modulo twice
			modArr[i] = ((curSum % k) + k) % k;
		}

		for (int i = 0; i < n; ++i) {

			// if the below condition is true, then sum(0..i) is divisible by k
			if (modArr[i] == 0) {
				max = i + 1;
			}

			// if the value is not present in the map, then we can store it in the map
			// with the index of its first occurrence
			else if (map.containsKey(modArr[i]) == false) {
				map.put(modArr[i], i);
			} else {

				// if we reach here then we have to update max
				// Based on the idea that
				// if at any index of modArr[]
				// first we get the index of that element and then
				// we get the value from the map (which, if the value is divisible by x will be
				// 0)
				// will always result in i getting bigger than map.get(modArr[i])
				// so in that case we have to update the value

				if (max < (i - map.get(modArr[i]))) {
					max = i - map.get(modArr[i]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 6, 1, 4, 5 };
		System.out.println(Main.longSubarrayWithSumDivByK(arr, arr.length, 3));
	}
}
