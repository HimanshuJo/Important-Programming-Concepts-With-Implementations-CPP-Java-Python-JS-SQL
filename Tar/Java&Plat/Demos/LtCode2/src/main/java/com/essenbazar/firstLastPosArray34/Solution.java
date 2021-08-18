/*

Given an array of integers nums sorted in ascending order, find the
starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?


Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

 */

/*

Every time we see the word sorted, we just want to think of 'Binary Search'

O(log N) also indicates that we can use Binary Search

-------

Binary Search template:

   we have to indicate the search scope

       low, high

   and every time we get the middle value

       middle =  low + (high - low) / 2  // we want to avoid integer overflow

We can apply two binary search functions; one for the starting index, and the other for the
   ending index

first BinarySeach function 'findFirst()'

   here we want to go left while searching in the array

       but when do we go right:

           nums[mid] < target

other function is caleed 'findLast()'

   here we want to go right while searching in the array

       but when do we go left:

           nums[mid] > target

*/
package com.essenbazar.firstLastPosArray34;

import java.util.Arrays;

public class Solution {

	public int[] searchRange(int[] nums, int target) {

		int n = nums.length;
		int left = findFirst(nums, target, n); // here cond. for when do we go right
		int right = findLast(nums, target, n); // here cond. for when do we go left
		return new int[] { left, right }; // the array will've left as one element and right as another
	}

	private int findFirst(int[] nums, int target, int n) {
		int low = 0;
		int high = n - 1;
		int index = -1;
		// why <= because we've to return a value
		// so we need to search every position
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (nums[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
			if (nums[middle] == target) {
				index = middle;
			}
		}
		return index;
	}

	private int findLast(int[] nums, int target, int n) {
		int low = 0;
		int high = n - 1;
		int index = -1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (nums[middle] > target) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
			if (nums[middle] == target) {
				index = middle;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		System.out.println(Arrays.toString((my_obj.searchRange(nums, target))));
	}
}
