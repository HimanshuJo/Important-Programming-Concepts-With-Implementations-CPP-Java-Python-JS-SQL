package com.essenbazar._241;

/*
 * There are n uniquely-sized sticks whose lengths are integers from 1 to n.
 * You want to arrange the sticks such that exactly k sticks are visible from the left.
 * A stick is visible from the left if there are no longer sticks to the left of it.

    For example, if the sticks are arranged [1,3,2,5,4], then the sticks with lengths 1, 3, and 5
    are visible from the left.

	Given n and k, return the number of such arrangements.
	Since the answer may be large, return it modulo 109 + 7.

	Input: n = 3, k = 2
	Output: 3
	Explanation: [1,3,2], [2,3,1], and [2,1,3] are the only arrangements such that exactly 2 sticks are visible.
	The visible sticks are underlined.
 */

/*
 * Intuition:
 * 	For case that n stick to see k from the left, we consider the last element in the list
 * 	Case1: If it is the largest, then n-1 stick to see k-1 (excluding the last)
 * 		dp[n][k] += dp[n - 1][k - 1]
 * 	Case2: If it is not the largest, n-1 choices for the last elements then n-1 sticks to see k (excluding the last)
 * 		dp[n][k] += dp[n - 1][k] * (n - 1)
 * 	Edge Case1: if n == k return 1
 * 	Edge Case2: if k == 0 return 0
 *
 * Time:
 * 	O(nk)
 *
 * Space:
 * 	O(nk)
 */

public class Solution1866 {

	int dp[][] = new int[1001][1001];
	int mod = (int) 1e9 + 7;

	public int rearrangeSticks(int n, int k) {
		if (n == k)
			return 1;
		if (k == 0)
			return 0;
		if (dp[n][k] == 0) {
			dp[n][k] = (int) ((1L * rearrangeSticks(n - 1, k - 1) + 1L * rearrangeSticks(n - 1, k) * (n - 1)) % mod);
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		Solution1866 obj = new Solution1866();
		System.out.println(obj.rearrangeSticks(3, 2));
	}

}

/*
 * dp[i][j]: We have i sticks and j left visible
 *
 * For dp[i+1][j] let's imagine we add a smallest stick Let's talk about how
 * this adding smallest stick will impact left visible If we don't put it in the
 * first place, then it will not impact left visible at all And there are i
 * places to put this smallest stick, so this i * dp[i][j] And what if we put
 * this in the first place, then this smallest stick will be left visible, so we
 * need j-1 left visible which is dp[I][j] = dp[i][j] * I + dp[i][j-1]
 *
 * Time: O(n*k) Space: O(n*k)
 */

class Solution2 {
	public int rearrangeSticks(int n, int k) {
		// we have i sticks and j left visible
		// imagine for i+1, we add a smallest stick into the group
		// so for dp[i+1][j], when we put this smallest stick not in the first place,
		// this stick will
		// have no impact on left visible
		// and there are i places to put, so i*dp[i][j]
		// when this smallest stick is put in the first place, then only j-1 visible for
		// the remaining
		// so dp[i][j-1]
		// Hence, dp[i+1][j] = dp[i][j] * i + dp[i][j-1]
		// dp[0][0] = 1
		long[][] dp = new long[n + 1][k + 1];
		dp[0][0] = 1L;
		int mod = (int) (1e9 + 7);
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= Math.min(i, k); ++j) {
				dp[i][j] = dp[i - 1][j] * (i - 1) + dp[i - 1][j - 1];
				dp[i][j] %= mod;
			}
		}
		return (int) (dp[n][k] % mod);
	}
}
