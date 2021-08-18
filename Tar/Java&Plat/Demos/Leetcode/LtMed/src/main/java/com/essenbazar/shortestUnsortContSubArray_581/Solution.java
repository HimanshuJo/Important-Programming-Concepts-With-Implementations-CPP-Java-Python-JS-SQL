/*
Project for solving some common algorithm problems
 */
package com.essenbazar.shortestUnsortContSubArray_581;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author himanshu
 */
class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int res = 0;
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> map_ = new HashMap<>();

        int temp_res1 = 0;
        int temp_res2 = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            map_.put(i, nums[i]);
        }

        for (int i = map.size() - 1; i >= 0; i--) {
            if (!map.get(i).equals(map_.get(i))) {
                temp_res1 = i;
                break;
            }
        }

        for (int i = 0; i < map.size(); i++) {
            if (!map.get(i).equals(map_.get(i))) {
                if (i == 0) {
                    i += 1;
                    temp_res1++;
                }
                temp_res2 = i;
                break;
            }
        }

        if (temp_res1 > 0 && temp_res2 > 0) {
            for (int i = temp_res2; i <= temp_res1; i++) {
                res++;
            }
        }
        return res;
    }
}
