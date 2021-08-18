package com.essenbazar._247;

import java.util.LinkedList;
import java.util.Queue;

//Cyclically Rotating a Grid
/*
You are given an m x n integer matrix grid, where m and n are both even integers, and an integer k.

A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix.
To cyclically rotate a layer once, each element in the layer will take the place of the
adjacent element in the counter-clockwise direction.

Return the matrix after applying k cyclic rotations to it.
*/
/*
 * Intuition:
 *
 * 		We can think the outer layer as an array
 * 			Performing rotation on an array is easier
 *
 * 		Suppose our matrix is as follows:
 *
 * 			1	2	3	4
 * 			5	6	7	8
 * 			9	10	11	12
 * 			13	14	15	16
 *
 * 		We can create the array representation of the outer layer as follows:
 *
 * 			1 5 9 13 14 15 16 12 8 4 3 2
 *
 * 		Now to rotate the matrix counter-clockwise direction by k units, in the array we can just perform
 * 			right rotation by k units
 *
 * 			3 2 1 5 9 13 14 15 16 12 8 4 3
 */

public class Solution1914 {
	public int[][] rotateGrid(int[][] grid, int k) {
		int m = grid.length; // rows
		int n = grid[0].length; // cols
		int x = 0, y = 0;
		while (m > 0 && n > 0) {
			int[] array = createArray(grid, x, y, m, n);
			// If the array length is n and we are rotating the array by n units itself
			// the array remains same
			int temp = k % (2 * (m + n - 2));
			int[] rotateArray = rotate(array, temp);
			putInTheGrid(grid, x, y, m, n, rotateArray);
			m -= 2;
			n -= 2;
			x += 1;
			y += 1;
		}
		return grid;
	}

	public int[] createArray(int[][] grid, int x, int y, int m, int n) {
		// We need the length of the array that needed to be created
		// m -> denotes the no. of rows, n -> denotes no. of columns
		// So, total number of values in the array will be:
		// (m + m), two columns will be removed (as their values will be counted in the
		// rows only
		// so (n-2) + (n - 2)
		// therefore, (m+m)+(n-2)+(n-2) = 2m+2n-4 = 2(m+n-2)
		int len = 2 * (m + n - 2);
		int[] arr = new int[len];
		int count = 0, startX = x, startY = y;
		// Firstly going from 'top to bottom'
		// When x=4, it will come out of that loop
		// so in the end we will perform --x
		// and increment ++y to start from the second place while traversing
		// bottom row from left to right
		for (; x < startX + m; ++x) {
			arr[count++] = grid[x][y];
		}
		--x;
		++y;
		// Traversing from 'left to right'
		for (; y < startY + n; ++y) {
			arr[count++] = grid[x][y];
		}
		--y;
		--x;
		// Traversing from 'bottom to top'
		for (; x >= startX; --x) {
			arr[count++] = grid[x][y];
		}
		++x;
		--y;
		// Traversing from 'right to left'
		for (; y > startY; --y) {
			arr[count++] = grid[x][y];
		}
		return arr;
	}

	public int[] rotate(int[] arr, int k) {
		if (k < 0) {
			return arr;
		}
		// Suppose for the rotation k=2, so whatever value is there at the end
		// those values will be removed from the end and will be placed back at the
		// start
		Queue<Integer> elements = new LinkedList<>();
		// Taking the last k elements in the temp list
		for (int i = arr.length - k; i < arr.length; ++i) {
			elements.add(arr[i]);
		}
		// Now the i'th position where we started for our k, will be shifted to (i+k)th
		// position
		for (int i = arr.length - k - 1; i >= 0; --i) {
			arr[i + k] = arr[i];
		}
		for (int i = 0; i <= k - 1; ++i) {
			arr[i] = elements.poll();
		}
		return arr;
	}

	public void putInTheGrid(int[][] grid, int x, int y, int m, int n, int[] arr) {
		// here everything remains same as the method createArray
		// only change is now we assign array value to the grid
		int count = 0, startX = x, startY = y;
		for (; x < startX + m; ++x) {
			grid[x][y] = arr[count++];
		}
		--x;
		++y;
		for (; y < startY + n; ++y) {
			grid[x][y] = arr[count++];
		}
		--y;
		--x;
		for (; x >= startX; --x) {
			grid[x][y] = arr[count++];
		}
		++x;
		--y;
		for (; y > startY; --y) {
			grid[x][y] = arr[count++];
		}
	}

}
