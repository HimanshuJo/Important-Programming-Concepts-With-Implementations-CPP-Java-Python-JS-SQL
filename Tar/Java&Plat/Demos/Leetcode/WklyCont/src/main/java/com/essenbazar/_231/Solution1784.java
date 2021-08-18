package com.essenbazar._231;

/*
 * Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one
 * contiguous segment of ones. Otherwise, return false.
 * Example 1:

	Input: s = "1001"
	Output: false
	Explanation: The ones do not form a contiguous segment.

 */
import java.util.ArrayList;
import java.util.List;

public class Solution1784 {
	public boolean checkOnesSegment(String s) {
		boolean flag = false;
		if (s.length() == 1 || s.length() == 2)
			return true;
		for (int i = 0; i < s.length() - 1; ++i) {
			if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
				flag = true;
				break;
			}
		}
		int count1 = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') {
				count1++;
				list.add(i);
			}
		}
		if (count1 == 1)
			return true;
		else {
			for (int i = 0; i < list.size() - 1; ++i) {
				if (Math.abs(list.get(i) - list.get(i + 1)) != 1) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}