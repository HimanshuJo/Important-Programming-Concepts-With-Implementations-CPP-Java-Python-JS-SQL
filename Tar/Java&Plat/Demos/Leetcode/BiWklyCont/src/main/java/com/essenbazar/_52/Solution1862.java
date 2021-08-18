package com.essenbazar._52;

import java.util.HashMap;

/*
Given an integer array nums, return the sum of floor(nums[i] / nums[j]) 
for all pairs of indices 0 <= i, j < nums.length in the array. 
Since the answer may be too large, return it modulo 10^9 + 7.

The floor() function returns the integer part of the division.

Example 1:

Input: nums = [2,5,9]
Output: 10
Explanation:
floor(2 / 5) = floor(2 / 9) = floor(5 / 9) = 0
floor(2 / 2) = floor(5 / 5) = floor(9 / 9) = 1
floor(5 / 2) = 2
floor(9 / 2) = 4
floor(9 / 5) = 1
We calculate the floor of the division for every pair of indices in the array then sum them up.
 */
/*
The simplest method that everyone would come up with is to calculate
   floor(nums[i], nums[j]) for each pair and add them up
   
   // ommitted modulo operations
   int n = nums.length;
   int sum = 0;
   for (int i = 0; i < n; ++i) {
       for (int j = 0; j < n; ++j) {
           sum += nums[i] / nums[j];
       }   
   }

   However, since there are 10^5 elements in total, such an O(n^2) solution would TLE for larger
       inputs

   Slight modification is required:
       Only consider the elements in groups rather than individually

   Observe that the problem description kindly restricts the value of array elements to the range
       [1, 10^5]

       Hence the quotient of any pair cannot exceed 10^5 as well

   We want to sum the floored quotients of paired elements.
       For any integer x between 
           k * a <= x < (k + 1) * a
       where a and k are the positive integers
           floor(x / a) = k holds

           Thus given the divisor a, what really matters is to which interval an integer x belongs

   For an integer a, the following intervals [0, 2a), [a, 2a), [2a, 3a), ... correspond to the
       floored quotients 1, 2, 3, ... respectively

       Since the dividend, divisor and quotient fall into [1, 10^5], the number of intervals
           is bounded by 10^5 / a

       There can be multiple a's but they should be identical for our purpose and can be simply
           counted together

   Therefore we can use counting sort to store the count of each value in the original array
   
   Then we consider each value one by one as a divisor.

       Now we only need to compute how many elements fall into the intervals above separately

       If there are m elements that fall into [k * a, (k + 1) * a), we add m * k to our result

   The only problem is how to count the numbers in an interval efficiently.

       We can notice that all the values fall into the range(1, 10^5) and we already count
           them using counting sort
       As in the output phase in counting sort, let counts[i] += count[i - 1] for each value
           from i = 1 to 10^5
       In this way, counts array stores the number of elements j such that j <= i, and thus
           the number of elements that fall into [a, b) can be represented by 
               counts[b - 1) - counts[a - 1]

   -------

Time:

   For each divisor a between 1<= a <= n, we consider n / a intervals, and we can retrieve
       the number of elements falling into specific interval in O(1) time

       Therefore the running time is:

           t(n) <= n/1 + n/2 + n/3 + ... + n/n
                <= n * (1/1 + 1/2 + 1/3 .... + 1/n)
                <= n * log (n)
*/

/*
We need to observe that the result of floor(nums[i] / nums[j]), will be -

    0 if nums[i] < nums[j]
    1 if nums[j] <= nums[i] < (2 * nums[j])
    2 if 2 * nums[j] <= nums[i] < (3 * nums[j])
    and so on..

    We can use this to build a frequency array and then calculate the prefix sum of it.

    After this, for every num in nums, we will add the answer into sum as per the above observation.

      All the numbers in the range [0, num - 1] will contribute 0 to the sum each. 
        The frequency of numbers in this range will be given by freq[num - 1] - freq[0].

    All the numbers in the range [num, 2*num - 1] will contribute 1 to the sum each. 
      Frequency: freq[num] - freq[2num - 1].

    Numbers in [2*num, 3*num - 1] will contribute 3 each. 
      Frequency: freq[2num] - freq[3num - 1].

    And so on till our range covers the maximum element of the nums array...

*/

public class Solution1862 {

	static final int MAX = (int) 1e5;
	static final int MOD = (int) 1e9 + 7;

	public int sumOfFlooredPairs(int[] nums) {
		int[] counts = new int[MAX + 1];
		for (int num : nums) {
			counts[num]++;
		}
		for (int i = 1; i <= MAX; ++i) {
			counts[i] += counts[i - 1];
		}
		long total = 0;
		for (int i = 1; i <= MAX; ++i) {
			if (counts[i] > 0) {
				long sum = 0;
				// [i * j, i * (j + 1)) would derive the quotient of j
				for (int j = 1; i * j <= MAX; ++j) {
					// need to limits for this question
					int lower = i * j - 1;
					int upper = i * (j + 1) - 1;
					sum += (counts[Math.min(upper, MAX)] - counts[lower]) * (long) j;
				}
				total = (total + (sum % MOD) * (counts[i] - counts[i - 1])) % MOD;
			}
		}
		return (int) total;
	}
}

// Using HashMap to not count the duplicate numbers
class SolutionUsingHashMap {
	public static int sumOfFlooredPairs(int[] nums) {
		int MAX = Integer.MIN_VALUE, MOD = (int) 1e9 + 7;
		int[] freq = new int[2 * 100000 + 1];
		for (int num : nums) {
			freq[num]++;
			MAX = Math.max(MAX, num);
		}
		for (int num = 1; num <= 2 * MAX; num++) {
			freq[num] += freq[num - 1];
		}
		int total = 0;
		HashMap<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (seen.containsKey(nums[i])) {
				total += seen.get(nums[i]);
			} else {
				int sum = 0;
				// to start with nums[i], dividing all the numbers from nums[i] to 2 * nums[i] -
				// 1
				int left = nums[i], right = 2 * nums[i] - 1, floorDiv = 1;
				while (left <= MAX) {
					sum += floorDiv * (freq[right] - freq[left - 1]) % MOD;
					sum %= MOD;
					// shifting the range from 2 * nums[i] to 3 * nums[i] - 1 and so on
					left += nums[i];
					right += nums[i];
					floorDiv += 1;
				}
				seen.put(nums[i], sum);
				total += sum;
			}
			total %= MOD;
		}
		return total;
	}
}