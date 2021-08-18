package com.essenbazar._242;

import java.util.Arrays;

/*
 * Alice and Bob take turns playing a game, with Alice starting first
 *
 * There are n stones arranged in a row. On each player's turn, while the number of stones is more than one,
 * 	they will do the following:
 * 		a. Choose an integer x > 1, and remove the leftmost x stones from the row
 * 		b. Add the sum of the removed stones' value to the player's score
 * 		c. Place a new stone, whose value is equal to that sum, on the left side of the row
 *
 * 	The game stops when only one stone is left in the row
 *
 * 	The score difference between Alice and Bob is (Alice's score - Bob's score).
 * 	Alice's goal is to maximize the score difference, and Bob's goal is to minimize the score difference
 *
 * 	Given an integer array stones of length n, where stones[i] represent the value of the i'th stone from the left,
 * 		return the score difference between Alice and Bob if they both play optimally
 *
 * 	Input: stones = [-1,2,-3,4,-5]
	Output: 5
	Explanation:
	- Alice removes the first 4 stones, adds (-1) + 2 + (-3) + 4 = 2 to her score, and places a stone of
	  value 2 on the left. stones = [2,-5].
	- Bob removes the first 2 stones, adds 2 + (-5) = -3 to his score, and places a stone of value -3 on
	  the left. stones = [-3].
	The difference between their scores is 2 - (-3) = 5.
 */
/*
 * Regardless of how the game was played till now, ending a move with stone i will add sum of all
 * 	[0...i] stones to your score.
 *
 * 	So we first calculate a prefix sum to get scores in O(1):
 * 		in other words, st[i] will be a sum of all the stones [0...i]
 *
 * 	The first player can take all the stones and call it a day, if all the values are positive
 * 		Since there could also be negatives, we may want the other player to pick some stones too
 *
 * 	Let's say dp[i] represents the maximum score difference if the first player ends their first move
 * 		with stone i or later.
 * 		We start from the right, and for i == n - 1 it will be the sum of all the stones
 *
 * 	If the first player ends the move with stone i - 1, the difference will be st[i - 1] - dp[i]
 * 		The reason for that is that dp[i] now represents the maximum score difference for the second player
 *
 * 		If the first player ended the move with stone i - 1, the second player can play and end their
 * 		turn with stone i or later
 *
 * 	So, if the first player picks i - 1, the difference will be st[i - 1] - dp[i], or if the player picks
 * 		some later stone, the difference will be dp[i]
 *
 * 		Hence to maximize the difference, we pick the best of these two choices:
 * 			dp[i - 1] = max(dp[i], st[i - 1] - dp[i])
 */

public class Solution1872 {
	static int[] dp = new int[100001];

	public int stoneGameVIII(int[] stones) {
		int sum = 0;
		Arrays.fill(dp, Integer.MIN_VALUE);
		for (int i = 0; i < stones.length; ++i) {
			stones[i] = stones[i] + sum;
			sum = stones[i];
		}
		return dfs(stones, 1);
	}

	public int dfs(int[] stones, int i) {
		if (i == stones.length - 1) {
			return stones[i];
		}
		// only enter this part if the value at a particular index is Infy
		if (dp[i] == Integer.MIN_VALUE) {
			dp[i] = Math.max(dfs(stones, i + 1), stones[i] - dfs(stones, i + 1));
		}
		return dp[i];
	}
}
