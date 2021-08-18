
package com.essenbazar.sortMatrixDiagonally1329;

/*
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the 
 * topmost row or leftmost column and going in the bottom-right direction until 
 * reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], 
 * where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

	Given an m x n matrix mat of integers, sort each matrix diagonal in ascending 
	order and return the resulting matrix.
	
	Example 1:
	
	Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
	Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 */

/*

A[i][j] on the same diagonal have same value of i - j

For each diagonal, put its element together and set them back

Complexity:
    Time O(M N log D) where D is the length of the diagonal with
        D = min(M,N)

*/

import java.util.*;

public class Solution {

	public int[][] diagonalSort(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				d.putIfAbsent(i - j, new PriorityQueue<>());
				d.get(i - j).add(A[i][j]);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = d.get(i - j).poll();
			}
		}

		return A;
	}
}
