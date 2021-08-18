package com.essenbazar._249;

//Concatenation of Array
/*
* Given an integer array nums of length n, you want to create an array ans of length 2n
* where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

	Specifically, ans is the concatenation of two nums arrays.

	Return the array ans.

	Example 1:

	Input: nums = [1,2,1]
	Output: [1,2,1,1,2,1]
	Explanation: The array ans is formed as follows:
	- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
	- ans = [1,2,1,1,2,1]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1929_2 {
	public int countPalindromicSubsequence(String s) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int n = s.length();
		for (int i = 0; i < 26; ++i) {
			list.add(new ArrayList<>(Arrays.asList(-1, -1)));
		}
		for (int i = 0; i < n; ++i) {
			if (list.get(s.charAt(i) - 'a').get(0) == -1) {
				int index = s.charAt(i) - 'a';
				list.get(index).set(0, i);
			} else {
				int index = s.charAt(i) - 'a';
				list.get(index).set(1, i);
			}
		}
		int ans = 0;
		for (int i = 0; i < 26; ++i) {
			if (list.get(i).get(0) != -1) {
				Set<Character> set = new HashSet<>();
				for (int x = list.get(i).get(0) + 1; x < list.get(i).get(1); ++x) {
					set.add(s.charAt(x));
				}
				System.out.println(ans);
				ans += set.size();
			}
		}
		// System.out.println(list.get(1).toString());
		// System.out.println("-------");
		for (ArrayList<Integer> temp : list) {
			System.out.println(temp.toString());
		}
		System.out.println("-------");
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		Solution1929_2 obj = new Solution1929_2();
		obj.countPalindromicSubsequence("bbcbaba");
	}
}
