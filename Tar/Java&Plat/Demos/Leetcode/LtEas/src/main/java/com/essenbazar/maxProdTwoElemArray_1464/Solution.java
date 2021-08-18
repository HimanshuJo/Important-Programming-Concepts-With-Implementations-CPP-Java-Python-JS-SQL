package com.essenbazar.maxProdTwoElemArray_1464;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*

Given the array of integers nums, you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).
 
Example 1:

Input: nums = [3,4,5,2]
Output: 12

Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the
maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 

 */

class Solution {

    public int maxProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        Integer first_high = Collections.max(map.values());
        for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == first_high) {
                map.remove(entry.getKey());
                break;
            }
        }
        Integer second_high = Collections.max(map.values());
        return ((first_high - 1) * (second_high - 1));
    }
}

// shorter version

class Solution2 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return ((nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1));
    }
}
