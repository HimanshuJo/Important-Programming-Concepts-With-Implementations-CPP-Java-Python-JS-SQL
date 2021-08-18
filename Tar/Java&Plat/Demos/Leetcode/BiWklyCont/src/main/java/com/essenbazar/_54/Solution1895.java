package com.essenbazar._54;

import java.util.Arrays;

// Largest Magic Square
/*
 * A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum,
and both diagonal sums are all equal. The integers in the magic square do not have to be distinct.
Every 1 x 1 grid is trivially a magic square.

Given an m x n integer grid, return the size (i.e., the side length k) of the
largest magic square that can be found within this grid.

Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
Output: 3
Explanation: The largest magic square has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j] <= 106
 */

/*
 * This is particularly an implementation based question.
	We have to check all the possible squares, within the grid

	Furthermore for each of the square we have to check, all the rows and all the columns
    also the left and the right diagonal, whether they have the same sum or not
    
	A small improvement we can make here is:
    given a particular grid of any dimensions, when we check in any of our rows and columns
    we don't have to check teh rows and the columns one-by-one
    
    We can already calculate a preSum of each row and each column
        so that we can check for each row in O(1) time
 */

public class Solution1895 {

	public int largestMagicSquare(int[][] g) {
		int R = g.length, C = g[0].length, rows[][] = new int[R][C + 1], cols[][] = new int[R + 1][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				// create cumulative sums for each of the rows
				rows[i][j + 1] = rows[i][j] + g[i][j];
				// create cumulative sums for each of the columns
				cols[i + 1][j] = cols[i][j] + g[i][j];
			}
		}
		for (int[] arr : g) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("-------");
		for (int[] arr : rows) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("-------");
		for (int[] arr : cols) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("-------");
		// we can start from the biggest side possible
		for (int side = Math.min(R, C); side > 1; side--) {
			for (int i = 0; i <= R - side; ++i) {
				for (int j = 0; j <= C - side; ++j) {
					if (magic(g, rows, cols, i, j, side)) {
						return side;
					}
				}
			}
		}
		return 1;
	}

	boolean magic(int[][] g, int[][] rows, int[][] cols, int r, int c, int side) {
		int sum = rows[r][c + side] - rows[r][c], d1 = 0, d2 = 0;
		for (int k = 0; k < side; ++k) {
			d1 += g[r + k][c + k];
			d2 += g[r + side - 1 - k][c + k];
			if (rows[r + k][c + side] - rows[r + k][c] != sum || cols[r + side][c + k] - cols[r][c + k] != sum) {
				return false;
			}
		}
		return d1 == sum && d2 == sum;
	}

	public static void main(String[] args) {
		Solution1895 obj = new Solution1895();
		int[][] grid = { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } };
		System.out.println(obj.largestMagicSquare(grid));
	}
}
