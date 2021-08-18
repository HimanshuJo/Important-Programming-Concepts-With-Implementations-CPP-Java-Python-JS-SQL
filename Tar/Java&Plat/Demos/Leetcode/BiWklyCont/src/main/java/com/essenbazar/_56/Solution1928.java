package com.essenbazar._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//  Minimum Cost to Reach Destination in Time
/*
 * There is a country of n cities numbered from 0 to n - 1 where all the cities are connected by
 * bi-directional roads. The roads are represented as a 2D integer array edges where
 * edges[i] = [xi, yi, timei] denotes a road between cities xi and yi that takes timei minutes to travel.
 * There may be multiple roads of differing travel times connecting the same two cities,
 * but no road connects a city to itself.

	Each time you pass through a city, you must pay a passing fee. This is represented as a
	0-indexed integer array passingFees of length n where passingFees[j] is the amount of
	dollars you must pay when you pass through city j.

	In the beginning, you are at city 0 and want to reach city n - 1 in maxTime minutes or less.
	The cost of your journey is the summation of passing fees for each city that you passed through at
	some moment of your journey (including the source and destination cities).

	Given maxTime, edges, and passingFees, return the minimum cost to complete your journey, or -1 if
	you cannot complete it within maxTime minutes.
 */
// Modified Dijkstra
public class Solution1928 {

	public int minCost(int maxTime, int[][] edges, int[] passingFees) {
		int target = passingFees.length - 1;
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] x : edges) {
			int u = x[0];
			int v = x[1];
			int time = x[2];
			map.putIfAbsent(u, new ArrayList<>());
			map.putIfAbsent(v, new ArrayList<>());
			map.get(u).add(new int[] { v, time });
			map.get(v).add(new int[] { u, time });
		}
		for (int i = 0; i <= target; ++i) {
			System.out.print(i + " :");
			List<int[]> temp = map.get(i);
			for (int[] arr : temp) {
				System.out.println(Arrays.toString(arr));
			}
		}
		int[] visited = new int[passingFees.length];
		Arrays.fill(visited, -1);
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
		queue.add(new int[] { 0, passingFees[0], 0 });
		visited[0] = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int u = curr[0];
			int cost = curr[1];
			int time = curr[2];
			if (u == target)
				return cost;
			for (int next[] : map.get(u)) {
				int v = next[0];
				if (visited[v] != -1 && time + next[1] >= visited[v])
					continue;
				visited[v] = time + next[1];
				if (time + next[1] <= maxTime) {
					queue.add(new int[] { v, cost + passingFees[v], time + next[1] });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution1928 obj = new Solution1928();
		int[][] edges = new int[][] { { 0, 1, 100 } };
		int[] passingFees = { 2, 5 };
		obj.minCost(100, edges, passingFees);
	}
}
