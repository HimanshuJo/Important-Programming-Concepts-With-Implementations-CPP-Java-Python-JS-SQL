package com.essenbazar._56;

// Count Square Sum Triples
/*
 * A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

	Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

	Example 1:

	Input: n = 5
	Output: 2
	Explanation: The square triples are (3,4,5) and (4,3,5).

 */

// O(n^2)

public class Solution1925 {
	public int countTriples(int n) {
		int[] squares = new int[n * n + 1];
		for (int i = 1; i <= n; ++i) {
			squares[i * i] = 1;
		}
		int res = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = i; i * i + j * j <= n * n; ++j) {
				res += squares[i * i + j * j] * 2;
			}
		}
		return res;
	}
}

// O(n^3)

class Solution {
	public int countTriples(int n) {
		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			int temp = i;
			for (int j = 1; j <= n; ++j) {
				int temp2 = j;
				for (int z = 1; z <= n; ++z) {
					int temp3 = z;
					if ((temp * temp) + (temp2 * temp2) == temp3 * temp3) {
						ans++;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution1925 obj = new Solution1925();
		obj.countTriples(1500);
	}
}
