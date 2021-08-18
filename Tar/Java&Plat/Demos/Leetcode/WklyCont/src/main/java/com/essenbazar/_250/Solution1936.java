package com.essenbazar._250;
// Add Minimum Number of Rungs
/*
 * You are given a strictly increasing integer array rungs that represents the height of rungs on a ladder. 
 * You are currently on the floor at height 0, and you want to reach the last rung.

	You are also given an integer dist. You can only climb to the next highest rung if the distance 
	between where you are currently at (the floor or on a rung) and the next rung is at most dist. 
	You are able to insert rungs at any positive integer height if a rung is not already there.

	Return the minimum number of rungs that must be added to the ladder in order for you to climb to the last rung.

	Example 1:
	
	Input: rungs = [1,3,5,10], dist = 2
	Output: 2
	Explanation:
	You currently cannot reach the last rung.
	Add rungs at heights 7 and 8 to climb this ladder. 
	The ladder will now have rungs at [1,3,5,7,8,10].
 */

// 1ms
class Solution {
    public int addRungs(int[] rungs, int dist) {
        int res = 0, prev = 0;
        for (int rung : rungs) {
            res += (rung - prev - 1) / dist;
            prev = rung;
        }
        return res; 
    }
}

// 2461ms
public class Solution1936 {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        if (rungs[0] > dist) {
        	int temp = 0;
        	while (temp + dist < rungs[0]) {
        		ans++;
        		temp += dist;
        	}
        }
        int curr = 0;
        for (int i = 0; i < rungs.length - 1; ++i) {
        	if (rungs[i] + dist < rungs[i + 1]) {
        		curr = rungs[i] + dist;
        		while (curr < rungs[i + 1]) {
        			ans++;
        			curr = curr + dist;
        		}
        		curr = 0;
        	}
        }
        return ans;
    }
}
