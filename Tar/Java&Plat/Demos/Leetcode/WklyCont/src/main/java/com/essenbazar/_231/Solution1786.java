package com.essenbazar._231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * There is an undirected weighted connected graph. You are given a positive integer n which
 * denotes that the graph has n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui,
 * vi, weighti] denotes that there is an edge between nodes ui and vi with weight equal to weighti.

	A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk] such that z0 = start and
	zk = end and there is an edge between zi and zi+1 where 0 <= i <= k-1.

	The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x)
	denote the shortest distance of a path between node n and node x. A restricted path is a path
	that also satisfies that distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.

	/*Return the number of restricted paths from node 1 to node n. Since that number may be too large,
	return it modulo 109 + 7.

	Input: n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
	Output: 3

	Explanation: Each circle contains the node number in black and its distanceToLastNode value in blue.
		The three restricted paths are:
	1) 1 --> 2 --> 5
	2) 1 --> 2 --> 3 --> 5
	3) 1 --> 3 --> 5
 */
/*
 * We can use Dijkstra to calculate shortest distance paths from last node 'n' to any other nodes x,
 * 	the result is distanceToLastNode(x), where x in 1...n
 *
 * 	Complexity: O(M log N), where M is the number of edges, N is the number of nodes
 *
 * 	In the restricted path, [z0, z1, z2,....zk], node zi always stand before node z(i + 1)
 * 		because distanceToLastNode(zi) > distanceToLastNode(zi + 1),
 *
 * 	Meanwhile with DFS we can calculate number of paths, a 'current Node' never comes back to the
 * 		'visited nodes', so we don't need to use visited array to check visited nodes.
 *
 * 	Then our dfs(src) function only depends on one parameter src, we can use memory cache to cache pre-computed
 * 		results of dfs function, so the time complexity can be deduced to be O(E)
 *
 * Complexity:
 *
 * 	O(M * log N), where M is the number of edges and N is the number of nodes
 *
 * Space:
 *
 * 	O(M + N)
 */

/*
 * Definition of restricted paths:
 * 	Path from a source node(n) to a target node(1) should have strictly increasing shortest distance to source(n)
 * 		for all the nodes
 *
 * 	Idea:
 * 		is to calculate shortest distance from node n to all the nodes and save it in a dist array
 *
 * 		Then use DFS from source to all the nodes whose weight is greater than the source node
 *
 * 		Return 1 if we have reached node 1 or return saved value for source if it's value is not -1 (not visited)
 *
 * 		Save the result for later use
 *
 * 		Return result (count of the restricted paths)
 */
/*
 *
 */
public class Solution1786 {
	public int countRestrictedPaths(int n, int[][] edges) {
		if (n == 1) {
			return 0;
		}
		@SuppressWarnings("unchecked")
		List<int[]>[] graph = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new ArrayList<>();
		}
		for (int[] e : edges) {
			graph[e[0]].add(new int[] { e[2], e[1] });
			graph[e[1]].add(new int[] { e[2], e[0] });
		}
		for (List<int[]> temp : graph) {
			if (temp != null) {
				for (int[] arr : temp) {
					System.out.println(Arrays.toString(arr));
				}
			}
			System.out.println("-------");
		}
		int[] dist = dijkstra(n, graph);
		// Dist array will be storing shortest distance from each node to the target
		// node
		// e.g. [2147483647, 4, 2, 1, 6, 0]
		// here 0th index is extra, rest show for each node the shortest distance to
		// target node (5)
		System.out.println("dist: " + Arrays.toString(dist));
		return dfs(1, n, graph, dist, new Integer[n + 1]);
	}

	public int[] dijkstra(int n, List<int[]>[] graph) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		minHeap.offer(new int[] { 0, n });
		while (!minHeap.isEmpty()) {
			int[] top = minHeap.poll();
			System.out.println("queue top: " + Arrays.toString(top));
			System.out.println("-------");
			int d = top[0], u = top[1];
			if (d != dist[u]) {
				continue;
			}
			for (int[] neighbor : graph[u]) {
				int w = neighbor[0], v = neighbor[1];
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					minHeap.offer(new int[] { dist[v], v });
				}
			}
		}
		return dist;
	}

	int dfs(int src, int n, List<int[]>[] graph, int[] dist, Integer[] memo) {
		if (memo[src] != null) {
			return memo[src];
		}
		// if we found a path to the destination
		if (src == n) {
			return 1;
		}
		int ans = 0;
		for (int[] arr : graph[src]) {
			int value = arr[1];
			if (dist[src] > dist[value]) {
				ans = (ans + dfs(value, n, graph, dist, memo)) % 1000000007;
			}
		}
		return memo[src] = ans;
	}

	class SolutionHashMap {

		public Map<Integer, List<int[]>> map = new HashMap<>();
		public final static int mod = 1000000007;

		public int countRestrictedPaths(int n, int[][] edges) {
			// create graph with edges only deal with 0th and 1st indices in edges
			for (int[] e : edges) {
				map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[] { e[1], e[2] });
				map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(new int[] { e[0], e[2] });
			}
			// sorting based on the weights
			// basically performing dijkstra here
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
			pq.offer(new int[] { n, 0 });
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[n] = 0;
			while (!pq.isEmpty()) {
				int[] curr = pq.poll();
				int node = curr[0];
				int weight = curr[1];
				for (int[] neighbor : map.get(node)) {
					int nei = neighbor[0];
					int w = weight + neighbor[1];
					// we will only traverse if we are getting a shorter path
					// at the end of we'll have all the shortest paths for each node from the last
					// node n
					if (w < dist[nei]) {
						dist[nei] = w;
						pq.offer(new int[] { nei, w });
					}
				}
			}
			Integer[] dp = new Integer[n + 1];
			return dfs2(1, n, dist, dp);
		}

		public int dfs2(int node, int end, int[] dist, Integer[] dp) {
			if (node == end) {
				return 1;
			}
			if (dp[node] != null) {
				return dp[node];
			}
			long res = 0;
			for (int[] neighbor : map.get(node)) {
				int nei = neighbor[0];
				// we will utilize our calculations from dijkstra array to determine if we can
				// travel to the
				// neighbor
				if (dist[node] > dist[nei]) {
					res = (res + dfs2(nei, end, dist, dp)) % mod;
				}
			}
			res = (res % mod);
			// memoize for looking up values that has already been calculated
			return dp[node] = (int) res;
		}
	}

	public static void main(String[] args) {
		Solution1786 obj = new Solution1786();
		int n = 5;
		int[][] edges = { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 }, { 5, 2, 2 }, { 3, 5, 1 }, { 5, 4, 10 } };
		System.out.println(obj.countRestrictedPaths(n, edges));
	}

}
