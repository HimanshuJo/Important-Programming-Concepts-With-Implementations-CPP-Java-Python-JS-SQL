package com.essenbazar._44;

// Decode XORed Permutation

import java.util.Vector;

/*
There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.

It was encoded into another integer array encoded of length n - 1, 
such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].

Given the encoded array, return the original array perm. 
It is guaranteed that the answer exists and is unique.

Example 1:

Input: encoded = [3,1]
Output: [1,2,3]
Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]

Example 2:

Input: encoded = [6,5,4,6]
Output: [2,4,1,5,3]

 */

/*

	XOR properties and tips:

		1. For  c = a xor b, we can write:

				b = c xor a or
	
				a = c xor b

		2. XOR is commutative, a xor b = b xor a

		3. XOR to the same number is always 0

			a xor a = 0

	Intuition:

		If the first element is determined, the whole array can be decoded

			encoded[i] = perm[i] xor per[i + 1] implies:

				perm[i + 1] = perm[i] xor encoded[i] or,

				perm[i] = perm[i + 1] xor encoded[i]

			hence we can loop through to find the next perm element

		But we still have to find the first element

	-------

	Finding the first element:

		** Important instruction in the question to notice is that,

				we have to find an integer array 'perm' that is the permutation of the first n positive integers
					where n is always odd

				perm is an array with values ranging from [1, 2, 3.... n] and the order in the array is permuted

		We can xor all the numbers in the array perm.

			And perms is an array with first n positive integers

			perm[0] xor perm[1] xor perm[2] ... perm[n] = 1 xor 2 xor 3 xor 4 .... xor perm[n]

				order doesn't matter since, xor is commutative

*/

class Solution2 {
	public int[] decode(int[] encoded) {
		int first = 0;
		int n = encoded.length + 1;
		for (int i = 1; i <= n; ++i) {
			first ^= i;
		}
		for (int i = 1; i < n - 1; i += 2) {
			first ^= encoded[i];
		}
		int[] perm = new int[n];
		perm[0] = first;
		for (int i = 0; i < n - 1; ++i) {
			perm[i + 1] = perm[i] ^ encoded[i];
		}
		return perm;
	}
}

class Solution1734 {
	public int[] decode(int[] encoded) {
		Vector<Integer> arr = new Vector<Integer>();
		int n = encoded.length + 1;
		int xorAll = xorAllElements(n);
		int xorAdj = 0;
		for (int i = 0; i < n - 1; i += 2) {
			xorAdj = xorAdj ^ encoded[i];
		}
		int lastEle = xorAll ^ xorAdj;
		arr.add(lastEle);
		for (int i = n - 2; i >= 0; --i) {
			lastEle = encoded[i] ^ lastEle;
			arr.add(lastEle);
		}
		int[] res = new int[encoded.length + 1];
		for (int i = 0; i < arr.size(); ++i) {
			res[i] = arr.get(i);
		}
		return res;
	}

	public static int xorAllElements(int n) {
		switch (n & 3) {
		case 0:
			return n;
		case 1:
			return 1;
		case 2:
			return n + 1;
		}
		return 0;
	}
}