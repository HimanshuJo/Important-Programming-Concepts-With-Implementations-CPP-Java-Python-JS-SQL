package com.essenbazar._48;

import java.util.*;

class Solution {

	private String extractInt(String str) {
		str = str.replaceAll("[^\\d]", " ");
		str = str.trim();
		str = str.replaceAll(" +", " ");

		if (str.equals(""))
			return "-1";

		return str;
	}

	public int secondHighest(String s) {
		boolean containsDig = false;
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				containsDig = true;
				break;
			}
		}
		if (containsDig) {
			String sbf = extractInt(s);
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < sbf.length(); ++i) {
				set.add(Character.getNumericValue(sbf.charAt(i)));
			}
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			if (list.size() == 2)
				return list.get(0);
			else if (list.size() == 1)
				return -1;
			return list.get(list.size() - 2);
		} else
			return -1;
	}
}