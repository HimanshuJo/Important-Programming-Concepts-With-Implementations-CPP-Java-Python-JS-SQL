
package com.essenbazar.setMismatch;

import java.util.HashMap;
import java.util.Map;

public class Solution_2 {

	public int[] findErrorNums(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int dup = -1, missing = 1;
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int i = 1; i <= nums.length; i++) {
			if (map.containsKey(i)) {
				if (map.get(i) == 2) {
					dup = i;
				}
			} else {
				missing = i;
			}
		}
		return new int[] { dup, missing };
	}
}

/*
 * 
 * Complexity Analysis
 * 
 * Time complexity : O(n). Traversing over nums of size n takes O(n) time.
 * Considering each number from 1 to n also takes O(n) time.
 * 
 * Space complexity : O(n). map can contain atmost n entries for each of the
 * numbers from 1 to n.
 * 
 */