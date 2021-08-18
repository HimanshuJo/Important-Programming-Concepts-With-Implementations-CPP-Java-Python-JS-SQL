// Reduction Operations to Make the Array Elements Equal

/*
 * Given an integer array nums, your goal is to make all elements in nums equal.
 * To complete one operation, follow these steps:

    Find the largest value in nums. Let its index be i (0-indexed) and its value be largest.
    If there are multiple elements with the largest value, pick the smallest i.

    Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
    Reduce nums[i] to nextLargest.

	Return the number of operations to make all elements in nums equal.
 */

/*
 * Intuition:
 * 	We can sort the array, and go from left to right, from largest to the smallest
 *
 * 	If the current number is the same as the one before it, we do nothing.
 *
 * 		If the number before is different,we need to update all the numbers on the right (n.length - j)
 */

/*
 * Algo:
 *
 * 	Suppose we have an array : {1, 2, 3, 4, 4, 5}
 *
 * 	We can convert all the elements equal to the minimum element of the array
 *
 * 	Count the frequency of each element in the given array
 * 		1 -> 1
 * 		2 -> 1
 * 		3 -> 1
 * 		4 -> 2
 * 		5 -> 1
 *
 * 		At first we have to convert 5 to 4
 * 			hence frequency of 4 now becomes freq[4] + freq[5]
 *
 * 		Next we have to convert all the 4's to 3's, so now frequency of 3 becomes:
 * 			freq[3] + new freq[4]
 *
 * 		Next we have to convert all the 3 to 2, so now frequency of 2 becomes:
 * 			freq[2] + new freq[3]
 *
 *  	This frequency of 2 will be converted to 1 and this will be our final answer
 *
 *  -------
 *
 *  Simulation:
 *  	Initial: ans = 0
 *
 *  	1, 2, 3, 4, 4, 5 -> freq[5] = 1
 *  	1, 2, 3, 4, 4, 4 -> freq[4] = 3 (also it will take one operation to do that, so ans += 1)
 *  	1, 2, 3, 3, 3, 3 -> freq[3] = 4 (it took 3 operations to make 3 4's to 3, so ans += 3)
 *   	1, 2, 2, 2, 2, 2 -> freq[2] = 5 (it took  4 operations to make 4 3's to 2, so ans += 4)
 *   	1, 1, 1, 1, 1, 1 -> freq[1] = 6 (it took 5 operations to make 5 2's to 1, so ans += 5)
 *
 *     		Final ans = 1 + 3 + 4 + 5 = 13
 */

package com.essenbazar._244;

import java.util.Collections;
import java.util.TreeMap;

public class Solution1887 {
	public int reductionOperations(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int res = 0;
		while (map.size() > 1) {
			// get the largest one and its count and add to the step
			int first = map.firstKey();
			int firstCount = map.get(first);
			res += firstCount;
			// remove the largest and count all of them as the second largest
			map.remove(first);
			int second = map.firstKey();
			map.put(second, map.get(second) + firstCount);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution1887 obj = new Solution1887();
		int[] nums = { 5, 1, 3 };
		obj.reductionOperations(nums);
	}
}
