package com.essenbazar._240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

There is a directed graph of n colored nodes and m edges

The nodes are numbered from 0 to n - 1

We are given a string colors where colors[i] is a lowercase English letter
    representing the color of the i'th node in this graph (0-indexed)

    We are also given a 2-D array edges where edges[j] = [ai - bi]
        indicates that there is a directed edge from node aj to node bj

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... xk
    such that there is a directed edge from xi to xi+1
    for every 1 <= i < k

    The color value of the path is the number of nodes that are colored the most frequently
        occurring color along the path

Return the largest color value of any valid path in the given graph, or -1 if the graph contains
    a cycle

Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).

 */

/*

First thing we want to find all the paths

-------

One implicit condition (suggested though not directly expressed):
   we want each of the path to be as long as possible

   The longer the path is, the higher the frequency of the colors would be
       Basically the longer the path is, the bigger the most frequently colored nodes
       we can get

   -------

   Few things we have to consider here:
       In order to find the longest path possible, we have to find a start point
           we don't want to start from the middle of the graph
               that will not give us the longest path

       so we will start from the node which doesn't have a parent node

           in this case, we can use the in-degree

   1. We will start traversing this graph with the node that has the in-degree 0

   2. Since we need to check all the colors
           suppose for a node, we have to two paths to reach there
           and since we don't know which color could give us the most frequency

           that's why for each of the node we have to check all the colors

   -------

   If we want to define a state for a node
       dp[u][c] means ending with this node, and given a particular color at this node
           what will be the node's count for this color

       with this being said, if we define a state like this:
           we can use a topological sorting

       The given graph closely resembles a 'forest', not exactly a tree

           Therefore topological sorting and in-degree will help us in finding
               the next available node that we can traverse

   -------

   How can we detect the circle?

   	Basically if we use the topological sorting, if in the end the node
   		the nodes we have seen so far is less than the n

   		then we know that there is a circle

   		because, since we are using the topological sorting
   			ideally if there is no circle we should have already
   			processed all the nodes

*/
class Solution1857 {

	int res = 0;

	public int largestPathValue(String colors, int[][] edges) {
		int n = colors.length();
		List<List<Integer>> childToParent = new ArrayList<>();
		List<List<Integer>> parentToChild = new ArrayList<>();
		int[] outDegree = new int[n];
		for (int i = 0; i < n; ++i) {
			childToParent.add(new ArrayList<>());
			parentToChild.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			int from = edge[0], to = edge[1];
			childToParent.get(to).add(from);
			parentToChild.get(from).add(to);
			outDegree[from]++;
		}
		System.out.println("ChildToParent List");
		for (List<Integer> list : childToParent) {
			System.out.println(list.toString());
		}
		System.out.println("-------");
		System.out.println("ParentToChild List");
		for (List<Integer> list : parentToChild) {
			System.out.println(list.toString());
		}
		System.out.println("-------");
		System.out.println("OutDegree: ");
		System.out.println(Arrays.toString(outDegree));
		Queue<Integer> queue = new LinkedList<>();
		int[][] dp = new int[n][26];
		for (int i = 0; i < n; ++i) {
			if (outDegree[i] == 0) {
				queue.add(i); // might be the end of a possible longest path
			}
		}
		int count = n;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			count--;
			int nodeColor = colors.charAt(node) - 'a';
			for (int i = 0; i < 26; ++i) {
				for (int prev : parentToChild.get(node)) {
					dp[node][i] = Math.max(dp[node][i], dp[prev][i]);
				}
			}
			dp[node][nodeColor]++;
			res = Math.max(res, dp[node][nodeColor]);
			for (int parent : childToParent.get(node)) {
				outDegree[parent]--;
				if (outDegree[parent] == 0) {
					queue.add(parent);
				}
			}
		}
		return count > 0 ? -1 : res;
	}

	public static void main(String[] args) {
		Solution1857 obj = new Solution1857();
		String colors = "abaca";
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(obj.largestPathValue(colors, edges));
	}
}

/*
 *
 * Topological Sort and Bottom up DP
 *
 * In the first place, we need to detect cycle in the graph and return -1
 * accordingly
 *
 * This can be done is a regula DFS
 *
 * -------
 *
 * We've to observe that the maximum identically colored nodes on a path would
 * be non-decreasing if the path were extended. (Means we have to maximize the
 * path)
 *
 * In particular, if a path is extended from its head and tail by one node, then
 * the count of the specific color that the node has increments by 1 possibly
 * raising the max count of all the colors on the extended path
 *
 * Therefore, each subpaths corresponds to a subproblem which implies a DP sol.
 *
 * let's say for a color c, we would like to get the maximum identically colored
 * nodes on any path starting from vertex v, for which we have
 *
 * maxNode(v, c) = max {maxNodes(u, c) for u in v's next neighbors} + (v is
 * colored c ? 1 : 0)
 *
 * Thus a bottom up DP can be applied suitably in the reverse topological
 * sorting order
 *
 * The topological sorting can be combined with cycle detection in one-pass
 *
 * -------
 *
 * The running time for the DFS of topological sorting and cycle detection is
 * O(V + E), where
 *
 * |V| = n = vertex number |E| = m = edge number
 *
 * and DP takes O(26 * (V + E))
 *
 * So overtime time remains O(V + E)
 *
 */

class SolutionTopoSort_BottomUpDP {

	enum State {
		WHITE, GRAY, BLACK
	}

	// creating an adjacency list
	List<List<Integer>> adjList;

	// we need a state array that can be use in DFS to mark the visited nodes
	// as appropriate states
	State[] states;

	// Reverse topological sorted vertices
	List<Integer> sorted;

	public int largestPathValue(String colors, int[][] edges) {
		int n = colors.length();
		adjList = createAdjList(n, edges);
		states = new State[n];
		Arrays.fill(states, State.WHITE);
		sorted = new ArrayList<>();
		// cycle Detection && reverse topological sort
		for (int i = 0; i < n; ++i) {
			if (states[i] == State.WHITE && !detectCycle(i)) {
				return -1;
			}
		}
		// Bottom up DP, count maximum nodes of each color respectively on the path
		// starting from some node
		int[][] count = new int[n][26];
		int maxNodes = 0;
		for (int node : sorted) {
			for (int next : adjList.get(node)) {
				for (int i = 0; i < 26; ++i) {
					count[node][i] = Math.max(count[node][i], count[next][i]);
				}
			}
			maxNodes = Math.max(maxNodes, ++count[node][colors.charAt(node) - 'a']);
		}
		return maxNodes;
	}

	private List<List<Integer>> createAdjList(int n, int[][] edges) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			res.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			res.get(edge[0]).add(edge[1]);
		}
		return res;
	}

	private boolean detectCycle(int node) {
		states[node] = State.GRAY;
		for (int neighbor : adjList.get(node)) {
			if (states[neighbor] == State.GRAY || (states[neighbor] == State.WHITE) && !detectCycle(neighbor)) {
				return false;
			}
		}
		states[node] = State.BLACK;
		sorted.add(node);
		return true;
	}
}
