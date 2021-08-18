
package com.essenbazar.beautifulArrangement526;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * 
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as
 * an array that is constructed by these n numbers successfully if one of the
 * following is true for the ith position (1 <= i <= n) in this array:
 * 
 * The number at the ith position is divisible by i. i is divisible by the
 * number at the ith position. Given an integer n, return the number of the
 * beautiful arrangements that you can construct.
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2
 * 
 * Explanation: The first beautiful arrangement is [1, 2]: Number at the 1st
 * position (i=1) is 1, and 1 is divisible by i (i=1). Number at the 2nd
 * position (i=2) is 2, and 2 is divisible by i (i=2). The second beautiful
 * arrangement is [2, 1]: Number at the 1st position (i=1) is 2, and 2 is
 * divisible by i (i=1). Number at the 2nd position (i=2) is 1, and i (i=2) is
 * divisible by 1. Example 2:
 * 
 * Input: n = 1 Output: 1
 * 
 */

/*
 * Approach1: Brute Force (Will TLE): Here we can find out all the arrays that
 * can be formed using the numbers from 1 to n (by creating every possible
 * permutation of the given elements.
 * 
 * Then we can iterate over all the elements of every permutation generated and
 * check for the required conditions of divisibility.
 * 
 * In order to generate all the possible pairings, we make use of a function
 * 'permute(nums, currentIndex)' This function creates all the possible
 * permutations of the elements of the given array
 * 
 * To do so, 'permute' takes the index of the current element 'currentIndex' as
 * one of the arguments. Then it swaps the current element with every other
 * element in the array, lying towards its right, so as to generate a new
 * ordering of the array elements.
 * 
 * 					 A 		 B	    C
 * 	    		   	/   	 |    	 \
 * 	   			  ABC  	    BAC      CBA
 * 	   			  / \       /  \     /  \
 * 				ABC  ACB  BAC  BCA  CBA CAB
 *      
 * After swapping has been done, it makes another call to permute but this time
 * with the index of the next element in the array. While returning back, we
 * reverse the swapping done in the current function call
 * 
 * Thus we reach the end of the array,a new ordering of the array's elements is
 * generated
 */

/* In Brute Force:
 * 		
 * 		Complexity: O(n!) A total of n! permutations will be generated for an array
 * 					of length n
 * 
 * 		Space: O(n) The depth of the recursion tree can go upto n
 */

/*
 * BFS:
 * 
 * 	Starting from the base permutation, go all the possible valid permutations with 1 swap
 * 		Number of permutations we'll finally end up exploring
 */

class Solution {
	private boolean isGood(int a, int b) {
		return a % b == 0 || b % a == 0;
	}

	public int countArrangement(int n) {
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			A.add(i + 1);
		}
		Set<List<Integer>> seen = new HashSet<>();
		Deque<List<Integer>> queue = new LinkedList<>();
		seen.add(A);
		queue.offer(A);
		while (!queue.isEmpty()) {
			A = queue.poll();
			for (int i = 0; i < n; ++i) {
				for (int j = i + 1; j < n; ++j) {
					if (isGood(A.get(i), j + 1) && isGood(A.get(j), i + 1)) {
						List<Integer> next = new ArrayList<>(A);
						next.set(i, A.get(j));
						next.set(j, A.get(i));
						if (seen.add(next)) {
							queue.offer(next);
						}
					}
				}
			}
		}
		return seen.size();
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		obj.countArrangement(2);
	}
}

// Time complexity: O(k n^2) where k = number of valid permutations
// Space complexity: O(k n)

// For better understanding into the approach TLE solution
class Solution_TLE {
	int count = 0;

	public int countArrangement(int N) {
		int[] nums = new int[N];
		for (int i = 1; i <= N; ++i) {
			nums[i - 1] = i;
		}
		permute(nums, 0);
		return count;
	}

	public void permute(int[] nums, int l) {
		if (l == nums.length - 1) {
			int i;
			for (i = 1; i <= nums.length; ++i) {
				if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0) {
					break;
				}
				if (i == nums.length + 1) {
					count++;
				}
			}
		}
		for (int i = l; i < nums.length; ++i) {
			swap(nums, i, l);
			permute(nums, l + 1);
			swap(nums, i, l);
		}
	}

	public void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

/*
 * Algorithm
 * 
 * In the brute force approach, we create the full array for every permutation
 * and then check the array for the given divisibilty conditions. But this
 * method can be optimized to a great extent.
 * 
 * To do so, we can keep checking the elements while being added to the
 * permutation array at every step for the divisibility condition and can stop
 * creating it any further as soon as we find out the element just added to the
 * permutation violates the divisiblity condition.
 */

class Solution_TLEOptimized {
	int count = 0;

	public int countArrangement(int N) {
		int[] nums = new int[N];
		for (int i = 1; i <= N; ++i) {
			nums[i - 1] = i;
		}
		permute(nums, 0);
		return count;
	}

	public void permute(int[] nums, int l) {
		if (l == nums.length) {
			count++;
		}
		for (int i = l; i < nums.length; ++i) {
			swap(nums, i, l);
			if (nums[l] % (l + 1) == 0 || (l + 1) % nums[l] == 0) {
				permute(nums, l + 1);
			}
			swap(nums, i, l);
		}
	}

	public void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

/*
 * Complexity Analysis
 * 
 * Time complexity : O(k)O(k)O(k). kkk refers to the number of valid
 * permutations.
 * 
 * Space complexity : O(n)O(n)O(n). The depth of recursion tree can go upto nnn.
 * Further, numsnumsnums array of size nnn is used, where, nnn is the given
 * number.
 */

// Backtracking

/*
 * Algorithm:
 * 
 * The idea is simple: We try to create all the permutations of the numbers from
 * 1 to N. We can fix one number at a particular position and check for the
 * divisibility criteria of that number at the particular position.
 * 
 * But we need to keep a track of the numbers which have already been considered
 * earlier so that they aren't reconsidered while generating the permutations.
 * 
 * If the current number doesn't satisfy the divisibility criteria, we can leave
 * all the permutations that can be generated with that number at the particular
 * position.
 * 
 * This helps to prune the search space of the permutations to a great extent.
 * 
 * We do so by trying to place each of the numbers at each position
 * 
 * -------
 * 
 * We make use of a visited array of size N, here visited[i] refers to the ith
 * number being placed/not placed in the array formed till now (true indicates
 * that the number has already been placed)
 * 
 * We can make use of a calculate function, which puts all the numbers pending
 * from 1 to N (i.e not placed till now in the array), indicated by a False at
 * the corresponding visited[i] position, and tries to create all the
 * permutations with those numbers starting from the 'pos' index onwards in the
 * current array
 * 
 * While putting the posth number, we can check whether the ith number satisfies
 * divisibility criteria on the go, i.e we can continue forward with creating
 * the permutations with the number i at the posth position, only if the number
 * i and pos satisfy the given criteria.
 * 
 * Otherwise we can continue putting the next numbers at the same position and
 * keep on generating the permutations
 */

class Solution_Backtracking {
	int count = 0;

	public int countArrangement(int N) {
		boolean[] visited = new boolean[N + 1];
		calculate(N, 1, visited);
		return count;
	}

	public void calculate(int N, int pos, boolean[] visited) {
		if (pos > N) {
			count++;
		}
		for (int i = 1; i <= N; ++i) {
			if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
				visited[i] = true;
				calculate(N, pos + 1, visited);
				visited[i] = false;
			}
		}
	}
}

/*
 * Time: O(k), where k refers to the number of valid permutations
 * 
 * Space: O(n) visited array of size n is used. The depth recursion tree will
 * also go upto n Here n refers to the given integer n
 */
