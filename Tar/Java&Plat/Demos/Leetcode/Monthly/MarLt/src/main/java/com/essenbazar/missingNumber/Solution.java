/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.missingNumber;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author himanshu
 */

/*

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.


 */
class Solution {

    public int missingNumber(int[] nums) {
        int lenNums = nums.length;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i <= lenNums; i++) {
            if (!map.containsKey(i)) {
                res = i;
                break;
            }
        }

        return res;
    }
}
