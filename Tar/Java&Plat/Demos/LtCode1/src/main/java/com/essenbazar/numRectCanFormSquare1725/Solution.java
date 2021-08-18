package com.essenbazar.numRectCanFormSquare1725;

/**
 *
 * @author himan
 */

/*

Number Of Rectangles That Can Form The Largest Square

You are given an array rectangles where rectangles[i] = [li, wi] 
represents the ith rectangle of length li and width wi.

You can cut the ith rectangle to form a square with a side length of k 
if both k <= li and k <= wi. 

For example, if you have a rectangle [4,6], you can cut it to get a square 
with a side length of at most 4.

Let maxLen be the side length of the largest square you can obtain 
from any of the given rectangles.

Return the number of rectangles that can make a square with a side length of maxLen.


Input: rectangles = [[5,8],[3,9],[5,12],[16,5]]
Output: 3
Explanation: The largest squares you can get from each rectangle are of lengths [5,3,5,5].
The largest possible square is of length 5, and you can get it out of 3 rectangles.
 */
import java.util.*;

class Solution {

	public int countGoodRectangles(int[][] rectangles) {
		List<Integer> list = new ArrayList<>();
		if (!list.isEmpty()) {
		}
		for (int[] nums : rectangles) {
			int k = Math.min(nums[0], nums[1]);
			list.add(k);
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int j = 0; j < list.size(); j++) {
			map.put(list.get(j), map.getOrDefault(list.get(j), 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		int res = 0;
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map.entrySet()) {
			if ((int) entry.getKey() > max) {
				max = (int) entry.getKey();
				res = (int) entry.getValue();
			}
		}
		return res;
	}
}
