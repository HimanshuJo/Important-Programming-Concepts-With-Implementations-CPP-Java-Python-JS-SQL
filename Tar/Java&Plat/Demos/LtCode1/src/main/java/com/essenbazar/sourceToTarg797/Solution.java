package com.essenbazar.sourceToTarg797;

/**
 *
 * @author hjoshi
 */
/*
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
 * find all possible paths from node 0 to node n - 1, and return them in any order.

	The graph is given as follows: graph[i] is a list of all nodes you can visit from node i 
	(i.e., there is a directed edge from node i to node graph[i][j]).
 */
import java.util.*;

class Solution {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		int n = graph.length;
		boolean[] visited = new boolean[n];
		path.add(0);
		dfs(graph, 0, n - 1, visited, res, path);
		return res;
	}

	public static void dfs(int[][] graph, int src, int dest, boolean[] visited, List<List<Integer>> res,
			List<Integer> path) {
		if (src == dest) {
			List<Integer> list = new ArrayList<>(path);
			res.add(list);
			return;
		}
		visited[src] = true;
		for (int num : graph[src]) {
			if (!visited[num]) {
				path.add(num);
				dfs(graph, num, dest, visited, res, path);
				path.remove(path.size() - 1);
			}
		}
		visited[src] = false;
	}
}
