package com.essenbazar._242;

/*
 * You are given a floating-point number hour, representing the amount of
 * time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order.
 	You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers)
 	of the ith train ride.

	Each train can only depart at an integer hour, so you may need to wait in between each train ride.

    For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you
    can depart on the 2nd train ride at the 2 hour mark.

	Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for
	you to reach the office on time, or -1 if it is impossible to be on time.

	Tests are generated such that the answer will not exceed 10^7 and hour will have at most two digits
	after the decimal point.

	Input: dist = [1,3,2], hour = 6
	Output: 1
	Explanation: At speed 1:
	- The first train ride takes 1/1 = 1 hour.
	- Since we are already at an integer hour, we depart immediately at the 1 hour mark.
		The second train takes 3/1 = 3 hours.
	- Since we are already at an integer hour, we depart immediately at the 4 hour mark.
		The third train takes 2/1 = 2 hours.
	- You will arrive at exactly the 6 hour mark.
 */
/*
 * Hint:
 * 	There will be at-most two digits after the decimal point in hour
 * 		This basically boils down to the fact that:
 * 			hour >= dist.length - 1 + 0.01, if there is a valid speed
 * 		Hence the max speed is no more than 10^5 / 0.01 = 10^7, and the search space for the speed is
 * 			[1, 10^7]
 *
 * 	Note: Using (dist + speed - 1) / speed to compute the ceil of the time taking of a train
 */
/*
 * Here we know the minimum answer can be 1 and the max answer can be 10^7 + 1
 * We can perform the binary search to find the best integer i such that:
 * 		Initially sum = 0
 * 		for each index j in range 0 to n - 1
 * 			sum = sum + ceil(dist[j] / i)
 * 		for n - 1 index, sum = sum + dist[n - 1] / i
 * 			Because time taken by the last train need not be converted into integer
 */
/*
 * Why it's a binary search:
 * 	We have to find a speed x such that, total time taken is less than the time given in problem
 	If I take too less speed, it will take more time and,
 	if we take more speed it will take less time, but we need to keep speed to minimum

 	So lets find out timeTaken for speed m, if it take less time then, it is our candidate for our answer
 		so here decrease right bound of speed
	else if time taken is more, then speed was less so we need more speed so,
		we increment the lower bound
 */
/*
 * e.g.
	 * int speed = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // in km/hr
	 * int hour = 4;  // in hours
	 * int distance = 35;  // in kms
	 * int ans = -1;
	 * int low = 0, high = speed.length;  // for that it is essential that we already have a full range of speed
	 * while (low <= high) {
	 * 	int mid = (low + high) / 2;  // getting mid point let's say 4
	 * 	int s = speed[mid];  // getting speed at mid point index : s = speed[mid], s = 5;
	 * 	int timeTaken = distance / s;  // 7
	 * 	if (timeTaken > hour) {
	 * 		// timeTaken > hour, so in order to achieve less time, we have to find a value that is greater
	 * 		// than this one, all the bigger values lie on the right side of the midPoint, so we have to
	 * 		// shift out midPoint to the right side
	 * 		min = mid + 1;
	 * 	} else {
	 * 		// for achieving minimum speed, we have to find a value that is less than this one
	 * 		// all the smaller value lie on the left side of the mid point
	 * 		max = mid - 1;
	 * 		ans = s;
	 * 	}
	 * }
 */

class Solution1870 {
	public int minSpeedOnTime(int[] dist, double hour) {
		int n = dist.length;
		int min = 1, max = 10_000_000;
		int ans = -1;
		while (min <= max) {
			int mid = (max + min) / 2;
			double sum = 0;
			for (int i = 0; i < n - 1; ++i) {
				sum += Math.ceil(((double) dist[i]) / mid);
			}
			sum = sum + (((double) dist[n - 1]) / mid);
		 	// if sum > hour, we need bigger speed to make our time in the required constraint
			if (sum > hour) {
				min = mid + 1;
			} else { // need smaller speed
				ans = mid;
				max = mid - 1;
			}
		}
		return ans;
	}
}