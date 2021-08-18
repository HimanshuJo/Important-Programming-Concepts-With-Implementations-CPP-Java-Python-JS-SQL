package com.essenbazar._45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1748 {

	public int sumOfUnique(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> keys = new ArrayList<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		map.entrySet().stream().filter(entry -> (entry.getValue().equals(1))).forEachOrdered(entry -> {
			keys.add(entry.getKey());
		});
		int sum = 0;
		for (int i = 0; i < keys.size(); i++) {
			sum += keys.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution1748 my_obj = new Solution1748();
		int[] nums = { 1, 2, 3, 2 };
		System.out.println(my_obj.sumOfUnique(nums));
	}
}
