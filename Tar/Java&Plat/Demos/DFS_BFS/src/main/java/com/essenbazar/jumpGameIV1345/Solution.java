package com.essenbazar.jumpGameIV1345;
/*
 * Given an array of integers arr, you are initially positioned at the first index of the array.

	In one step you can jump from index i to index:
	
	    i + 1 where: i + 1 < arr.length.
	    i - 1 where: i - 1 >= 0.
	    j where: arr[i] == arr[j] and i != j.
	
	Return the minimum number of steps to reach the last index of the array.
	
	Notice that you can not jump outside of the array at any time.
	
	Example 1:
	
	Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
	Output: 3
	Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
	public int minJumps(int[] arr) {
		int len = arr.length;
		HashMap<Integer, ArrayList<Integer>> valueToIndices = new HashMap<>();
		for (int i = 0; i < arr.length; ++i) {
			if (valueToIndices.containsKey(arr[i])) {
				valueToIndices.get(arr[i]).add(i);
			} else {
				valueToIndices.put(arr[i], new ArrayList<>());
				valueToIndices.get(arr[i]).add(i);
			}
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		Set<Integer> seen = new HashSet<>();
		seen.add(0);
		int ans = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; ++i) {
				int node = queue.pop();
				if (node == len - 1) {
					return ans;
				}
				LinkedList<Integer> next = new LinkedList<>();
				if (node > 0) {
					next.add(node - 1);
				}
				if (node < len - 1) {
					next.add(node + 1);
				}
				if (valueToIndices.containsKey(arr[node])) {
					List<Integer> temp = valueToIndices.get(arr[node]);
					for (int num : temp) {
						next.addLast(num);
					}
					valueToIndices.remove(arr[node]);
				}
				for (int neighbor : next) {
					if (!seen.contains(neighbor)) {
						queue.add(neighbor);
						seen.add(neighbor);
					}
				}
			}
			ans++;
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = { 7, 6, 9, 6, 9, 6, 9, 7 };
		System.out.println(obj.minJumps(arr));
	}
}
