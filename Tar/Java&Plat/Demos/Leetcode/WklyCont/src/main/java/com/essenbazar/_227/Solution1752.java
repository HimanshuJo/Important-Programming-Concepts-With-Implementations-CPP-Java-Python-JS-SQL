package com.essenbazar._227;

import java.util.Arrays;

/**
 *
 * @author himan
 */

/*

Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such
that A[i] == B[(i+x) % A.length], where % is the modulo operation.

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

 */
class Solution1752 {

    public boolean check(int[] nums) {

        int[] nums_ = new int[nums.length];  // create copy of original nums array
        System.arraycopy(nums, 0, nums_, 0, nums.length);

        // sort original nums and store in sorted nums array
        int[] sorted_nums = new int[nums.length];
        Arrays.sort(nums);
        System.arraycopy(nums, 0, sorted_nums, 0, nums.length);

        // create a rotate sorted nums
        int[] rotated_nums = new int[sorted_nums.length];

        // add elements to the rotated sorted nums
        for (int x = 1; x <= nums.length; x++) {
            for (int j = 0; j < sorted_nums.length; j++) {
                rotated_nums[j] = sorted_nums[(j + x) % sorted_nums.length];
            }

            // if rotated sorted nums equals original nums return true
            System.out.println(Arrays.toString(rotated_nums));
            boolean areEqual = Arrays.equals(rotated_nums, nums_);
            System.out.println("areEqual is: " + areEqual);
            System.out.println("-------");

            if (areEqual) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1752 my_obj = new Solution1752();
        int[] nums = {2, 1, 3, 4};
        System.out.println(my_obj.check(nums));
    }
}
