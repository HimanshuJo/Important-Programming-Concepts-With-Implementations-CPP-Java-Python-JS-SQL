package com.essenbazar.openTheLock752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
	public int openLock(String[] deadends, String target) {
		Set<String> deadSet = new HashSet<>();
		for (String str : deadends) {
			deadSet.add(str);
		}
		if (deadSet.contains("0000")) {
			return -1;
		}
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("0000");
		int ans = 0;
		Set<String> seen = new HashSet<>();
		seen.add("0000");
		while (!queue.isEmpty()) {
			int lenQueue = queue.size();
			for (int i = 0; i < lenQueue; ++i) {
				String curr = queue.pop();
				if (curr.equals(target)) {
					return ans;
				}
				for (int ii = 0; ii < 4; ++ii) {
					int newDigit1 = (Character.getNumericValue(curr.charAt(ii)) + 1) % 10;
					String newCode1 = curr.substring(0, ii) + String.valueOf(newDigit1)
							+ curr.substring(ii + 1, curr.length());
					if (!seen.contains(newCode1) && !deadSet.contains(newCode1)) {
						queue.offer(newCode1);
						seen.add(newCode1);
					}
					int newDigit2 = (Character.getNumericValue(curr.charAt(ii)) + 10 - 1) % 10;
					String newCode2 = curr.substring(0, ii) + String.valueOf(newDigit2)
							+ curr.substring(ii + 1, curr.length());
					if (!seen.contains(newCode2) && !deadSet.contains(newCode2)) {
						queue.offer(newCode2);
						seen.add(newCode2);
					}
				}
			}
			ans += 1;
		}
		return -1;
	}
}

// -------*******-------

class SolutionWithoutDeadSet {
	public int openLock(String[] deadends, String target) {
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("0000");
		int ans = 0;
		Set<String> seen = new HashSet<>();
		for (String str : deadends) {
			seen.add(str);
		}
		if (seen.contains("0000")) {
			return -1;
		}
		seen.add("0000");
		while (!queue.isEmpty()) {
			int lenQueue = queue.size();
			for (int i = 0; i < lenQueue; ++i) {
				String curr = queue.pop();
				if (curr.equals(target)) {
					return ans;
				}
				for (int ii = 0; ii < 4; ++ii) {
					int newDigit1 = (Character.getNumericValue(curr.charAt(ii)) + 1) % 10;
					String newCode1 = curr.substring(0, ii) + String.valueOf(newDigit1)
							+ curr.substring(ii + 1, curr.length());
					if (!seen.contains(newCode1)) {
						queue.offer(newCode1);
						seen.add(newCode1);
					}
					int newDigit2 = (Character.getNumericValue(curr.charAt(ii)) + 10 - 1) % 10;
					String newCode2 = curr.substring(0, ii) + String.valueOf(newDigit2)
							+ curr.substring(ii + 1, curr.length());
					if (!seen.contains(newCode2)) {
						queue.offer(newCode2);
						seen.add(newCode2);
					}
				}
			}
			ans += 1;
		}
		return -1;
	}
}