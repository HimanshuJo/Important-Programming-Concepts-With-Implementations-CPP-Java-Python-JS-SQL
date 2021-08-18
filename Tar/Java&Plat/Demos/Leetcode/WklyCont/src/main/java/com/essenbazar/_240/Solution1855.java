package com.essenbazar._240;

/*

You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.

A pair of indices (i, j), where 0 <= i < nums1.length and
0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j].

The distance of the pair is j - i​​​​.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.

Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).

 */

/*

Intution:

   Since our arrays are sorted, we can use advance i while
       n1[i] is bigger and
       n2[i] is smaller

       and increment j otherwise

*/

public class Solution1855 {
	public int maxDistance(int[] nums1, int[] nums2) {
		int i = 0, j = 0, res = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) {
				++i;
			} else {
				// res = Math.max(res, j++ - i);
				res = Math.max(res, j - i);
				++j;
			}
		}
		return res;
	}
}

/*
 *
 * Solution using Binaray Search
 *
 */
class Solution2 {

	public int maxDistance(int[] nums1, int[] nums2) {
		int max = 0;
		for (int i = 0; i < nums1.length; ++i) {
			int r = nums2.length - 1;
			int l = i;
			int m = i;
			while (l <= r) {
				m = l + (r - l) / 2;
				// now in the second array I search at the mid
				// if current number at first array turned out to be greater
				// decrease the right range
				if (nums1[i] > nums2[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			if (r < 0) {
				continue;
			}
			max = Math.max(max, r - i);
		}
		return max;
	}
}
