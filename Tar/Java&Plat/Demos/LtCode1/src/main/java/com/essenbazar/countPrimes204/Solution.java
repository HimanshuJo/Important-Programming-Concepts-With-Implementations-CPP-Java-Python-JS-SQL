/*
Project for solving some common algorithm problems
 */
package com.essenbazar.countPrimes204;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example 1:
 * 
 * Input: n = 10 Output: 4 Explanation: There are 4 prime numbers less than 10,
 * they are 2, 3, 5, 7.
 * 
 */

/*
 * 
 * Algo:
 * 
 * 1. Let's create a 1D boolean array prime[] of size N
 * 
 * 2. Initially we presume that all the numbers are prime numbers. so the array
 * will be filled with true values
 * 
 * 3. Starting from 2, we will check if prime[i] == true, if so we have to
 * update every multiple of i to false
 * 
 * 4. In the end, we can check prime[] from index 2 and print the count of the
 * cells containing tha value true
 * 
 * 5. Note: 1 is not a prime number, therefore we will start from 2
 * 
 * Time:
 * 
 * O(N * log (log N))
 * 
 */
public class Solution {

	public int countPrime(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		for (int i = 2; i * i < n; ++i) {
			if (prime[i]) {
				for (int j = i * i; j < n; j += i) {
					prime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; ++i) {
			if (prime[i]) {
				count++;
			}
		}
		return count;
	}
}
