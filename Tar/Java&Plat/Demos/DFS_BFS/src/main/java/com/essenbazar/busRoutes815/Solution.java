package com.essenbazar.busRoutes815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
 * You are given an array routes representing bus routes where routes[i] is a bus route that the 
 * ith bus repeats forever.

    For example, if routes[0] = [1, 5, 7], this means that the

    	0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

	You will start at the bus stop source (You are not on any bus initially), and you want to go to 
	the bus stop target. 

	You can travel between bus stops by buses only.

	Return the least number of buses you must take to travel from source to target. 

	Return -1 if it is not possible.

	Example 1:
	
	Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
	Output: 2
	Explanation: The best strategy is take the first bus to the bus stop 7, then take the second 
	bus to the bus stop 6.
	
	Example 2:
	
	Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
	Output: -1
	
	Constraints:
	
	    1 <= routes.length <= 500.
	    1 <= routes[i].length <= 105
	    All the values of routes[i] are unique.
	    sum(routes[i].length) <= 105
	    0 <= routes[i][j] < 106
	    0 <= source, target < 106
 */

/*
 * 
Main point to note about the problem is that:

	How to build the graph?

	-------

	Naive way of building the graph:

		Our key will be the 'stop' and the value will be a list/set of all the stops from the current 
		stop without
			having to take the other bus

		Suppose our example is: routes [[1, 2, 7], [3, 6, 7]]

			from 1 we can go to 2 and 7
			from 2 we can go to 1 and 7
			from 7 we can go to 1, 2, 3, 6
			from 3 we can go to 6 and 7
			from 6 we can go to 3 and 7

		Now here in the Brute Force, we will be looping through all the given routes
			inside a particular route we have different bus stops, we will further explore each and 
			every bus stop
			based on the above describe naive idea

			To build the entire above described setup we need at-least O(n^2) time

-------

Main point is to notice here is that:

	Our routes are at-most just 500

	So instead of building a graph from like stop to stop relationship

		we can build a graph from stop -> routes

		basically for each of the stops we have a well defined route
			e.g. suppose for stop 1, it belongs to route 0

			similarly 2 -> route 0
					  7 -> route 0, 1
					  3 -> route 1
					  6 -> route 1

  	-------

  	Performing BFS:

  		Whenever we see a bus-stop we will check how many routes this particular bus-stops belongs to

  			further exploring that particular route, we will again loop through all the stops and 
  			we'll add those stops in our queue

 */

public class Solution {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < routes.length; ++i) {
			for (int stop : routes[i]) {
				if (graph.containsKey(stop)) {
					graph.get(stop).add(i);
				} else {
					graph.put(stop, new HashSet<>());
					graph.get(stop).add(i);
				}
			}
		}
		int ans = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(source);
		Set<Integer> seenStop = new HashSet<>();
		Set<Integer> seenRoute = new HashSet<>();
		seenStop.add(source);
		while (!queue.isEmpty()) {
			int lenQueue = queue.size();
			for (int i = 0; i < lenQueue; ++i) {
				int stop = queue.pop();
				if (stop == target) {
					return ans;
				}
				for (int routeId : graph.get(stop)) {
					if (!seenRoute.contains(routeId)) {
						for (int newStop : routes[routeId]) {
							if (!seenStop.contains(newStop)) {
								queue.offer(newStop);
								seenStop.add(newStop);
							}
						}
					}
					seenRoute.add(routeId);
				}
			}
			ans += 1;
		}
		return -1;
	}
}

/*
 * Time:
 * 
 * 		Let N denote the number of buses, and bi be the number of stops on the ith bus
 * 
 * 		To create a graph, in Python we do O(Sum(N - i)bi) work
 * 
 * 			while in Java we do O(Sum(bi log bi)) sorting step, plus our searches are O(N(Sum(bi)))
 * 
 * 		Our BFS is on N nodes, and each node could have N edges, so it's O(N^2)
 * 
 * Space: 
 * 
 * 		O(N^2 + Sum(bi)) additional space, the size of the graph and the routes
 */

