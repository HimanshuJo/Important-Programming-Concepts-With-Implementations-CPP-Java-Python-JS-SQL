
package com.essenbazar.mostCompetitiveSubseq1673;

/*

Given an integer array nums and a positive integer k, return the most competitive
subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero)
elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length)
if in the first position where a and b differ, subsequence a has a number less than the
corresponding number in b.

For example, [1,3,4] is more competitive than [1,3,5] because the first position they
differ is at the final number, and 4 is less than 5.

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence:
{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.

 */

/*

Using a mono increasing stack

Details:

    We keep a mono increasing stack as result

    If a current element 'a' is smaller than the last element in the stack,
        we replace it to get a smaller sequence

    Before we do this:
        we need to check if we still have enough elements after

        After we pop the last element from stack, we have
            stack.size() - 1 in the stack

        There are A.size() - i can still be pushed

        If stack.size() - 1 + A-size() - i >= k, we pop the stack

    Then, is the stack not full with k element, we push A[i] into the stack

    Finally we return the stack as the result directly

 */
import java.util.Stack;

public class Solution {
	public int[] mostCompetitive(int[] nums, int k) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[k];
		for (int i = 0; i < nums.length; i++) {
			while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
				stack.pop();
			}
			if (stack.size() < k) {
				stack.push(i);
			}
		}
		for (int i = k - 1; i >= 0; i--) {
			result[i] = nums[stack.pop()];
		}
		return result;
	}
}
