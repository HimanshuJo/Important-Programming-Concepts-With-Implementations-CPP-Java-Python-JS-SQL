
package com.essenbazar.setMismatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*

You have a set of integers s, which originally contains all the numbers from 1 to n.

Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 
Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]


 */
class Solution {

	public int[] findErrorNums(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		List<Integer> res = new ArrayList<>();

		for (int num : nums) {
			list.add(num);
		}

		int max = list.size();
		int missingNum = 0;
		int repeatedNum = 0;

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (int i = 1; i <= max; i++) {
			if (!map.containsKey(i)) {
				missingNum = i;
			}
		}

		for (Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, Integer> entry = iterator.next();
			if (entry.getValue().equals(2)) {
				repeatedNum = (int) entry.getKey();
			}
		}

		res.add(repeatedNum);
		res.add(missingNum);

		int[] arr = res.stream().mapToInt(i -> i).toArray();

		return arr;
	}
}
