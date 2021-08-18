
package com.essenbazar.furthestBuilding1642;

import java.util.PriorityQueue;

/*

You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

While moving from building i to building i+1 (0-indexed),

If the current building's height is greater than or equal to the next building's height,
    you do not need a ladder or bricks.

If the current building's height is less than the next building's height, you can either use
    one ladder or (h[i+1] - h[i]) bricks.

Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.

*/

class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < heights.length - 1; i++) {
			int diff = heights[i + 1] - heights[i];
			if (diff > 0)
				pq.add(diff);
			if (pq.size() > ladders)
				bricks -= pq.poll();
			if (bricks < 0)
				return i;
		}
		return heights.length - 1;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
		my_obj.furthestBuilding(heights, 0, 0);
	}
}
