package com.essenbazar._54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Check if All the Integers in a Range Are Covered
/*
 * You are given a 2D integer array ranges and two integers left and right. 
 * Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.

	Return true if each integer in the inclusive range [left, right] is covered by at least one 
	interval in ranges. Return false otherwise.

	An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
	
	Example 1:

	Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
	Output: true
	Explanation: Every integer between 2 and 5 is covered:
	- 2 is covered by the first range.
	- 3 and 4 are covered by the second range.
	- 5 is covered by the third range.
	
	Example 2:
	
	Input: ranges = [[1,10],[10,20]], left = 21, right = 21
	Output: false
	Explanation: 21 is not covered by any range.
 */

/*
 * The range is this problem is limited to 50, so it did not matter much. 
 * But with larger n and more ranges, we will need a linear line sweep solution.
 */

import java.util.List;

public class Solution1893 {
	public boolean isCovered(int[][] ranges, int left, int right) {
		List<Integer> arr = new ArrayList<>();
		for (int i = left; i <= right; ++i) {
			arr.add(i);
		}
		// System.out.println(arr.toString());
		List<Integer> list = new ArrayList<>();
		for (int[] arr_ : ranges) {
			int left_ = arr_[0];
			int right_ = arr_[1];
			for (int i = left_; i <= right_; ++i) {
				list.add(i);
			}
		}
		Collections.sort(list);
		// System.out.println(list.toString());
		for (int num : arr) {
			if (!list.contains(num)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution_LineSweep obj = new Solution_LineSweep();
		int[][] nums = { { 1, 5 }, { 3, 20 }, { 21, 25 }};
		int left = 1;
		int right = 9;
		long start = System.currentTimeMillis();
		System.out.println(obj.isCovered(nums, left, right));
		System.out.println("-------");
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}

// Time: O(n + m), where m is the number of ranges.
// Memory: (n)

class Solution_LineSweep {
	public boolean isCovered(int[][] ranges, int left, int right) {
		int[] line = new int[50];
		for (int[] r : ranges) {
			line[r[0]] += 1;
			line[r[1] + 1] -= 1;
		}
		System.out.println(Arrays.toString(line));
		System.out.println("-------");
		for (int i = 1, overlaps = 0; i <= right; ++i) {
			overlaps += line[i];
			if (i >= left && overlaps == 0)
				return false;
		}
		return true;
	}
}
