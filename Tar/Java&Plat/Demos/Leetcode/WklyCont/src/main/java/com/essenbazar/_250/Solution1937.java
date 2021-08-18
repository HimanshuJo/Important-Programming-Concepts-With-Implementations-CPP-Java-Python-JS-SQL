package com.essenbazar._250;

class Solution1937 {
	public long maxPoints(int[][] points) {
		if (points == null || points.length == 0)
			return 0;
		long[] pre = new long[points[0].length];
		for (int i = 0; i < points[0].length; i++)
			pre[i] = points[0][i];// initialize pre array as points[0];
		for (int i = 1; i < points.length; i++) {
			// Reduce Space from O(mn) to O(n) by long[] pre and long[] curr and swap in the
			// end
			long[] curr = new long[points[0].length];
			long[] leftMax = new long[points[0].length];
			long[] rightMax = new long[points[0].length];
			// Part 1: How we build the leftMax and how we use the leftMax for any 0<= j <
			// numberOfCol
			// a0 a1 a2 a3 a4 a5
			// j= 0 a0
			// j= 1 a0-1 a1
			// j= 2 a0-2 a1-1 a2
			// j= 3 a0-3 a1-2 a2-1 a3
			// j= 4 a0-4 a1-3 a2-2 a3-1 a4
			// j= 5 a0-5 a1-4 a2-3 a3-2 a4-1 a5 build rightMax using these value, which we
			// need scan from left to right
			// store {a0-5,Math.max(a0-5,a1-4),...,Math.max(a0-5,...,a5)} into
			// leftMax/database
			// then for any 0<= j < numberOfCol, max = leftMax[j]+numberOfCol-1-j
			// E.g if j = 3, which store in leftMax is Math.max(a0-5,a1-4,a2-3,a3-2}
			// max= Math.max {a0-3,a1-2,a2-1,a3}
			// We can see the diff is 2, which is numberOfCol-1-j = 6-1-3 = 2;
			for (int j = 0; j < pre.length; j++) {
				if (j == 0)
					leftMax[j] = pre[j] - (points[0].length - 1 - j);
				else
					leftMax[j] = Math.max(leftMax[j - 1], pre[j] - (pre.length - 1 - j));
			}
			// Part 2: How we build the rightMax and how we use the rightMax for any 0<= j <
			// numberOfCol
			// a0 a1 a2 a3 a4 a5
			// j= 0 a0 a1-1 a2-2 a3-3 a4-4 a5-5 build rightMax with these value, and scan
			// from right to left
			// j= 1 a1 a2-1 a3-2 a4-3 a5-4
			// j= 2 a2 a3-1 a4-2 a5-3
			// j= 3 a3 a4-1 a5-2
			// j= 4 a4 a5-1
			// j= 5 a5
			// store {Math.max(a0,...,a5-5),...,Math.max(a4-4,a5-5),a5-5} into
			// rightMax/database
			// then for any 0<= j < numberOfCol, max= right[j]+j
			// E.g if j = 3, which store in rightMax/database is Math.max(a3-3,a4-4,a5-5)
			// max = Math.max{a3,a4-1,a5-2}
			// we can see the diff is 3, which is j = 3;
			for (int j = pre.length - 1; j >= 0; j--) {
				if (j == pre.length - 1)
					rightMax[j] = pre[j] - j;
				else
					rightMax[j] = Math.max(rightMax[j + 1], pre[j] - j);
			}
			// Part 3: Getting the max and store it
			// for any 0<=j<numberOfRow, we can read and compare leftMax/database +
			// shiftLeft and rightMax/database + shiftRight
			// to get and store max
			for (int j = 0; j < points[0].length; j++) {
				curr[j] = points[i][j] + Math.max(leftMax[j] + points[0].length - 1 - j, rightMax[j] + j);
			}
			pre = curr;
		}
		return findMax(pre);
	}

	private long findMax(long[] pre) {
		long max = Long.MIN_VALUE;
		for (int i = 0; i < pre.length; i++) {
			max = Math.max(max, pre[i]);
		}
		return max;
	}
}