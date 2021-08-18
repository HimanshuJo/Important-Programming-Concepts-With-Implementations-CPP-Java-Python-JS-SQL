package com.essenbazar._50;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * You are given an array points where points[i] = [xi, yi] is the coordinates
 * of the ith point on a 2D plane. Multiple points can have the same
 * coordinates.
 * 
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes
 * a circle centered at (xj, yj) with a radius of rj.
 * 
 * For each query queries[j], compute the number of points inside the jth
 * circle. Points on the border of the circle are considered inside.
 * 
 * Return an array answer, where answer[j] is the answer to the jth query.
 * 
 */

class Solution1828 {

	public int[] countPoints(int[][] points, int[][] queries) {
		List<Integer> res = new ArrayList<>();
		int res_ = 0;
		for (int[] arr : queries) {
			for (int[] arr_ : points) {
				int xc = arr[0];
				int yc = arr[1];
				int r = arr[2];
				int xp = arr_[0];
				int yp = arr_[1];
				double d = Math.sqrt(((xp - xc) * (xp - xc)) + ((yp - yc) * (yp - yc)));
				if (d <= r) {
					res_++;
				}
			}
			res.add(res_);
			res_ = 0;
		}
		int[] result = res.stream().mapToInt(i -> i).toArray();
		return result;
	}
}
