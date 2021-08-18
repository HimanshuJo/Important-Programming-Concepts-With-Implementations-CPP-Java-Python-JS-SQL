package com.essenbazar._230;

/*

You would like to make dessert and are preparing to buy the ingredients.
You have 'n' ice cream base flavors and 'm' types of toppings to choose from.

You must follow these rules when making your dessert:
There must be exactly one ice cream base.

You can add one or more types of topping or have no toppings at all.
There are at most two of each type of topping.

You are given three inputs:

    baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the
        ith ice cream base flavor.

    toppingCosts, an integer array of length m, where each toppingCosts[i] is the price
        of one of the ith topping.

    target, an integer representing your target price for dessert.

You want to make a dessert with a total cost as close to target as possible.

Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.

Example 1:

Input: baseCosts = [1,7], toppingCosts = [3,4], target = 10
Output: 10

Explanation: Consider the following combination (all 0-indexed):

- Choose base 1: cost 7
- Take 1 of topping 0: cost 1 x 3 = 3
- Take 0 of topping 1: cost 0 x 4 = 0
Total: 7 + 3 + 0 = 10.

*/

public class Solution1774 {
	int result = 0;
	int min = Integer.MAX_VALUE;

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

		// for every cost in baseCost, we need to perform dfs search, store result in
		// the result variable
		for (int baseCost : baseCosts)
			dfs(toppingCosts, 0, baseCost, target);
		return result;
	}

	private void dfs(int[] toppingCosts, int i, int baseCost, int target) {

		// first step of standard recursion rule
		// when to stop searching
		if (i == toppingCosts.length) {
			if (Math.abs(target - baseCost) < min) {
				result = baseCost;
				min = Math.abs(target - baseCost);
			}
			return;
		}

		// second step, which paths you will explore from here
		dfs(toppingCosts, i + 1, baseCost, target); // no toppings
		dfs(toppingCosts, i + 1, baseCost + toppingCosts[i], target); // one of such type of toppings
		dfs(toppingCosts, i + 1, baseCost + toppingCosts[i] * 2, target); // two of such type of toppings
	}

	public static void main(String[] args) {
		Solution1774 my_obj = new Solution1774();
		int[] baseCosts = { 1, 7 };
		int[] toppingCosts = { 4, 5, 100 };
		System.out.println(my_obj.closestCost(baseCosts, toppingCosts, 10));
		System.out.println(my_obj);
	}

}
