package com.essenbazar._239;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/*
 *
 * You are given a 2D integer array intervals, where intervals[i] = [lefti,
 * righti] describes the ith interval starting at lefti and ending at righti
 * (inclusive).
 *
 * The size of an interval is defined as the number of integers it contains, or
 * more formally righti - lefti + 1.
 *
 * You are also given an integer array queries. The answer to the jth query is
 * the size of the smallest interval i such that lefti <= queries[j] <= righti.
 * If no such interval exists, the answer is -1.
 *
 * Return an array containing the answers to the queries.
 *
 * Example 1:
 *
 * Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5] Output:
 * [3,3,1,4] Explanation: The queries are processed as follows: - Query = 2: The
 * interval [2,4] is the smallest interval containing 2. The answer is 4 - 2 + 1
 * = 3. - Query = 3: The interval [2,4] is the smallest interval containing 3.
 * The answer is 4 - 2 + 1 = 3. - Query = 4: The interval [4,4] is the smallest
 * interval containing 4. The answer is 4 - 4 + 1 = 1. - Query = 5: The interval
 * [3,6] is the smallest interval containing 5. The answer is 6 - 3 + 1 = 4.
 *
 */

/*
 *
 * Intution:
 *
 * Sort the queries and the intervals
 *
 * Iterate queries from small to big and find out all open intervals [l, r]
 * (Open intervals are those who satisfies the left bound)
 *
 * We can add them to our Priority Queue
 *
 * All we need to remove all the closed interval from the queue (closed interval
 * are those who satisfies the right bound)
 *
 * -------
 *
 * In the priority queue we can use [Interval size, interval end] = [r - l + 1,
 * r] as the key
 *
 * The head of the queue is the smallest interval we want to return for each
 * query
 *
 */

public class Solution1851 {
	public int[] minInterval(int[][] A, int[] queries) {
		TreeMap<Integer, Integer> pq = new TreeMap<>();
		HashMap<Integer, Integer> res = new HashMap<>();
		int i = 0, n = A.length, m = queries.length;
		int[] Q = queries.clone(), res2 = new int[m];
		Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
		Arrays.sort(Q);
		for (int q : Q) {
			// putting entries into the priority queue
			while (i < n && A[i][0] <= q) {
				int l = A[i][0], r = A[i++][1];
				pq.put(r - l + 1, r);
			}
			while (!pq.isEmpty() && pq.firstEntry().getValue() < q) {
				pq.pollFirstEntry();
			}

			res.put(q, pq.isEmpty() ? -1 : pq.firstKey());
		}
		i = 0;
		for (int q : queries) {
			res2[i++] = res.get(q);
		}
		return res2;
	}
}
