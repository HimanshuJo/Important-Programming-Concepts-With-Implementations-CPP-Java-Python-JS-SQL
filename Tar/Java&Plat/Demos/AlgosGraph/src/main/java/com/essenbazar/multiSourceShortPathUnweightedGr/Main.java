package com.essenbazar.multiSourceShortPathUnweightedGr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Pair {
	int first, second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class Main {
	static final int N = 100000 + 1;
	static final int inf = 1000000;

	// array that will store distances of the vertices from the nearest source
	static int[] dist = new int[N];

	// a hash array where sourceCust[i] = 1 means vertex i is a source
	static int[] sourceCust = new int[N];

	// the bfs Queue
	// here the pairs are of the form (vertex, distance from the current source)
	static Deque<Pair> BFSQueue = new LinkedList<>();

	// visited array for remembering visited vertices
	static int[] visited = new int[N];

	// bfs function
	static void BFS(ArrayList<Integer>[] graph, int currVert) {
		// clearing the queue
		while (!BFSQueue.isEmpty()) {
			BFSQueue.removeLast();
		}

		// pusing back current vertices
		BFSQueue.add(new Pair(currVert, 0));
		while (!BFSQueue.isEmpty()) {
			int s = BFSQueue.peekFirst().first;
			int d = BFSQueue.peekFirst().second;
			visited[s] = 1;
			BFSQueue.removeFirst();

			// we will stop as soon as we reach the first source
			if (sourceCust[s] == 1) {
				dist[currVert] = d;
				return;
			}

			// pushing back the adjacent vertices with distance from the current source =
			// this vertex's distance + 1
			for (int i = 0; i < graph[s].size(); ++i) {
				if (visited[graph[s].get(i)] == 0) {
					BFSQueue.add(new Pair(graph[s].get(i), d + 1));
				}
			}
		}
	}

	// function to calculate the distance of each vertex from the nearest source
	static void nearestTown(ArrayList<Integer>[] graph, int n, int sources[], int sizeOfSources) {
		// reseting the source hash array
		for (int i = 1; i <= n; ++i) {
			sourceCust[i] = 0;
		}
		for (int i = 0; i <= sizeOfSources - 1; ++i) {
			sourceCust[sources[i]] = 1;
		}

		// loop through all the vertices and run a bfs from each vertex to find the distance to the nearest town from it
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				visited[j] = 0;
			}
			BFS(graph, i);
		}
		for (int i = 1; i <= n; ++i) {
			System.out.println(i + " " + dist[i]);
		}
	}

	static void addEdge(ArrayList<Integer>[] graph, int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}

	public static void main(String[] args) {
		int n = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		Arrays.fill(graph, new ArrayList<>());
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 6);
		addEdge(graph, 2, 6);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 6);
		addEdge(graph, 5, 4);
		addEdge(graph, 6, 5);
		addEdge(graph, 3, 4);
		addEdge(graph, 5, 3);
		int sources[] = { 1, 5 };
		int sizeOfSources = sources.length;
		nearestTown(graph, n, sources, sizeOfSources);
	}
}