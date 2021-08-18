/*
Project for solving some common algorithm problems
 */
package com.essenbazar.LongestHarmomiousSubsequence;

/**
 *
 * @author himan
 */

/*

We define a harmonious array as an array where the difference between its maximum value and
its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among
all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or
no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Example 2:
Input: nums = [1,2,3,4]
Output: 2

Example 3:
Input: nums = [1,1,1,1]
Output: 0

 */

 /*

Algo 1:

    Storing count of each element in a map

    Iterating over map for every key
        If map contains a key that is key + 1
            
            Result = Max(result, count(key) + count(key + 1))
    
    Time: O(n)

    Space: O(n)

-------

Algo 2:

    Sort the array
    
    Comparing the consecutive elements
        
        If the difference = 1, find the length of the subarray with these elements

 */

import java.util.*;

public class Solution {

    public int findLHS(int [] nums) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i : count.keySet()) {
            if (count.containsKey(i + 1)) {
                result = Math.max(result, count.get(i) + count.get(i + 1));
            }
        }
        return result;
    }
    
    public int findLHS2(int [] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int result = 0;
        
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            if (diff == 1) result = Math.max(result, right - left + 1);
            if (diff <= 1) right++;
            else left++;
        }
        
        return result;
    }
}
