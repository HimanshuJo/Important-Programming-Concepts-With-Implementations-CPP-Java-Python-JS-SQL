package com.essenbazar._242;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given a 0-indexed binary string s and two integers minJump and maxJump.
 * In the beginning, you are standing at index 0, which is equal to '0'.
 	You can move from index i to index j if the following conditions are fulfilled:

	i + minJump <= j <= min(i + maxJump, s.length - 1), and
	s[j] == '0'.
	Return true if you can reach index s.length - 1 in s, or false otherwise.

	Example 1:

	Input: s = "011010", minJump = 2, maxJump = 3
	Output: true
	Explanation:
	In the first step, move from index 0 to index 3.
	In the second step, move from index 3 to index 5.
 */
/*
 * We keep looking for index of '0' in each '0' and we compare its index with the previous possible index
 *
 * 	1. If the index in queue is smaller than i - maxJump which means that we will never use it later, and we
 * 		just have to poll it
 *
 *  2. After polling, the first element will be the most possible index which can jump be jump to
 *
 *  	When we reach to n - 1, we'll return true
 *
 *  	whenever the queue is empty, we return false since there is no place to stand
 */

public class Solution1871 {
	public boolean canReach(String s, int minJump, int maxJump) {
		if (s.charAt(s.length() - 1) == '1') {
			return false;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == '0') {
				// remove indices from the queue if they can't be jumped to
				// how to check it
				// even after subtracting the maxJump from the current index, the number is too small
				// that means we won't be able to jump to it again
				// another way of saying is that
				// if queue.peek() + maxJump < i, then even after the maxJump we can't reach the current index
				while (!queue.isEmpty() && queue.peek() < i - maxJump) {
					queue.poll();
				}
				// empty queue means there are no indices to jump to
				if (queue.isEmpty()) {
					return false;
				}
				int top = queue.peek();
				// making sure that the previous index is something that can be jumped to
				// top of the queue is at least in the range of minJump from the current index
				if (top <= i - minJump) {
					queue.offer(i);
					if (i == s.length() - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution1871 obj = new Solution1871();
		int minJump = 2;
		int maxJump = 3;
		String s = "011010";
		System.out.println(obj.canReach(s, minJump, maxJump));
	}
}
