
package com.essenbazar.longestCommonPrefix14;

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public String longestCommonPrefix(String[] strs) {
		int len_strs = strs.length;
		int min_length = 0;
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < len_strs; i++) {
			al.add(strs[i].length());
		}
		min_length = Collections.min(al);
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0; j < min_length; j++) {
			for (int k = 0; k < al.size(); k++) {
				map.put(strs[k].charAt(j), map.getOrDefault(strs[k].charAt(j), 0) + 1);
			}
		}
		System.out.println(map);
		sb.append(getAllKeysForValue(map, al.size()));
		String str = sb.toString().substring(1, sb.toString().length() - 1);
		String clean = str.replaceAll("[, ;]", "");
		return clean;
	}

	static <K, V> List<K> getAllKeysForValue(Map<K, V> mapOfWords, V value) {
		List<K> listOfKeys = null;
		if (mapOfWords.containsValue(value)) {
			listOfKeys = new ArrayList<>();
			for (Map.Entry<K, V> entry : mapOfWords.entrySet()) {
				if (entry.getValue().equals(value)) {
					listOfKeys.add(entry.getKey());
				}
			}
		}
		return listOfKeys;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String[] my_array = { "dog", "racecar", "car" };
		System.out.println(my_obj.longestCommonPrefix(my_array));
	}
}
