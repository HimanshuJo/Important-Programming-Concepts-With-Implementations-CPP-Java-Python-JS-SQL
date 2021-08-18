
// Special Array With X Elements Greater Than or Equal X
// You are given an array nums of non-negative integers. nums is considered special if there
// exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

// Notice that x does not have to be an element in nums.
// Return x if the array is special, otherwise, return -1.
// It can be proven that if nums is special, the value for x is unique.

// Example 1:

// Input: nums = [3,5]
// Output: 2
// Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

// Example 4:
// Input: nums = [3,6,7,7,0]
// Output: -1

import java.util.*;
import java.util.Arrays;


class Solution
{
    public int specialArray(int[] nums)
    {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            result++;
            if (nums[i] >= result)
            {
                if (i == 0) // reach the beginning of sorted array, means no other number equal or greater than ans
                    return result;
                // previous number less than ans, means no other number equal or greater than ans
                if (nums[i - 1] < result)
                    return result;
            }
            else
                break;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Solution my_obj =  new Solution();
        int[] new_nums = {3, 6, 7, 7, 0};
        my_obj.specialArray(new_nums);
    }
}
