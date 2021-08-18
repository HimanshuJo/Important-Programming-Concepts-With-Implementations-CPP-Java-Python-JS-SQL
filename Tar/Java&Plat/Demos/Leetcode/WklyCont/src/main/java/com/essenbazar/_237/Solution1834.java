package com.essenbazar._237;

/*
Project for solving some weekly contest problems
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author himanshu
 */

/*
 *
 * You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D
 * integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means
 * that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and
 * will take processingTimei to finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time
 * and will act in the following way:
 *
 * If the CPU is idle and there are no available tasks to process, the CPU
 * remains idle. If the CPU is idlel and there are available tasks, the CPU will
 * choose the one with the shortest processing time. If multiple tasks have the
 * same shortest processing time, it will choose the task with the smallest
 * index. Once a task is started, the CPU will process the entire task without
 * stopping. The CPU can finish a task then start a new one instantly.
 *
 * Return the order in which the CPU will process the tasks.
 *
 * Input: tasks = [[1,2],[2,4],[3,2],[4,1]] Output: [0,2,3,1] Explanation: The
 * events go as follows: - At time = 1, task 0 is available to process.
 * Available tasks = {0}. - Also at time = 1, the idle CPU starts processing
 * task 0. Available tasks = {}. - At time = 2, task 1 is available to process.
 * Available tasks = {1}. - At time = 3, task 2 is available to process.
 * Available tasks = {1, 2}. - Also at time = 3, the CPU finishes task 0 and
 * starts processing task 2 as it is the shortest. Available tasks = {1}. - At
 * time = 4, task 3 is available to process. Available tasks = {1, 3}. - At time
 * = 5, the CPU finishes task 2 and starts processing task 3 as it is the
 * shortest. Available tasks = {1}. - At time = 6, the CPU finishes task 3 and
 * starts processing task 1. Available tasks = {}. - At time = 10, the CPU
 * finishes task 1 and becomes idle.
 *
 */

/*
 *
 * We can maintain a Min Heap or Queue to maintain our tasks
 *
 * Before processing the tasks, we would want to sort the taks according to
 * their enque time
 *
 * Suppose the tasks array is: [[1,2],[2,4],[3,2],[4,1]]
 *
 * Initially [1,2] will be put in the min heap
 *
 * We will always be taking only those tasks from our min heap that have the
 * smallest processing time Currently we have only one tasks in the min heap
 * therefore we can cross it out and process it
 *
 * We will set a global time variable, initially it will be set to the enque
 * time of the first task present in the min heap
 *
 * as soon as we process the tasks from the min heap we update our time variable
 * and add the processing time of the tasks to it
 *
 * In this case, [1,2] will be processed and t = 3;
 *
 * We will also maintain a result array there we can put the index of the
 * currently processed tasks
 *
 * How can we remember the original index of each of these pairs
 *
 * For that we can maintain a data structure in the form of 3 d array where the
 * 0th position is for the index 1st position is for the enque time 2nd position
 * is for the processig time
 *
 * Next we check the time variable, which is at 3
 *
 * we can process the tasks lists, and add all the entries which has the enque
 * time less and equal to 3
 *
 * we can add [2, 4, 1] to our min heap --> last value is for the index
 *
 * we can also add [3, 2, 2] to our min heap since it also has enqueue time less
 * than equal to 3
 *
 * At this point we have two values in our queue:
 *
 * we have to make a choice on which one to pop:
 *
 * In the min heap we will process the tasks which has a smaller processing time
 * for that we can compare the 2nd index of the arrays
 *
 * We will pop [2,2] from our min heap
 *
 * and update the time as 3 + 2 = 5 and continue like this
 */
public class Solution1834 {

	public int[] getOrder(int[][] tasks) {
		int n = tasks.length;
		int[] ans = new int[n];
		int[][] tasksWithIndex = new int[n][3];

		for (int i = 0; i < n; ++i) {
			tasksWithIndex[i][0] = i;
			tasksWithIndex[i][1] = tasks[i][0]; // enque time
			tasksWithIndex[i][2] = tasks[i][1]; // processing time

		}

		// we would like to sort them based on their enque time that's what is necessary
		// for putting in min heap
		Arrays.sort(tasksWithIndex, (a, b) -> Integer.compare(a[1], b[1]));

		// which tasks to take from the priority queue
		// it should be based on the processing time
		// if both have equal processing time then it should be based on the enque time
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> a[2] == b[2] ? Integer.compare(a[0], b[0]) : Integer.compare(a[2], b[2]));

		int time = tasksWithIndex[0][1];
		int ai = 0;
		int ti = 0;

		// keep looping while our min heap is non empty or there are still some tasks
		// left to process in list
		while (ai < n) {
			// checking if the current task can be added to the min heap based on its enque
			// time
			while (ti < n && tasksWithIndex[ti][1] <= time) {
				pq.offer(tasksWithIndex[ti++]);
			}

			if (pq.isEmpty()) {
				time = tasksWithIndex[ti][1];
				continue;
			}

			int[] bestFit = pq.poll(); // take out the task from the queue and store its index
			ans[ai++] = bestFit[0];
			time += bestFit[2];
		}

		return ans;

	}

	public static void main(String[] args) {
		Solution1834 myObj = new Solution1834();
		int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
		System.out.println(Arrays.toString(myObj.getOrder(tasks)));
	}
}
