package com.essenbazar._243;

/*
 * You are given two 0-indexed integer arrays servers and tasks of lengths n​​​​​​ and m​​​​​​ respectively.
 * servers[i] is the weight of the i​​​​​​th​​​​ server, and tasks[j] is the time needed to process
 * the j​​​​​​th​​​​ task in seconds.

	You are running a simulation system that will shut down after all tasks are processed.
	Each server can only process one task at a time. You will be able to process the jth task
	starting from the jth second beginning with the 0th task at second 0.
	To process task j, you assign it to the server with the smallest weight that is free,
	and in case of a tie, choose the server with the smallest index. If a free server gets
	assigned task j at second t,​​​​​​ it will be free again at the second t + tasks[j].

	If there are no free servers, you must wait until one is free and execute the free
	tasks as soon as possible. If multiple tasks need to be assigned, assign them in order
	of increasing index.

	You may assign multiple tasks at the same second if there are multiple free servers.

	Build an array ans​​​​ of length m, where ans[j] is the index of the server the j​​​​​​th
	task will be assigned to.

	Return the array ans​​​​.
 */
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution1882 {
	// O((M + N) * logN)
	public int[] assignTasks(int[] servers, int[] tasks) {
		// since if there are multiple tasks that need to be assigned, we need to assign
		// in the order of index
		// so we can go through tasks from left to right
		// and ask what could be the server for this task
		// For which server it can be assigned, it is determined by which servers are
		// Available
		// we just need to choose from the servers that are available with smallest
		// weight
		// Like in priorityQueue
		// So if we have a group of servers with their own next available time
		// if next available time <= the execution time of the task, we need to choose
		// the server with smallest weight
		// can we have 2 PQ, one is sorted by weight and index, this is currently
		// Available pq
		// one is sorted by available time, this is currently used server pq
		// [weight, index, available_time]
		PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
		PriorityQueue<int[]> usedQueue = new PriorityQueue<>(
				(a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
		int n = servers.length;
		int m = tasks.length;
		// O(nLogn)
		for (int i = 0; i < n; i++) {
			freeServers.add(new int[] { servers[i], i, 0 });
		}
		System.out.println("-------");
		for (int[] arr : freeServers) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("-------");
		int[] res = new int[m];
		// O(m * Logn)
		for (int i = 0; i < m; i++) {
			int t = tasks[i];
			while (!usedQueue.isEmpty() && usedQueue.peek()[2] <= i) {
				freeServers.add(usedQueue.poll());
			}
			// If there is no free servers now, we can find the used server with smallest
			// available time
			if (freeServers.isEmpty()) {
				int[] cur = usedQueue.poll();
				res[i] = cur[1];
				cur[2] += t;
				usedQueue.add(cur);
			} else {
				int[] cur = freeServers.poll();
				res[i] = cur[1];
				cur[2] = i + t;
				usedQueue.add(cur);
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	public static void main(String[] args) {
		Solution1882 obj = new Solution1882();
		int[] servers = { 3, 3, 2 };
		int[] tasks = { 1, 2, 3, 2, 1, 2 };
		obj.assignTasks(servers, tasks);
	}
}
