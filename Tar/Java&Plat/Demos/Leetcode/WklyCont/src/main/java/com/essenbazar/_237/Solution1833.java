package com.essenbazar._237;

/*
Project for solving some weekly contest problems
 */

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*
 *
 * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 *
 * At the store, there are n ice cream bars. You are given an array costs of
 * length n, where costs[i] is the price of the ith ice cream bar in coins. The
 * boy initially has coins coins to spend, and he wants to buy as many ice cream
 * bars as possible.
 *
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 *
 * Note: The boy can buy the ice cream bars in any order.
 *
 * Example 1:
 *
 * Input: costs = [1,3,2,4,1], coins = 7 Output: 4 Explanation: The boy can buy
 * ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
 *
 */
class Solution1833 {

	public int maxIceCream(int[] costs, int coins) {

		int sum = 0;
		int count = 0;
		int counter = 0;
		int res = 0;

		Arrays.sort(costs);

		for (int cost : costs) {
			if (res + cost <= coins) {
				res = res + cost;
				counter++;
			}
			sum += cost;
			if (cost > coins) {
				count++;
			}
		}

		if (sum <= coins) {
			return costs.length;
		} else if (count == costs.length) {
			return 0;
		} else {
			return counter;
		}
	}
}
