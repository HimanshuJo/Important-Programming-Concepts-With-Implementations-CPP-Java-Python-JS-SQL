'''

Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.


'''

'''

Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
    return max_so_far


'''




from itertools import combinations
class Solution:
    def maxSubArray(self, nums):
        size = len(nums)
        max_sum = nums[0]
        traversal = nums[0]

        for i in range(1, size):
            traversal = max(traversal + nums[i], nums[i])
            max_sum = max(max_sum, traversal)

        print(max_sum)
        return max_sum


class Solution2:
    def maxSubArray(self, nums):
        r = len(nums)
        a1 = []
        while r > 0:
            a1.append(list(combinations(nums, r)))
            r -= 1
            value = 0
            my_dict = {}
        # print(a1)
        for r in a1:
            for c in r:
                # print(c)
                # print(sum(c))
                if(sum(c) > value):
                    value = sum(c)
                    my_dict[c] = sum(c)
                # print("-------")
            # print()
        # print(my_dict)
        Keymax = max(my_dict, key=my_dict.get)
        print(Keymax)


test_instance = Solution()
test_instance.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
