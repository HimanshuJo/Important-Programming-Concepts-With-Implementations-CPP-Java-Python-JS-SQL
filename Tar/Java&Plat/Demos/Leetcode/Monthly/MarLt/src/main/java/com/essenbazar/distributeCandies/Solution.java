
package com.essenbazar.distributeCandies;

/*

Alice has n candies, where the ith candy is of type candyType[i].
Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
Alice likes her candies very much, and she wants to eat the maximum number of different types of
candies while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different types of candies
she can eat if she only eats n / 2 of them.

Example 1:

Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.

 */

import java.util.*;

class Solution {

	public int distributeCandies(int[] candyType) {

		int howManyCand = candyType.length / 2;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < candyType.length; i++) {
			map.put(candyType[i], map.getOrDefault(candyType[i], 0) + 1);
		}

		System.out.println(map);

//        for (int i = 0; i < map.size(); i++) {
//            if (i < howManyCand) {
//                res++;
//            }
//        }

		return Math.min(map.size(), howManyCand);
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] candyType = { 1, 1, 2, 2, 3, 3 };
		my_obj.distributeCandies(candyType);
	}
}
