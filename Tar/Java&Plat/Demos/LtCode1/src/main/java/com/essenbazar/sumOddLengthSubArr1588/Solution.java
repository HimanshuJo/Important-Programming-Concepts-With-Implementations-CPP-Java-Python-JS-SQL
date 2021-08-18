package com.essenbazar.sumOddLengthSubArr1588;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hjoshi
 */
class Solution {

	public int sumOddLengthSubarrays(int[] arr) {
		int sum = 0;
		int x = 0;
		for (int num : arr) {
			sum += num;
		}
		for (int i = 0; i < arr.length; ++i) {
			List<Integer> list = new ArrayList<>();
			for (int j = x; j < arr.length; ++j) {
				list.add(arr[j]);
				if (list.size() % 2 != 0 && list.size() != 1) {
					for (int num_ : list) {
						sum += num_;
					}
				}
			}
			++x;
		}
		return sum;
	}
}
