package com.essenbazar._228;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given an undirected graph. You are given an integer n which is the number of
 * nodes in the graph and an array edges, where each edges[i] = [ui, vi]
 * indicates that there is an undirected edge between ui and vi.

	A connected trio is a set of three nodes where there is an edge between every pair of them.

	The degree of a connected trio is the number of edges where one endpoint is in the trio,
	and the other is not.

	Return the minimum degree of a connected trio in the graph, or -1 if the graph has no
	connected trios.
 */
/*
 * The HashMap degree keeps track of the degree for each of the vertex
 * A boolean array can be used to keep track of whether (i, j) is an edge
 *
 * Then we can just iterate through all the edges(i, j), and for each of the edge, iterate through
 * 	all the nodes k, if (i, k) and (j, k) are also edges, then this is a trio
 *
 * 	We can just use the degrees we have stored in the HashMap to calculate the total degrees
 *
 * 	The complexity is O(E*V), where E is the number of edges, and V is the number of vertices (which is N)
 * 		In the worst scenario, there would be N^2 edges, so the time complexity is O(N^3)
 */
class Solution1761 {
	public int minTrioDegree(int n, int[][] edges) {
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> degrees = new HashMap<>();
		boolean[][] isEdge = new boolean[n + 1][n + 1];
		for (int[] edge : edges) {
			degrees.put(edge[0], degrees.getOrDefault(edge[0], 0) + 1);
			degrees.put(edge[1], degrees.getOrDefault(edge[1], 0) + 1);
			isEdge[edge[0]][edge[1]] = true;
			isEdge[edge[1]][edge[0]] = true;
		}
		for (int[] edge : edges) {
			for (int i = 1; i <= n; ++i) {
				if (isEdge[i][edge[0]] && isEdge[i][edge[1]]) {
					// here we have to subtract 6 because we don't want to count the inner edges of
					// a trio
					int degree = degrees.get(i) + degrees.get(edge[0]) + degrees.get(edge[1]) - 6;
					min = Math.min(min, degree);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
}
