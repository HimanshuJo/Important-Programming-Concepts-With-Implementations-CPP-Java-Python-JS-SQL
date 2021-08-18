package com.essenbazar._244;

// Determine Whether Matrix Can Be Obtained By Rotation

/*
 * Given two n x n binary matrices mat and target, return true if it is possible to make
 * mat equal to target by rotating mat in 90-degree increments, or false otherwise.
 *
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
	Output: true
	Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 */

import java.util.Arrays;

public class Solution1886 {

	static void rotate90Clockwise(int a[][], int N) {
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
				int temp = a[i][j];
				a[i][j] = a[N - 1 - j][i];
				a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
				a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
				a[j][N - 1 - i] = temp;
			}
		}
	}

	public static boolean equal(final int[][] arr1, final int[][] arr2) {
		if (arr1 == null) {
			return (arr2 == null);
		}
		if ((arr2 == null) || (arr1.length != arr2.length)) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (!Arrays.equals(arr1[i], arr2[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean findRotation(int[][] mat, int[][] target) {
		if (equal(mat, target)) {
			return true;
		}
		for (int i = 0; i < mat.length; ++i) {
			rotate90Clockwise(mat, mat.length);
			if (equal(mat, target)) {
				return true;
			}
		}
		return false;
	}
}
