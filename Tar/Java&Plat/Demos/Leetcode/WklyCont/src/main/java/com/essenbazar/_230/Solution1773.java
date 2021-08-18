package com.essenbazar._230;

/*

You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color,
and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

    ruleKey == "type" and ruleValue == typei.
    ruleKey == "color" and ruleValue == colori.
    ruleKey == "name" and ruleValue == namei.

Return the number of items that match the given rule.

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],
ruleKey = "color", ruleValue = "silver"

Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].


 */
import java.util.List;

class Solution1773 {

	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int res = 0;
		for (List<String> temp_list : items) {
			for (int j = 0; j < temp_list.size(); j++) {
				if (ruleKey.equals("type")) {
					if (temp_list.get(j).equals(ruleValue) && j == 0) {
						res++;
						// System.out.println(temp_list.get(j));
					}
				} else if (ruleKey.equals("color")) {
					if (temp_list.get(j).equals(ruleValue) && j == 1) {
						res++;
					}
				} else if (ruleKey.equals("name")) {
					if (temp_list.get(j).equals(ruleValue) && j == 2) {
						res++;
					}
				}
			}
		}

		return res;

	}
}