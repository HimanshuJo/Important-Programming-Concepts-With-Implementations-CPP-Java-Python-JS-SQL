package com.essenbazar.createSortedArray1649;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution_BinaryIndexTree {
	int[] arr;

	public int createSortedArray(int[] instructions) {
		int mod = (int) 1E9 + 7;
		TreeSet<Integer> set = new TreeSet<>();
		for (int item : instructions)
			set.add(item);

		arr = new int[set.size() + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int val : set)
			map.put(val, i++);

		long total = 0;
		// System.out.println(map.toString());
		for (i = 0; i < instructions.length; i++) {
			int instruction = instructions[i];
			int index = map.get(instruction);
			int left = prefixSum(index - 1);
			int right = i - prefixSum(index);
			update(index, 1);
			System.out.println("arr " + Arrays.toString(arr));
			System.out.println("-------");
			int cost = Math.min(left, right);
			total += (long) cost;
			total %= mod;
		}
		return (int) total;
	}

	private void update(int index, int val) {
		index++;
		while (index < arr.length) {
			arr[index] += val;
			index += lowerBit(index);
		}
	}

	private int lowerBit(int x) {
		System.out.println("lowerbit x: " + x);
		System.out.println("lowerbit -x: " + -x);
		System.out.println("lowerbit res: " + (x & -x));
		return x & -x;
	}

	private int prefixSum(int index) {
		int res = 0;
		index++;
		while (index > 0) {
			res += arr[index];
			index -= lowerBit(index);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution_BinaryIndexTree obj = new Solution_BinaryIndexTree();
		int[] instruction = { 1, 3, 3, 3, 2, 4, 2, 1, 2 };
		obj.createSortedArray(instruction);
	}
}
