package com.essenbazar._44;

// Find the Highest Altitude

/*
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. 
 * The biker starts his trip on point 0 with altitude equal 0.

	You are given an integer array gain of length n where gain[i] is the net gain in altitude between 
	points i and i + 1 for all (0 <= i < n). 
	Return the highest altitude of a point.
 */

import java.util.Arrays;

class Solution1732 {
	public int largestAltitude(int[] gain) {
		int[] arr_ = new int[gain.length + 1];
		arr_[0] = 0;
		for (int i = 0; i < gain.length; ++i) {
			arr_[i + 1] = arr_[i] + gain[i];
		}
		Arrays.sort(arr_);
		System.out.println(Arrays.toString(arr_));
		return (arr_[arr_.length - 1]);
	}

	public static void main(String[] args) {
		Solution1732 obj = new Solution1732();
		int[] gain = { 1, 2, 3, 4, 5 };
		obj.largestAltitude(gain);
	}
}