package com.essenbazar._47;

/*
 * 
 * You are given an undirected graph represented by an integer n, which is the
 * number of nodes, and edges, where edges[i] = [ui, vi] which indicates that
 * there is an undirected edge between ui and vi. You are also given an integer
 * array queries.
 * 
 * The answer to the jth query is the number of pairs of nodes (a, b) that
 * satisfy the following conditions:
 * 
 * a < b
 * 
 * cnt is strictly greater than queries[j], where cnt is the number of edges
 * incident to a or b.
 * 
 * Return an array answers such that answers.length == queries.length and
 * answers[j] is the answer of the jth query.
 * 
 * Note that there can be repeated edges.
 * 
 */

/*
 * 
 * Algo:
 * 
 * cnt[i] is the number of edges for node i
 * 
 * shared[i][j] is the count of shared edges between nodes i and j (if exists)
 * where i < j
 * 
 * 
 * 1. How many node pairs i and j are ther, so that cnt[i] + cnt[j] is greater
 * than q
 * 
 * We can solve it in O(n) by sorting counts (sorted_cnt) and using two pointer
 * approach
 * 
 * -------
 * 
 * Important point to solve is to initially figure out how to calculate the
 * count
 * 
 * So given a pair of nodes, how can we calculate the count
 * 
 * If we have a degree of each node, for example in the above example the degree
 * of 1 is 3 (there are three edges connecting to 1) the degree of 2 is 4 (there
 * are four edges connecting to 2) degree of 3 is 2 degree of 4 is 1
 * 
 * So given any pair of nodes, we can calculate the count by degree[u] +
 * degree[v] - edgeCount[(u, v)]
 * 
 * Condition a < b simply states that, given pairs, we only count two nodes only
 * once e.g. we will only count (1, 2) not (2, 1) again
 * 
 * -------
 * 
 * To solve the questions under time constraints, we can sort the degrees then
 * we can use two pointer technique to check if degree[u] + degree[v] > val
 * 
 */

public class Solution1782 {

}
