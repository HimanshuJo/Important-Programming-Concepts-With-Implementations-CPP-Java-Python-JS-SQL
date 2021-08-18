'''
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

'''

'''

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
            suppose for a node, we have two paths to reach there
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

'''


class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        graph = defaultdict(list)
        indegree = defaultdict(int)

        for u, v in edges:
            graph[u].append(v)  # directed graph
            indegree[v] += 1

        queue = []
        # path ending at node u, how many nodes have max color c
        dp = [[0] * 26 for _ in range(n)]

        colorValues = [ord(c) - ord('a') for c in colors]

        # for the queue we are going to populate the starting nodes for
        # topological sorting
        for u in range(n):
            if u not in indegree:
                queue.append(u)
                dp[u][colorValues[u]] = 1

        # topological sorting (similar to peeling the onion layer by layer)
        # instead of using topological sorting DFS also works
        visited = 0
        while queue:
            u = queue.pop()
            visited += 1

            for v in graph[u]:
                # here we want to calculate the dp state for v for all the 26 colors
                for c in range(26):
                    # u is point to v
                    # so for each of the u we are going to use the data of this current u
                    # to update the v, we are going to do this for all the edges

                    # we need to use the same color from the parent node therefore dp[v][c]
                    # c == colorValue[v] means that, if the color we are checking is same as
                    # the current v's color, then off course we are going to add 1
                    dp[v][c] = max(dp[v][c], dp[u][c] + (c == colorValues[v]))

                indegree[v] -= 1

                if indegree[v] == 0:
                    queue.append(v)
                    del indegree[v]

        if visited < n:
            return -1

        return max(max(x) for x in dp)  # check for the max value in a 2D array


'''
Time:
	for the colorValues it's constant 26, so we can ignore it simply

	for topological sorting, the time and space complexity is both
		O(V + E)

			V -> number of vertices
			E -> number of edges

'''
