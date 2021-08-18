package com.essenbazar._243;

import java.util.Arrays;

/*
 * You are given an integer hoursBefore, the number of hours you have to travel to your meeting.
 * To arrive at your meeting, you have to travel through n roads. The road lengths are given as an integer array
 * dist of length n, where dist[i] describes the length of the ith road in kilometers.
 * In addition, you are given an integer speed, which is the speed (in km/h) you will travel at.

	After you travel road i, you must rest and wait for the next integer hour before you can begin traveling on the next road.
	Note that you do not have to rest after traveling the last road because you are already at the meeting.

    For example, if traveling a road takes 1.4 hours, you must wait until the 2 hour mark before traveling the next road.
    If traveling a road takes exactly 2 hours, you do not need to wait.

	However, you are allowed to skip some rests to be able to arrive on time, meaning you do not need to wait for
	the next integer hour. Note that this means you may finish traveling future roads at different hour marks.

    For example, suppose traveling the first road takes 1.4 hours and traveling the second road takes 0.6 hours.
    Skipping the rest after the first road will mean you finish traveling the second road right at the 2 hour mark,
    letting you start traveling the third road immediately.

	Return the minimum number of skips required to arrive at the meeting on time, or -1 if it is impossible.

	Input: dist = [1,3,2], speed = 4, hoursBefore = 2
	Output: 1
	Explanation:
	Without skipping any rests, you will arrive in (1/4 + 3/4) + (3/4 + 1/4) + (2/4) = 2.5 hours.
	You can skip the first rest to arrive in ((1/4 + 0) + (3/4 + 0)) + (2/4) = 1.5 hours.
	Note that the second rest is shortened because you finish traveling the second road at an integer hour due to skipping the first rest.
 */
/*
 * Intuion:
 * 	We can iterate over the dist array and fill our dp array
 * 	dp[j] / speed means that the minimum arrival time with j skips
 */
/*
 * Dynamic Programming:
 *
 * 	If we use dynamic programming here we have the following states dp(i, k) where;
 * 		1. i is the number of roads we have traversed so far
 * 		2. j is the number of skips we did
 * 		3. output of this function is the minimum arriving time
 *
 * 	Note that because times can be not-integer, we want to multiply everything by speed s, so we will work only with the integers
 *
 * 		Function dp(i, k)
 * 			1. if k < 0, it means that we are out of skips, we made more skips than it was possible and we need to return infinity
 *
 * 			2. if i < 0, it means that we did not traverse any road, so we spend 0 time for this
 *
 * 			3. Finally, there can be only two options:
 * 					we skip the breaks, and then we have dist[i] + dp(i - 1, k - 1) time
 *
 * 					or we do not skip the break, we need to round up our time to the nearest bigger number divisible by the speed
 *
 *  Complexity: we have O(n^2) states with at most 2 transitions from one to others, so time and space complexity is O(n^2)
 */
/*
 * Sample Code:
 * 		class Solution:
 * 			def minSkips(self, dist, S, H):
 * 				@lru_cache(None)
 * 				def dp(i, k):
 * 					if k < 0: return float("inf")
 * 					if i < 0: return 0
 * 					return dist[i] + min(dp(i - 1, k - 1), (dp(i - 1, k) + S - 1) // S * S
 * 				if sum(dist) > S * H:
 * 					return -1
 * 				n = len(dist)
 * 				return next(k for k in range(n + 1) if dp(n - 1, k) <= H * S)
 */
public class Solution1883 {

	public int minSkips(int[] dist, int speed, int hoursBefore) {
		int n = dist.length, dp[] = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = n; j >= 0; --j) {
				dp[j] += dist[i];
				if (i < n - 1) {
					dp[j] = (dp[j] + speed - 1) / speed * speed; // taking a rest
				}
				if (j > 0) {
					dp[j] = Math.min(dp[j], dp[j - 1] + dist[i]);
				}
			}
		}
		for (int i = 0; i < n; ++i) {
			if (dp[i] <= (long) speed * hoursBefore) {
				return i;
			}
		}
		return -1;
	}
}

class Solutiondp {
	public int minSkips(int[] dist, int speed, int hoursBefore) {
		int maxSkip = dist.length - 1;
		long[][] dp = new long[dist.length + 1][maxSkip + 1];
		for (var i : dp) {
			Arrays.fill(i, -1L);
		}
		for (int i = 0; i <= maxSkip; ++i) {
			if (travel(dist, speed, dp, i, dist.length - 1) <= (long) speed * (long) hoursBefore) {
				return i;
			}
		}
		return -1;
	}

	public long travel(int[] dist, int speed, long[][] dp, int skips, int road) {
		if (road < 0)
			return 0;
		if (dp[road][skips] != -1) {
			return dp[road][skips];
		}
		// initially not considering skips
		long res = roundUpTo(travel(dist, speed, dp, skips, road - 1) + dist[road], speed);
		// using skips
		if (skips > 0) {
			res = Math.min(res, travel(dist, speed, dp, skips - 1, road - 1) + dist[road]);
		}
		dp[road][skips] = res;
		return res;
	}

	public long roundUpTo(long val, long multipleOf) {
		return (val + multipleOf - 1) / multipleOf * multipleOf;
	}
}
