package com.essenbazar.smallestIntegerBivByK1015;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a positive integer k, you need to find the length of the smallest 
 * positive integer n such that n is divisible by k, and n only contains the digit 1.

	Return the length of n. If there is no such n, return -1.

	Note: n may not fit in a 64-bit signed integer.

	Example 1:
	
	Input: k = 1
	Output: 1
	Explanation: The smallest answer is n = 1, which has length 1.
	
	Example 2:
	
	Input: k = 2
	Output: -1
	Explanation: There is no such positive integer n divisible by 2.
	
	Example 3:
	
	Input: k = 3
	Output: 3
	Explanation: The smallest answer is n = 111, which has length 3.

 */
/*
 * Intuition:
 * 	Let's suppose the final result has N digits of 1
 * 	If N exist, N <= K, we can just do a brute force check
 * 
 * 	Also, if K % 2 == 0, return -1 because 111...11 can't be even
 * 
 * 	Also, if K % 5 == 0, return -1 because 111...11 can't end with 0 or 5
 * 
 * Explanation:
 * 		For different N, we can calculate the remainder of mod K
 * 
 * 		It has to use the remainder for these two reasons:
 * 			1. Integer overflow
 * 			2. The division operation for big Integers, is Not O(1), 
 * 				it actually depends on the number of digits
 * 
 * Prove:
 * 
 * 	Why 5 is a corner case:
 * 		Assume that N = 1 to N = k, if there isn't any 111..11 % K == 0
 * 		There are at most K - 1 different remainders 1, 2, .... K - 1
 * 
 * 		So this is a pigeon hole problem:
 * 			There must be at least 2 same remainders
 * 
 * 		Assume that,
 * 			f(N) = f(M), N > M
 * 			f(N - M) * 10 ^ M = 0
 * 			10^M == 0, mod K
 * 
 * 			so that K has factor 2 or factor 5
 * 
 * 		Proof by contradiction,
 * 			If (k%2 == 0 || k%5 == 0) return -1
 * 
 * 		Otherwise, there must be solution N <= K
 * 
 * Time:
 * 	O(K)
 * 	
 */
/*
 * For a given K, we can evaluate 1%K, 11%K, 111%K, .... 111..1 (K 1's) % K
 * 
 * 		If any of the remainder is 0, then the current number is the smallest integer divisible by K
 * 
 * 		If none of the remainders is 0, then at some point, there must be some duplicate remainders
 * 		(due to Pigeon-hole principle), as the K remainders can only take at most k-1 different values
 * 		excluding 0
 * 		In this case, no number with the pattern 1...1 is divisible by k.
 * 
 * 			This is because once a remainder has a duplicate, the next remainder will be in a loop
 * 				as the previous remainder determines the nextMod
 * 				i.e. nextMod = (10 * prevMod + 1) % K
 * 		A simple example is when K is 6.
 * 			Once we see 1111 % 6 = 1, we immediately know 11111 % 6 = will be 5,
 * 				since 1 % 6 = 1
 * 				and   11 % 6 = 5
 * 		Therefore there will be no such number that is divisible by 6
 * 
 * 		1 % 6 = 1
 * 		11 % 6 = 5
 * 		111 % 6 = 3
 * 		1111 % 6 = 1
 * 		11111 % 6 = 5
 * 		111111 % 6 = 3
 * 
 * 	Also for any number with 0, 2, 4, 6, 8 as the last digit, its multiple must be an even number
 * 	Therefore, a number with the pattern 1...1 will never be its multiple.
 * 
 * 	Similarly, for any number with 5 as the last digit, its multiple must have 0 or 5 as the last digit
 * 
 */

class Solution {
	public int smallestRepunitDivByK(int k) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		set.add(7);
		set.add(9);
		if (!set.contains(k % 10)) {
			return -1;
		}
		int mod = 0;
		Set<Integer> modSet = new HashSet<>();
		for (int i = 1; i < k + 1; ++i) {
			mod = (10 * mod + 1) % k;
			if (mod == 0) {
				return i;
			}
			if (modSet.contains(mod)) {
				return -1;
			}
			modSet.add(mod);
		}
		return -1;
	}
}
