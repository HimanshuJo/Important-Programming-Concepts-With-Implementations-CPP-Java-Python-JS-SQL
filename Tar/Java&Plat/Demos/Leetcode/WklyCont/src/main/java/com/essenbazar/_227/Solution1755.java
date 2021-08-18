package com.essenbazar._227;

/*

You are given an integer array nums and an integer goal.

You want to choose a subsequence of nums such that the sum of its elements is
the closest possible to goal.

That is, if the sum of the subsequence's elements is sum, then you want to minimize
the absolute difference abs(sum - goal).

Return the minimum possible value of abs(sum - goal).

Note that a subsequence of an array is an array formed by removing some elements
(possibly all or none) of the original array.

Example 1:

Input: nums = [5,-7,3,5], goal = 6
Output: 0
Explanation: Choose the whole array as a subsequence, with a sum of 6.
This is equal to the goal, so the absolute difference is 0.

 */

/*

Meet in the Middle:

   Looking at the constraints:

       1 <= nums.length <= 40
       -10^7 <= nums[i] <= 10^7
       -10^9 <= goal <= 10^9

   First obvious though that come into the mind is that the problem resembles 0-1 knapsack problem
       whose time complexity is O(n*k)

       and then we calculate what is the closest possible sum

       however, this possibility is ruled out because the fact is that the goal is very large
           we won't be able to calculate this in 1 sec as [40 * (10^9) > 10^8]

   Efficient approach is to use the 'MEET IN THE MIDDLE'

       we primarily divide the  array into two parts [0, N / 2) [N / 2, N)

       we then brute force the solution in both the half and then using the binary search to calculate
           the closest subsequence sum

*/

/*

Intuition:

   Theoretically we can brute force all the possible sums for all the subsequences of the nums here
       (by using DFS or backtracking)

       If we do that we will have 2^n combinations or total different sums we can calculate

           The reason being is that, for each number we have either pick or not pick
               that's why the total combinations for this kind of sum is 2^n

   Here since we can't handle 2^40, we can use the technique called 'Meet in the Middle'
       Here imp point to note that we can handle 2^20

       That basically means we can split the nums into two parts

           and we can use the DFS or brute force to calculate all the possible sums
               on each side

           Suppose after calculating the sums we get sum1 from the left side and
               sum2 from the right side

               we can basically loop through the total number of the sums

*/
/*
Approach:
   1. Generate all the possible subsequence sums from one half of the array, and store it
       in a list/set. Let's call it 'first'
   2. Sort this list/set in ascending order (default sorting order)
   3. Generate all the possible subsequence sums from the other half of the array, and store it
       in a list/set. Let's call it 'second'
   4. For each possible subsequence sum, say 'currSum' from the second half of the array, we can
       calculate how far off this sum is from the desired goal.
       Let's call it the value 'left'
   5. Try to find an exact match for the 'left' in 'first' via binary Search
       If an exact match is found in 'first' we will be able to reach goal using
           the currSum(from the second half) + left(from the first half)
       We we stop here and return 0
   6. If no exact match is found, we find the
       largest subsequence sum < left from 'first' and
       smallest subsequence sum > left from 'first'

       we will consider these as the fit candidates for our answer
       we can update our answer
           ans = Math.min(ans, Math.abs(candidate + currSum - goal))
   7. Having iterated over all the subsequences from 'second', we would by now have found
       the most suitable candidate.
       Return the candidate

*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1755 {

	int[] arr;

	public int minAbsDifference(int[] nums, int goal) {
		arr = nums;
		int n = nums.length;
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		generate(0, n / 2, 0, first);
		generate(n / 2, n, 0, second);
		Collections.sort(first);
		int ans = Integer.MAX_VALUE;
		for (int secondSetSum : second) {
			int left = goal - secondSetSum; // how far are we from the desired goal
			// if all the subsets from first half are too big, we choose the smallest
			if (first.get(0) > left) {
				ans = Math.min(ans, Math.abs((first.get(0) + secondSetSum) - goal));
				continue;
			}
			// if all the subsets from the first half are too small, we choose the largest
			if (first.get(first.size() - 1) < left) {
				ans = Math.min(ans, Math.abs((first.get(first.size() - 1) + secondSetSum) - goal));
				continue;
			}
			int pos = Collections.binarySearch(first, left);
			// if exact match found (first.get(pos) + secondSetSum == goal
			if (pos >= 0) {
				return 0;
			} else {
				pos = -1 * (pos + 1);
			}
			int low = pos - 1;
			// checking for the floor value
			ans = Math.min(ans, Math.abs(secondSetSum + first.get(low) - goal));
			ans = Math.min(ans, Math.abs(secondSetSum + first.get(pos) - goal));
		}
		return ans;
	}

	void generate(int i, int end, int sum, List<Integer> listOfSubsetSums) {
		if (i == end) {
			listOfSubsetSums.add(sum);
			return;
		}
		generate(i + 1, end, sum + arr[i], listOfSubsetSums);
		generate(i + 1, end, sum, listOfSubsetSums);
	}
}
