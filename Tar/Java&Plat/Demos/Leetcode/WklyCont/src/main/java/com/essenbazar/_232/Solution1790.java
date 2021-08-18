package com.essenbazar._232;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himanshu
 */

/*

You are given two strings s1 and s2 of equal length.
A string swap is an operation where you choose two indices in a string (not necessarily different)
and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on
exactly one of the strings. Otherwise, return false.

Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".


 */
import java.util.HashMap;
import java.util.Map;

public class Solution1790 {

	public boolean areAlmostEqual(String s1, String s2) {

		if (s1.equals(s2)) {
			return true;
		}

		Map<Object, Object> map = new HashMap<>();
		Map<Object, Object> map_ = new HashMap<>();

		Map<Object, Integer> map__ = new HashMap<>();
		Map<Object, Integer> map___ = new HashMap<>();

		for (int i = 0; i < s1.length(); ++i) {
			map__.put(s1.charAt(i), map__.getOrDefault(s1.charAt(i), 0) + 1);
			map___.put(s2.charAt(i), map___.getOrDefault(s2.charAt(i), 0) + 1);
		}

		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map__.entrySet()) {
			if (!map___.containsKey(entry.getKey())) {
				return false;
			} else if (map___.containsKey(entry.getKey())) {
				if (!entry.getValue().equals(map___.get(entry.getKey()))) {
					return false;
				}
			}
		}

		for (int i = 0; i < s1.length(); ++i) {
			map.put(i, s1.charAt(i));
			map_.put(i, s2.charAt(i));
		}

		// System.out.println(map.toString());
		// System.out.println(map_.toString());
		int count = 0;

		for (int i = 0; i < map.size(); i++) {
			if (map_.containsKey(i)) {
				// System.out.println(map.get(i));
				// System.out.println(map_.get(i));
				// System.out.println("-------");
				if (!map.get(i).equals(map_.get(i))) {
					count++;
				}
			}
		}

		return count == 2;
	}

	public static void main(String[] args) {
		Solution1790 my_obj = new Solution1790();
		String s1 = "siyolsdcjthwsiplccjbuceoxmpjgrauocx";
		String s2 = "siyolsdcjthwsiplccpbuceoxmjjgrauocx";

		System.out.println(my_obj.areAlmostEqual(s1, s2));
	}

}
