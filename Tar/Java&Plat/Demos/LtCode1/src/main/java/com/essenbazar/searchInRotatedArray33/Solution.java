/*
Project for solving some common algorithm problems
 */
package com.essenbazar.searchInRotatedArray33;

/**
 *
 * @author himanshu
 */

/*
 * 
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * 
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
 * [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the rotation and an integer target, return the
 * index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 */

/*
 * 
 * Intution:
 * 
 * In the array is not shifted, then it would be simply a standard binary search
 * in the increasing sequence
 * 
 * There are two ways to approach such problems: 1. Use Binary Search to find
 * the minimum element in the array for example suppose we have an array arr =
 * {4, 5, 6, 7, 0, 1, 2}
 * 
 * We can ask about the middle element, and we need to decide in some way if we
 * are still in this bigger part here it would be the numbers from 4 to 7
 * 
 * So, how can we do this,
 * 
 * when we ask queries to the number let's say 6 to decide if we are still in
 * the bigger part
 * 
 * what we need to do is to compare it with the first element
 * 
 * All the numbers in the prefix, they will satisfy the property of being equal
 * to or greater than the first number
 * 
 * So, if the middle element greater than equal to the number, then we are still
 * in the left part (where we have the bigger numbers)
 * 
 * so in that case, we have to go to the right to find the minimum
 * 
 * -------
 * 
 * If we are asking the queries of the element smaller than the first one we
 * need to go to the left
 * 
 * or the current element might be the minumum
 * 
 * -------
 * 
 * 2. Now that we know where the split is in that case we can decide where the
 * target is
 * 
 * In that case, we can perform the standard binary search to find the target
 * 
 * -------
 * 
 * Time:
 * 
 * 2 * (log n) --> for the queries
 * 
 * We can however, do that in just log n queries
 * 
 */
class Solution {

	public int search(int[] nums, int target) {
		int n = nums.length;

		if (n == 0) {
			return -1;
		}
		int low = 0, high = n - 1;

		// in alternative version of this problem, this would be a function or a query
		// and I need to minimize the number of times I access array nums
		int firstEle = nums[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int value = nums[mid];
			if (value == target) {
				return mid;
			} // here we have to decide either we go to the left or to right
				// here I can maybe check whether I am in the big part
			boolean amBig = value >= firstEle;
			boolean targetBig = target >= firstEle;
			int val = Boolean.compare(amBig, targetBig);
			if (val == 0) {
				// that means I am in the same increasing part
				// then i just need to compare values
				if (value < target) {
					// value is small and target in big, but both are in the bigger part
					// here we have to increase the low
					// Binaray search should be towards the mid
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// otherwise target is less than the element
				// I shouldn't be comparing the values, but I need to
				// go to the other half
				if (amBig) {
					// that basically means that the target is not big
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
