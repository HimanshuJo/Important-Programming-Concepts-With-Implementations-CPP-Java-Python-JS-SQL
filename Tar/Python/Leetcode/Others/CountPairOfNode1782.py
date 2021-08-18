'''
You are given an undirected graph represented by an integer n, which is the number of nodes, 
and edges, where edges[i] = [ui, vi] which indicates that there is an undirected edge 
between ui and vi. You are also given an integer array queries.

The answer to the jth query is the number of pairs of nodes (a, b) that satisfy the following conditions:

    a < b

    cnt is strictly greater than queries[j], where cnt is the number of edges incident to a or b.

Return an array answers such that answers.length == queries.length and answers[j] is the answer of the jth query.

Note that there can be repeated edges.

Input: n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
Output: [6,5]
Explanation: The number of edges incident to at least one of each pair is shown above.

Example 2:

Input: n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
Output: [10,10,9,8,6]

'''

class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        degree = [0] * (n + 1)
        edgeCount = defaultdict(int)
        for u, v in edges:
        	degree[u] += 1
        	degree[v] += 1
        	if u > v:
        		u, v = v, u
    		edgeCount[(u, v)] += 1
		sortedDegree = sorted(degree[1:])
		ans = []
		for val in queries:
			count = 0
			r = n
			for l in range(n - 1):
				while r - 1 > l and sortedDegree[l] + sortedDegree[r - 1] > val:
					r -= 1 
				if l < r:
					count += n - r
				else:
					count += n - l - 1

			# remove invalid pairs
			# only the pairs who have a common edge could potentially affect our count
			for u, v in edgeCount:
				if degree[u] + degree[v] > val and degree[u] + degree[v] - edgeCount[(u, v)] <= val:
					count -= 1
			ans.append(count)
		return ans