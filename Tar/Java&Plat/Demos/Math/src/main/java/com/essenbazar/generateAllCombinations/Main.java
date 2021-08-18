
package com.essenbazar.generateAllCombinations;

/*
 * Order does not matter: (1, 2) is same as (2, 1)
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<List<Integer>> llist = new ArrayList<>();

	static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
		if (index == r) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < r; j++) {
				list.add(data[j]);
				System.out.print(data[j] + " ");
			}
			if (list.size() > 0)
				llist.add(list);
			System.out.println("");
			return;
		}
		if (i >= n) {
			return;
		}
		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);
		combinationUtil(arr, n, r, index, data, i + 1);
	}

	static void printCombination(int arr[], int n, int r) {
		int data[] = new int[r];
		combinationUtil(arr, n, r, 0, data, 0);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			printCombination(arr, n, i);
			System.out.println("-------*******-------");
		}
		System.out.println(llist.toString());
	}
}
