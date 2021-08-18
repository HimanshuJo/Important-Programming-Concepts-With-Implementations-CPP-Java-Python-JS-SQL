package com.essenbazar._240;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

You are given a 2D integer array logs where each logs[i] = [birthi, deathi]
indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year.
The ith person is counted in year x's population if x is in the inclusive range
[birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

 */

public class Solution1854 {

	public int maximumPopulation(int[][] logs) {
		List<Integer> list = new ArrayList<>();
		for (int[] arr : logs) {
			int temp1 = arr[0];
			int temp2 = arr[1];
			for (int i = temp1; i < temp2 - 1; ++i) {
				list.add(i);
			}
		}
		Collections.sort(list);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (Integer element : list) {
			map.put(element, map.getOrDefault(element, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map.entrySet()) {
			if ((int) entry.getValue() > max) {
				max = (int) entry.getValue();
			}
		}
		int finalYear = 0;
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map.entrySet()) {
			if ((int) entry.getValue() == max) {
				finalYear = (int) entry.getKey();
				break;
			}
		}
		return finalYear;
	}
}
