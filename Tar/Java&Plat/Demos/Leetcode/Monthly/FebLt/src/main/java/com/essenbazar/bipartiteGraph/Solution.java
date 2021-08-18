/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.bipartiteGraph;

/**
 *
 * @author himan
 */

/*

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.

More formally, for each v in graph[u], there is an undirected edge between node u and node v.

The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.

A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that
every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 */

 /*

Bipartite graph:

    A graph is bipartite if we can split its set of nodes into two independent subsets A and B,
    such that every 'edge' in the graph has one node in A and another node in B

Graph Coloring can be used to solve this:  --> here we can use DFS or BFS

    Nodes lie in one set can be colored same

    E.g. suppose our graph is
            0  <--> 1
               <--> 3

            2  <--> 1
               <--> 3

        To do DFS in the above graph
            initially we will start with node 0
                suppose we colour with it blue
                    to go into its depth, we can say 1 and 3 are connected
                        suppose we go to 1 and colour it red
                
                1 is connected to 2
                    we visit 2 and colour it blue

                2 is connected to 3
                    we visit 3 and colour it red
            
            till now all the nodes are visited and we haven't found any conflicts and all nodes are visited
                hence it is bipartite graph

    Time Complexity:
        O(V + E)

    Space:
        O(V)
            
 */
// suppose our colour code is:
// 0  --> not coloured 
// 1  --> blue
// -1 --> red
import java.util.*;

public class Solution {

    public boolean dfs_validColor(int[][] graph, int[] color, int currentColor, int node) {
        if (color[node] != 0) {
            return color[node] == currentColor;
        }

        color[node] = currentColor;

        for (int n : graph[node]) {
            if (!dfs_validColor(graph, color, -currentColor, n)) {
                return false;
            }
        }

        return true;
    }

    /*
    
    BFS:
        
        Visting all adjacent nodes and coloring them with the same color
    
        Popping out any one of the adjacent nodes, then coloring its neighbors with the adjacent color
            if we already found a node that has been already colored, that means conflict
    
     */
    public boolean bfs_validColor(int[][] graph, int[] color) {
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    // all adjacent nodes of i will be -1
                    Integer node_ = queue.poll();
                    for (int n : graph[node_]) {
                        if (color[n] == color[node_]) return false;
                        else if (color[n] == 0) {
                            queue.add(n);
                            color[n] = -color[node_];
                        }
                    }
                }
            }
        }
        
        return true;
    }

    public boolean isBipartite_dfs(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !dfs_validColor(graph, color, 1, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite_bfs(int[][] graph) {
        int[] color = new int[graph.length];
        return bfs_validColor(graph, color);
    }

}
