package com.essenbazar._246;

// Minimum Absolute Difference Queries
/*
 * The minimum absolute difference of an array a is defined as the minimum value of
 * |a[i] - a[j]|, where 0 <= i < j < a.length and a[i] != a[j].
 *
 * If all elements of a are the same, the minimum absolute difference is -1.
 *
 * For example, the minimum absolute difference of the array [5,2,3,7,2] is |2 - 3| = 1.
 * Note that it is not 0 because a[i] and a[j] must be different.
 *
 * You are given an integer array nums and the array queries where queries[i] = [li, ri].
 * For each query i, compute the minimum absolute difference of the subarray
 * 	nums[li...ri] containing the elements of nums between the 0-based indices
 * 	li and ri (inclusive).
 *
 * Return an array ans where ans[i] is the answer to the ith query.

	A subarray is a contiguous sequence of elements in an array.

	The value of |x| is defined as:

	    x if x >= 0.
	    -x if x < 0.

Example 1:

Input: nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
Output: [2,1,4,1]
Explanation: The queries are processed as follows:
- queries[0] = [0,1]: The subarray is [1,3] and the minimum absolute difference is |1-3| = 2.
- queries[1] = [1,2]: The subarray is [3,4] and the minimum absolute difference is |3-4| = 1.
- queries[2] = [2,3]: The subarray is [4,8] and the minimum absolute difference is |4-8| = 4.
- queries[3] = [0,3]: The subarray is [1,3,4,8] and the minimum absolute difference is |3-4| = 1.

 */

/*
 * Naive Approach:
 * 	For each of the query, we have to traverse the array between the range {l, r}
 * 		, then probably we can sort the array to get the minimum of the numbers in the range
 *
 * 	As in the worst case the size of the nums array could be 10^5,
 * 		this approach won't work, as complexity will be O(n^2)
 *
 * 	However, the other constraint is helpful for our approach:
 * 		1 <= nums[i] <= 100
 *
 * 	class Solution:
 * 		def minDifference(self, nums: List[int], queries: List[List[int]]) -> List[int]:
 * 			maxNum = max(nums)
 * 			n = len(nums)
 * 			preSum = [[0] * (maxNum + 1)]
 * 			for num in nums:
 * 				curSum =  preSum[-1][:]
 * 				curSum[num] += 1
 * 				preSum.append(curSum)
 * 			ans = []
 * 			for l, r in queries:
 * 				mmin = sys.maxsize
 * 				pre = -1
 * 				for num in range(1, maxNum + 1):
 * 					cnt = preSum[r + 1][num] - preSum[l][num]
 * 					if cnt > 0:
 * 						if pre != -1:
 * 							mmin = min(min, num - pre)
 * 						pre = num
 * 				ans.append(mmin if mmin < sys.maxsize else -1)
 * 			return ans
 *
 * Time: O(n*100)
 *
 * -------
 *
 * In essence, we can use 100 prefix sum arrays to count each number, so we can determine in O(1)
 * 		time, if a number appears in [l, r] interval
 *
 * We can iterate through [1, 100] and check that number appears in the query range
 *
 * 	Then we can track the minimum difference between consecutive numbers
 */

class Solution1906 {
	public int[] minDifference(int[] nums, int[][] queries) {
		int len = nums.length;
		int[][] count = new int[len + 1][101];
		for (int i = 1; i <= len; ++i) {
			for (int j = 1; j <= 100; ++j) {
				count[i][j] = count[i - 1][j] + (nums[i - 1] == j ? 1 : 0);
			}
		}
		int[] res = new int[queries.length];
		int index = 0;
		for (int[] query : queries) {
			int ab = Integer.MAX_VALUE;
			Integer prev = null;
			for (int k = 1; k <= 100; ++k) {
				if (count[query[1] + 1][k] - count[query[0]][k] > 0) {
					ab = Math.min(ab, prev == null ? Integer.MAX_VALUE : k - prev);
					prev = k;
				}
			}
			res[index++] = ab == Integer.MAX_VALUE ? -1 : ab;
		}
		return res;
	}
}
