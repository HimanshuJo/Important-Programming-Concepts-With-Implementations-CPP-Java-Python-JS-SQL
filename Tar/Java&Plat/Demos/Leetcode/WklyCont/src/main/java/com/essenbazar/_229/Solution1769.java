package com.essenbazar._229;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himan
 */

/*
 *
 * You have n boxes. You are given a binary string boxes of length n, where
 * boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i
 * is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may
 * be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of
 * operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 * Example 1:
 *
 * Input: boxes = "110" Output: [1,1,3] Explanation: The answer for each box is
 * as follows: 1) First box: you will have to move one ball from the second box
 * to the first box in one operation. 2) Second box: you will have to move one
 * ball from the first box to the second box in one operation. 3) Third box: you
 * will have to move one ball from the first box to the third box in two
 * operations, and move one ball from the second box to the third box in one
 * operation.
 *
 *
 */

class Solution1769 {

	public int[] minOperations(String boxes) {

		int[] res = new int[boxes.length()];
		int x = 0;
		for (int z = 0; z < boxes.length(); z++) {
			int temp_length = 0;
			for (int i = boxes.length() - 1; i >= 0; i--) {
				if (boxes.charAt(i) == '1') {
					temp_length += Math.abs(i - z);
				}
			}
			res[x] = temp_length;
			x++;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution1769 my_obj = new Solution1769();
		String boxes = "110";
		my_obj.minOperations(boxes);
	}
}
