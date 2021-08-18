// The Number of the Smallest Unoccupied Chair
/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that 
are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, 
they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival 
and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.

Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation: 
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.
*/

package com.essenbazar._57;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution1942 {
	public int smallestChair(int[][] times, int targetFriend) {
		// Sorting will lose the position of the targetFriend. SO either add the
		// position
		// before sorting, so every data has [arival, departure, position]
		// or just remeber target friend's arrival time (arrival times are distinct)
		int targetFriendsArrival = times[targetFriend][0];

		// Sort the times
		Arrays.sort(times, (t1, t2) -> t1[0] - t2[0]);
		// has [depature, seatNumber]
		Queue<int[]> occupiedSeats = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		// has seatNumbers
		Queue<Integer> avaialableSeats = new PriorityQueue<>();

		int result = 0;
		// seatToken keeps increasing the seat numbers monotonically from 0 till n
		int seatToken = 0;
		for (int i = 0; i < times.length; i++) {
			int arrival = times[i][0];
			int depature = times[i][1];

			// empty all the seats in occupiedSeats that crossed arrival time
			while (occupiedSeats.isEmpty() == false && occupiedSeats.peek()[0] <= arrival) {
				// collect in another pq so we can pick from begining
				avaialableSeats.add(occupiedSeats.poll()[1]);
			}

			int currentSeat;
			// Now pick a seat	
			if (avaialableSeats.isEmpty() == false) {
				// which means we can pick from this
				currentSeat = avaialableSeats.poll().intValue();
			} else {
				// which means no empty seats found, take the height seat
				currentSeat = seatToken;
				seatToken++;
			}

			occupiedSeats.add(new int[] { depature, currentSeat });
			if (arrival == targetFriendsArrival) { // We can't use index since we sorted them
				result = currentSeat;
				break;
			}
		}

		return result;
	}
}