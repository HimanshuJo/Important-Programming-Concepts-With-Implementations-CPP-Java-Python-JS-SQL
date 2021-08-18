package com.essenbazar._47;

/*
 * 
 * You are given two integers, x and y, which represent your current location on
 * a Cartesian grid: (x, y).
 * 
 * You are also given an array points where each points[i] = [ai, bi] represents
 * that a point exists at (ai, bi). A point is valid if it shares the same
 * x-coordinate or the same y-coordinate as your location.
 * 
 * Return the index (0-indexed) of the valid point with the smallest Manhattan
 * distance from your current location. If there are multiple, return the valid
 * point with the smallest index. If there are no valid points, return -1.
 * 
 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 -
 * x2) + abs(y1 - y2).
 * 
 * Example:
 * 
 * Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]] Output: 2
 * Explanation: Of all the points, only [3,1], [2,4] and [4,4] are valid. Of the
 * valid points, [2,4] and [4,4] have the smallest Manhattan distance from your
 * current location, with a distance of 1. [2,4] has the smallest index, so
 * return 2.
 * 
 */

/*
 * 
 * Algo:
 * 
 * Because we want to a point that shares the same x-coordinate or the same
 * y-coordinate as our location so, dx * dy == 0 indicate either dx equals zero
 * or dy equals zero
 * 
 * so we can make the product of dx and dy to be zero
 * 
 * dx and dy means that the difference of x-coordinate and y-coordinate
 * respectively
 * 
 * If the difference is zero then they must be sharing the same x or y
 * coordinate
 * 
 */

public class Solution1779 {

	public int nearestValidPoint(int x, int y, int[][] points) {
		int index = -1;
		for (int i = 0, smallest = Integer.MIN_VALUE; i < points.length; ++i) {
			int dx = x - points[i][0], dy = y - points[i][1];
			if (dx * dy == 0 && Math.abs(dy) + Math.abs(dx) < smallest) {
				smallest = Math.abs(dx) + Math.abs(dy);
				index = i;
			}
		}
		return index;
	}
}
