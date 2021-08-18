package com.essenbazar.generateAllPermutLengthL;

import java.util.ArrayList;
import java.util.List;

class Main {

	static void permuteLengthLUtil(int n, int arr[], int len, int L, List<List<Integer>> llist) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			list.add(arr[n % len]);
			n /= len;
		}
		int count = 0;
		for (int num : arr) {
			if (list.contains(num)) {
				count++;
			}
		}
		if (count == arr.length) {
			llist.add(list);
		}
	}

	static void permuteLengthL(int arr[], int len, int L, List<List<Integer>> llist) {
		for (int i = 0; i < (int) Math.pow(len, L); i++) {
			permuteLengthLUtil(i, arr, len, L, llist);
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> llist = new ArrayList<>();
		permuteLengthL(nums, nums.length, nums.length, llist);
		return llist;
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> finalList = permute(arr);
		for (List<Integer> list : finalList) {
			System.out.println(list.toString());
		}
	}
}
