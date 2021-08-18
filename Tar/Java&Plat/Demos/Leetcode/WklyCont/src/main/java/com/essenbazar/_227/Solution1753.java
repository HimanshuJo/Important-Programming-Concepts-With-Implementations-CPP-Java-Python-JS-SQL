package com.essenbazar._227;

/*
Project for solving some weekly contest problems
 */
/**
 *
 * @author himan
 */

/*

You are playing a solitaire game with three piles of stones of sizes a​​​​​​, b,​​​​​​ and c​​​​​​ respectively.
Each turn you choose two different non-empty piles, take one stone from each,
and add 1 point to your score.

The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).

Given three integers a​​​​​, b,​​​​​ and c​​​​​, return the maximum score you can get.

Example 1:

Input: a = 2, b = 4, c = 6
Output: 6
Explanation: The starting state is (2, 4, 6). One optimal set of moves is:
- Take from 1st and 3rd piles, state is now (1, 4, 5)
- Take from 1st and 3rd piles, state is now (0, 4, 4)
- Take from 2nd and 3rd piles, state is now (0, 3, 3)
- Take from 2nd and 3rd piles, state is now (0, 2, 2)
- Take from 2nd and 3rd piles, state is now (0, 1, 1)
- Take from 2nd and 3rd piles, state is now (0, 0, 0)
There are fewer than two non-empty piles, so the game ends. Total: 6 points.

*/
/*
Suppose we have a pile of size 2, 4, 6

I want to maximize my score, and if I want to increase my score I will have to reduce
    the size of two piles

    The game stops as soon as two piles reaches to 0

    In essence I want to slow down the process of reducing the piles to 0
        so that I can get the maximum score  --> Greedy Step

        If I want to slow down the process, I will be picking up the pile
            with the maximum number

            Let's pick 4 and 6 and we can reduce them by 1
                we will get 3 and 5

                again we will pick the greatest two numbers and reduce them by 1
                    we will get 2 and 4 and so

    -------

    To solve we can use the PriorityQueue to always get the 2 maximum

*/
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1753 {
	public int maximumScore(int a, int b, int c) {
		int[] arr = { a, b, c };
		Arrays.sort(arr);

		// isolating the largest element and extracting the maximum possible value
		int sum1 = arr[0] + arr[1];

		int sum2 = arr[2];

		int res = 0;

		if (sum1 >= sum2) {
			// we can combine the 2 lower elements after utilizing the target of 3
			res = sum2 + (sum1 - sum2) / 2;
		} else {
			res = sum1;
		}

		return res;
	}
}

class SolutionPriorityQueue {

	public int maximumScore(int a, int b, int c) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, b1) -> (b1 - a1));
		maxHeap.add(a);
		maxHeap.add(b);
		maxHeap.add(c);
		int score = 0;
		while (maxHeap.size() > 1) {
			int maxNum1 = maxHeap.remove(); // maxHeap.poll() also works fine
			int maxNum2 = maxHeap.remove();
			maxNum1--;
			maxNum2--;
			if (maxNum1 > 0) {
				maxHeap.add(maxNum1);
			}
			if (maxNum2 > 0) {
				maxHeap.add(maxNum2);
			}
			score++;
		}
		return score;
	}
}

/*
 * The remove() and poll() methods differ only in their behavior when the queue
 * is empty: the remove() method throws an exception, while the poll() method
 * returns null
 */