package com.essenbazar._238;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*
 *
 * You want to build n new buildings in a city.
 *
 * The new buildings will be built in a line and are labeled from 1 to n.
 *
 * However, there are city restrictions on the heights of the new buildings:
 *
 * The height of each building must be a non-negative integer. The height of the
 * first building must be 0. The height difference between any two adjacent
 * buildings cannot exceed 1.
 *
 * Additionally, there are city restrictions on the maximum height of specific
 * buildings. These restrictions are given as a 2D integer array restrictions
 * where restrictions[i] = [idi, maxHeighti] indicates that building idi must
 * have a height less than or equal to maxHeighti.
 *
 * It is guaranteed that each building will appear at most once in restrictions,
 * and building 1 will not be in restrictions.
 *
 * Return the maximum possible height of the tallest building.
 *
 * Input: n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]] Output: 5
 * Explanation: The green area in the image indicates the maximum allowed height
 * for each building. We can build the buildings with heights
 * [0,1,2,3,3,4,4,5,4,3], and the tallest building has a height of 5.
 *
 */
class Solution1840 {

	public int maxBuilding(int n, int[][] restrictions) {
		Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));

		int prevId = 1, prevH = 0, lastH = n - 1;

		// initially going from left to right and propagating the restrictions
		for (int[] arr : restrictions) {
			arr[1] = Math.min(arr[1], prevH + arr[0] - prevId);
			prevId = arr[0];
			prevH = arr[1];
		}

		lastH = Math.min(lastH, prevH + n - prevId);

		// going from right to left and propagating the restrictions
		for (int i = restrictions.length - 2; i >= 0; --i) {
			restrictions[i][1] = Math.min(restrictions[i][1],
					restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
		}

		int l = 1, h1 = 0, ans = 0;

		for (int[] arr : restrictions) {
			ans = Math.max(ans, Math.max(h1, arr[1]) + (arr[0] - 1 - Math.abs(arr[1] - h1)) / 2);
			l = arr[0];
			h1 = arr[1];
		}

		ans = Math.max(ans, Math.max(h1, lastH) + (n - l - Math.abs(lastH - h1)) / 2);

		return ans;
	}

	public static void main(String[] args) {
		Solution1840 myObj = new Solution1840();

		int[][] restrictions = new int[][] { { 5, 3 }, { 2, 5 }, { 7, 4 }, { 10, 3 } };

		myObj.maxBuilding(10, restrictions);
	}
}
