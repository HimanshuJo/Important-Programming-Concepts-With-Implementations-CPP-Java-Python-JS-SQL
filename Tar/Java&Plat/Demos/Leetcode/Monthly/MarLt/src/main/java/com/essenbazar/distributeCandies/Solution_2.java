/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.distributeCandies;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*

Recall that a Set cannot contain duplicates, and attempting to add a duplicate item into a Set will do nothing.

Therefore, the best way to find the number of unique elements is to simply insert all of the candyType
elements into a Hash Set.

After that, the number of unique candies is simply the number of elements in the Hash Set.

 */
class Solution_2 {

    public int distributeCandies(int[] candyType) {

        Set<Integer> uniqueCandiesSet = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandiesSet.add(candy);
        }

        return Math.min(uniqueCandiesSet.size(), candyType.length / 2);
    }
}

/*

Complexity Analysis

Let N be the the length of candyType.

    Time complexity : O(N).

        Adding an item into a Hash Set has an amortized time of O(1).
            Therefore, adding N items requires O(N) time.

        All of the other operations we use are O(1).

    Space complexity : O(N).

    T   The worst case for space complexity occurs when all N elements are unique.
        This will result in a Hash Set containing N elements.


*/
