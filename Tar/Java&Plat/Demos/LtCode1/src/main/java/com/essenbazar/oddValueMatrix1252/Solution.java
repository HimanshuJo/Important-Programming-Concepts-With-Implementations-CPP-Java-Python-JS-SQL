package com.essenbazar.oddValueMatrix1252;

/**
 *
 * @author hjoshi
 */

/*
 * 
 * There is an m x n matrix that is initialized to all 0's. There is also a 2D
 * array indices where each indices[i] = [ri, ci] represents a 0-indexed
 * location to perform some increment operations on the matrix.
 * 
 * For each location indices[i], do both of the following:
 * 
 * Increment all the cells on row ri. Increment all the cells on column ci.
 * 
 * Given m, n, and indices, return the number of odd-valued cells in the matrix
 * after applying the increment to all locations in indices.
 * 
 * Input: m = 2, n = 3, indices = [[0,1],[1,1]] Output: 6 Explanation: Initial
 * matrix = [[0,0,0],[0,0,0]]. After applying first increment it becomes
 * [[1,2,1],[0,1,0]]. The final matrix is [[1,3,1],[1,3,1]], which contains 6
 * odd numbers
 * 
 */

class Solution {

	public int oddCells(int n, int m, int[][] indices) {
		int[][] res = new int[n][m];
		int result = 0;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = 0;
			}
		}
		for (int x = 0; x < indices.length; x++) {
			int row = indices[x][0];
			int column = indices[x][1];
			for (int i = 0; i < res[row].length; i++) {
				res[row][i] = res[row][i] + 1;
			}
			for (int d = 0; d < n; d++) {
				res[d][column] = res[d][column] + 1;
			}
		}
		for (int[] arr : res) {
			for (int num : arr) {
				if (num % 2 != 0) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int n = 2;
		int m = 3;
		int[][] indices = { { 0, 1 }, { 1, 1 } };
		my_obj.oddCells(n, m, indices);
	}
}
