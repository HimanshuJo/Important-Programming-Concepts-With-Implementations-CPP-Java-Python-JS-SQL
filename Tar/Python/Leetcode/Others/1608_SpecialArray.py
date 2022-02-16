'''

You are given an array nums of non-negative integers. 
nums is considered special if there exists a number x such that there are exactly x 
numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.


'''

class Solution:
    def specialArray(self, nums):
        nums = sorted(nums, reverse=True)
        print(nums)

        result = -1
        for i in range(len(nums) - 1):
            if nums[i] >= (i + 1) and nums[i + 1] < (i + 1):
                result = (i + 1)

        if nums[-1] >= len(nums):
            result = len(nums)

        return result


test_instance = Solution()
test_instance.specialArray([3, 9, 7, 8, 3, 8, 6, 6])
