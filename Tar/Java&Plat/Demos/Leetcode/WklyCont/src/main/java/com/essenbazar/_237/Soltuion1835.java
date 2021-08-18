package com.essenbazar._237;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himanshu
 */

/*
 *
 * The XOR sum of a list is the bitwise XOR of all its elements. If the list
 * only contains one element, then its XOR sum will be equal to this element.
 *
 * For example, the XOR sum of [1,2,3,4] is equal to 1 XOR 2 XOR 3 XOR 4 = 4,
 * and the XOR sum of [3] is equal to 3.
 *
 * You are given two 0-indexed arrays arr1 and arr2 that consist only of
 * non-negative integers.
 *
 * Consider the list containing the result of arr1[i] AND arr2[j] (bitwise AND)
 * for every (i, j) pair where 0 <= i < arr1.length and 0 <= j < arr2.length.
 *
 * Return the XOR sum of the aforementioned list.
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3], arr2 = [6,5] Output: 0 Explanation: The list = [1 AND
 * 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1]. The XOR sum
 * = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0.
 *
 */

/*
 *
 * We all know the distributive property that (a1+a2) * (b1+b2) = a1*b1 + a1*b2
 * + a2*b1 + a2*b1
 *
 * Now we focus on each bit for example the last bit of A[i] and B[j]
 *
 * -------
 *
 * Distributive property is similar for AND and XOR here
 *
 * (a1^a2) & (b1^b2) = (a1&b1) ^ (a1&b2) ^ (a2&b1) ^ (a2&b2)
 *
 */

class Solution1835 {
	public int getXORSum(int[] arr1, int[] arr2) {
		int xorA = 0;
		int xorB = 0;

		for (int num : arr1)
			xorA ^= num;

		for (int num : arr2)
			xorB ^= num;

		return xorA & xorB;
	}
}
