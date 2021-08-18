package com.essenbazar.containerWithmaxWater11;

/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Notice that you may not slant the container.
 */
class Solution {

	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int water = 0;
		while (i < j) {
			water = Math.max(water, (j - i) * (Math.min(height[i], height[j])));
			if (height[i] < height[j]) {
				i += 1;
			} else {
				j -= 1;
			}
		}
		return water;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] height = { 1, 1 };
		System.out.println(my_obj.maxArea(height));
	}
}
