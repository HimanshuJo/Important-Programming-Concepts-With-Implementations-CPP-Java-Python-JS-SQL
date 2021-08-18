package com.essenbazar.minValToGetPosSumStep_1413;

import java.util.ArrayList;
import java.util.List;

/*

Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.


Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
                step by step sum
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2


*/

class Solution {
    
    private List<Integer> fillList(int[] nums, int firstNum) {
        List<Integer> list_ = new ArrayList<>();
        for (int x = 0; x < nums.length; x++) {
            int calNum = firstNum + nums[x];
            list_.add(calNum);
            firstNum = calNum;
        }
        return list_;
    }
    
    private boolean isGoodList(List<Integer> list) {
        for (int num : list)
            if (num < 1) return false;
        return true;
    }
    
    public int minStartValue(int[] nums) {
        List<Integer> toCheck = new ArrayList<>();
        int firstNum = 1;
        int isFinal = firstNum;
        while (true) {
            toCheck = fillList(nums, firstNum);
            if (isGoodList(toCheck)) return isFinal;
            else {
                firstNum++;
                isFinal = firstNum;
                toCheck.clear();
            }
            //System.out.println(firstNum);
            //System.out.println("-------");
        }
    }
}
