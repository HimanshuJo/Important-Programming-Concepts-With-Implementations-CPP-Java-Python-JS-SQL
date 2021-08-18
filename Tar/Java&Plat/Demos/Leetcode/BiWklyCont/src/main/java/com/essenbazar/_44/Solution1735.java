package com.essenbazar._44;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * You are given a 2D integer array, queries. For each queries[i], where queries[i] = [ni, ki], 
 * find the number of different ways you can place positive integers into an array of size ni such 
 * that the product of the integers is ki. As the number of ways may be too large, 
 * the answer to the ith query is the number of ways modulo 109 + 7.

	Return an integer array answer where answer.length == queries.length, and answer[i] is the 
	answer to the ith query.
	
	Example 1:
		
		Input: queries = [[2,6],[5,1],[73,660]]
		Output: [4,1,50734910]
		Explanation: Each query is independent.
		[2,6]: There are 4 ways to fill an array of size 2 that multiply to 6: [1,6], [2,3], [3,2], [6,1].
		[5,1]: There is 1 way to fill an array of size 5 that multiply to 1: [1,1,1,1,1].
		[73,660]: There are 1050734917 ways to fill an array of size 73 that multiply to 660. 
		1050734917 modulo 109 + 7 = 50734910.
 */
/*
 * Algo:
 * 	1. Find all the primes between 1 to 10000
 * 
 * 	2. Go through each query and find the prime factors of a number stored as a Map
 * 
 * 	3. Apply k-multicombination to count the total combination of each factor
 * 
 * 	4. Based on the recursion relation of C(n,k) = C(n-1,k) + C(n-1,k-1), each C(i, j) can be memoized
 */

public class Solution1735 {
	int MOD = (int) 1e9 + 7;

	Integer[] getPrimes(int max) {
		TreeSet<Integer> primes = new TreeSet<>();
		primes.add(2);
		for (int i = 3; i <= max; i += 2) {
			primes.add(i);
		}
		Integer min = 3;
		while (min != null && min <= max) {
			for (int i = min; i * min <= max; i += 2) {
				primes.remove(i * min);
			}
			min = primes.ceiling(min + 1);
		}
		return primes.toArray(new Integer[primes.size()]);
	}

	int choose(int n, int k, Integer[][] memo) {
		if (n == 0 || k == 0 || k == n) {
			return 1;
		}
		if (k > n / 2) {
			return choose(n, n - k, memo);
		}
		if (memo[n][k] != null) {
			return memo[n][k];
		}
		return memo[n][k] = (choose(n - 1, k, memo) + choose(n - 1, k - 1, memo)) % MOD;
	}

	public int[] waysToFillArray(int[][] queries) {
		int n = queries.length;
		int[] ans = new int[n];
		// get the primes here
		Integer[] pList = getPrimes(10000);
		System.out.println(Arrays.toString(pList));
		// creating the memo table here
		Integer[][] memo = new Integer[10024][24];
		for (int i = 0; i < queries.length; ++i) {
			int[] query = queries[i];
			if (query[1] == 1 || query[0] == 1) {
				ans[i] = 1;
			} else {
				int idx = 0, num = query[1];
				Map<Integer, Integer> factMap = new HashMap<>();
				// at this point we have to consult the prime tables for each query
				// pList[idx] <= num means we can utilize all these prime numbers to form the
				// product
				while (pList[idx] <= num) {
					// if the prime divides the number perfectly
					if ((num % pList[idx]) == 0) {
						// get this number as a key, and add one each time we see that
						factMap.merge(pList[idx], 1, (a, b) -> a + b);
						num /= pList[idx];
					} else {
						idx++;
					}
				}
                System.out.println("map: "+ factMap.toString());
				// state of map at this point ?
				long result = 1;
				// at this point in out map for each of the num in the query we have something
				// in our
				// map stored, for our final result we will use all those values
				for (int f : factMap.values()) {
					result = (result * choose(query[0] + f - 1, f, memo)) % MOD;
				}
				ans[i] = (int) result;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution1735 obj = new Solution1735();
		int[][] queries = { { 2, 6 }, { 5, 1 }, { 73, 600 } };
		System.out.println(obj.waysToFillArray(queries));
	}
}
