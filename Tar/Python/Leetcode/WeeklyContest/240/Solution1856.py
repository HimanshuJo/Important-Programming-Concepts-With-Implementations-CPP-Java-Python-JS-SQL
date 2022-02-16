'''
The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

    For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.

Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. 
Since the answer may be large, return it modulo 10^9 + 7.

Note that the min-product should be maximized before performing the modulo operation. 
Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit 
signed integer.

A subarray is a contiguous part of an array.

Input: nums = [1,2,3,2]
Output: 14
Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
2 * (2+3+2) = 2 * 7 = 14.

'''


class Solution:

    def maxSumMinProduct(self, nums):
        res = 0
        stack = []  # will be monotonic increasing order
        prefixArr = [0]

        for n in nums:
            prefixArr.append(prefixArr[-1] + n)

        for (i, n) in enumerate(nums):
            newStart = i

            # if our stack is non empty and 'stack's top's value' is greater than n

            while stack and stack[-1][1] > n:
                (start, value) = stack.pop()

                # since this value is now being popped, what we are saying is that
                # we just determined what is the max sub-array it could possibly have been a part of
                # so now we're end up computing what the minimum product it would have been

                total = prefixArr[i] - prefixArr[start]

                res = max(res, value * total)

                # and last but not the least, what we're gonna do since we popped a value
                # the end value we will ultimately be adding to our stack

                newStart = start

            stack.append((newStart, n))

            # by the end of the while loop we'll have added every single value to the stack
            # but we won't necessarily have popped every value from the stack

        for (start, val) in stack:
            total = prefixArr[len(nums)] - prefix[start]
            res = max(res, val * total)

        return res % (10 ** 9 + 7)
