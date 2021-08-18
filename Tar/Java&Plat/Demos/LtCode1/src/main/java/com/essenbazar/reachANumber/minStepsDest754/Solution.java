/*

Directory to test few algorithm tasks

 */
package com.essenbazar.reachANumber.minStepsDest754;

/**
 *
 * @author himan
 */

/*
 * You are standing at position 0 on an infinite number line. There is a goal at
 * position target.
 * 
 * On each move, you can either go left or right. During the n-th move (starting
 * from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * Example 1: Input: target = 3 Output: 2 Explanation: On the first move we step
 * from 0 to 1. On the second step we step from 1 to 3.
 * 
 * Example 2: Input: target = 2 Output: 3 Explanation: On the first move we step
 * from 0 to 1. On the second move we step from 1 to -1. On the third move we
 * step from -1 to 2.
 * 
 * Note: target will be a non-zero integer in the range [-10^9, 10^9].
 */

/*
 * Algo:
 * 
 * If target is negative, we can take it as positive because we start from 0 in
 * symmetrical way.
 * 
 * Idea is to move in one direction as long as possible, this will give minimum
 * moves. Starting at 0 first move takes us to 1, second move takes us to 3
 * (1+2) position, third move takes us to 6 (1+2+3) position, ans so on; So for
 * finding target we keep on adding moves until we find the nth move such that
 * 1+2+3+…+n>=target.
 * 
 * Now if sum (1+2+3+…+n) is equal to target the our job is done, i.e we’ll need
 * n moves to reach target.
 * 
 * Now next case where sum is greater than target. Find the difference by how
 * much we are ahead, i.e sum – target. Let the difference be d = sum – target.
 * 
 * If we take the i-th move backward then the new sum will become (sum – 2i),
 * i.e 1+2+3+…-x+x+1…+n. Now if sum-2i = target then our job is done.
 * 
 * Since, sum – target = 2i, i.e difference should be even as we will get an
 * integer i flipping which will give the answer. So following cases arise.
 * 
 * Case 1 : Difference is even then answer is n, (because we will always get a
 * move flipping which will lead to target).
 * 
 * Case 2 : Difference is odd, then we take one more step, i.e add n+1 to sum
 * and now again take the difference.
 * 
 * If difference is even the n+1 is the answer else we would have to take one
 * more move and this will certainly make the difference even then answer will
 * be n+2.
 * 
 * -------
 * 
 * Example:
 * 
 * target = 5. we keep on taking moves until we reach target or we just cross
 * it. sum = 1 + 2 + 3 = 6 > 5, step = 3. Difference = 6 – 5 = 1. Since the
 * difference is an odd value, we will not reach the target by flipping any move
 * from +i to -i. So we increase our step. We need to increase step by 2 to get
 * an even difference (since n is odd and target is also odd). Now that we have
 * an even difference, we can simply switch any move to the left (i.e. change +
 * to -) as long as the summation of the changed value equals to half of the
 * difference. We can switch 1 and 4 or 2 and 3 or 5
 * 
 */

class Solution {
	public int reachNumber(int target) {

		// handling negatives by symmetry
		target = Math.abs(target);

		// keep moving ahead while sum is smaller than the target or the difference is
		// odd
		int sum = 0;
		int step = 0;

		while (sum < target || (sum - target) % 2 != 0) {
			step++;
			sum += step;
		}

		return step;

	}
}
