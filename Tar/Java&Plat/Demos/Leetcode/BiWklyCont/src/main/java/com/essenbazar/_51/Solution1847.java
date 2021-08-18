package com.essenbazar._51;

/*
 * There is a hotel with n rooms- These rooms are presented by a 2D integer array rooms where:
 * 	rooms[i] = [roomIdi, sizei] denotes that there is a room with room number roomIdi, and size equal to sizei
 * 
 * Each roomIdi is guaranteed to be unique
 * 
 * You are also given k queries in a 2D array queries where queries[i] = [preferredj, minSizej]. The answer to the jth
 * 	query is the room number id of a room such that:
 * 
 * 		a. The room has a size of at least minSizej, and
 * 
 * 		b. abs(id - preferredj) is minimized, where abs(x) is the absolute value of x
 * 
 * If there is tie in the absolute difference, the use the room with the smallest id, if there is no such room
 * 		then the answer is -1
 * 
 * Return an array of length x, where answer[j] contains the answer to the j'th query
 
 Example 1:

	Input: rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
	Output: [3,-1,3]
	Explanation: The answers to the queries are as follows:
	Query = [3,1]: Room number 3 is the closest as abs(3 - 3) = 0, and its size of 2 is at least 1. The answer is 3.
	Query = [3,3]: There are no rooms with a size of at least 3, so the answer is -1.
	Query = [5,2]: Room number 3 is the closest as abs(3 - 5) = 2, and its size of 2 is at least 2. The answer is 3.
 */
/*
 * Intution:
 * 
 * 		We sort the queries by the decreasing of its minSize order
 * 
 * 		We sort the rooms by the decreasing of its size order
 * 
 * 		We initialize roomIdSoFar TreeSet, this includes all the room ids which have size >= minSize of the currentQuery
 * 			so far
 * 
 * 		For each query q in queries:
 * 			Add all the room ids which have size >= minSize of the current query
 * 			
 * 			Query floor and ceiling of q[0] (preferred) from roomIdSoFar to pick the id which is closest to our
 * 				preferredId
 * 	
 * 	Complexity:
 * 		Time : O(N log N + K log K + k * log N)
 * 		Space = O(N + K)
 */

public class Solution1847 {

}
