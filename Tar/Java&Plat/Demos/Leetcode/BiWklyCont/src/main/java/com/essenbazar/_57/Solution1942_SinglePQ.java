package com.essenbazar._57;

//The Number of the Smallest Unoccupied Chair
//using single Priority Queue
/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that 
are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, 
they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival 
and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.

Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation: 
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1942_SinglePQ {
	public int smallestChair(int[][] times, int targetFriend) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(
				(a, b) -> (a[0] == b[0] ? a[1] == b[1] ? a[0] - b[0] : a[1] - b[1] : a[0] - b[0]));
		int[] tar = times[targetFriend];
		Arrays.sort(times);
		for (int i = 0; i < times.length; ++i) {
			// Last person is already leaving
			// queue will now again carry the last's person's chair
			// new person will take that chair
			while (!queue.isEmpty() && queue.peek()[0] < times[i][0]) {
				queue.add(new int[] { times[i][0], queue.peek()[1] });
				queue.poll();
			}
			if (tar[0] == times[i][0]) {
				break;
			}
			if (queue.isEmpty() || queue.peek()[0] > times[i][0]) {
				queue.add(new int[] { times[i][1], queue.size() });
			} else {
				queue.add(new int[] { times[i][1], queue.peek()[1] });
				queue.poll();
			}
		}
		return !queue.isEmpty() && queue.peek()[0] <= tar[0] ? queue.peek()[1] : queue.size();
	}
}