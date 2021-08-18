
package com.essenbazar.maxGeneratedArray5561;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

	public int getMaximumGenerated(int n) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(0, 0);
		nums.add(1, 1);
		int i = 1;
		int res = 0;
		while (2 * i <= n || (2 * i) + 1 <= n) {
			if ((2 * i >= 2) && (2 * i <= n)) {
				nums.add(2 * i, nums.get(i));
			}
			if ((2 * i + 1 >= 2) && (2 * i + 1 <= n)) {
				nums.add(2 * i + 1, (nums.get(i) + nums.get(i + 1)));
			}
		}
		res = Collections.max(nums);
		return res;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		System.out.println(my_obj.getMaximumGenerated(7));
	}
}
