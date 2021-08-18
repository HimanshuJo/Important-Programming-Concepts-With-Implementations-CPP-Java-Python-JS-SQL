package com.essenbazar.searchInsertPosition_35;

/*

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

 */

class Solution {

    public int searchInsert(int[] nums, int target) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                res = i;
                return res;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > target) {
                res = i;
                return res;
            }
        }
        return res;
    }
}
