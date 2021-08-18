
package com.essenbazar.canPlaceFlowers605;

/*
 * You have a long flowerbed in which some of the plots are planted, and some are not. 
 * However, flowers cannot be planted in adjacent plots.

	Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 
	means not empty, and an integer n, return if n new flowers can be planted in the 
	flowerbed without violating the no-adjacent-flowers rule.
	
	Example 1:

	Input: flowerbed = [1,0,0,0,1], n = 1
	Output: true
	
	Example 2:
	
	Input: flowerbed = [1,0,0,0,1], n = 2
	Output: false

 */

class Solution {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed == null || flowerbed.length == 0) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			// the current plot is empty && the previous plot is empty && the next plot is
			// empty
			// exception: the first plot is empty || the last is empty
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
					&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			if (count >= n) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		my_obj.canPlaceFlowers(flowerbed, 1);
	}
}
