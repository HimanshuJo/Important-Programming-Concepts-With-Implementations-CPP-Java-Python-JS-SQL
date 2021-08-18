package com.essenbazar.minTimeVisitAllPoints1266;

/**
 *
 * @author hjoshi
 */

/*
 * 
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi,
 * yi]. Return the minimum time in seconds to visit all the points in the order
 * given by points.
 * 
 * You can move according to these rules:
 * 
 * In 1 second, you can either: move vertically by one unit, move horizontally
 * by one unit, or move diagonally sqrt(2) units (in other words, move one unit
 * vertically then one unit horizontally in 1 second).
 * 
 * You have to visit the points in the same order as they appear in the array.
 * 
 * You are allowed to pass through points that appear later in the order, but
 * these do not count as visits.
 * 
 * Input: points = [[1,1],[3,4],[-1,0]] Output: 7 Explanation: One optimal path
 * is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 
 * Time from [1,1] to [3,4] = 3 seconds Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 * 
 */

/*
 * 
 * Since moving diagonal takes the same amount of time, the optimal solution is
 * always to go diagonally as much as possible
 * 
 * and then move either vertically or horizontally to match the other coordinate
 * 
 * -------
 * 
 * For example, from [1, 1] to [3, 5] we should go to [3, 3] with 2 steps and
 * then from [3, 3] to [3, 5] with another 2 steps
 * 
 * We choose the smaller between 3 - 1 and 5 - 1, and then plus the rest
 * 
 * So in essence, between 1 to 3 and 1 to 5, we choose 1 to 3 and move
 * diagonally and then 3 to 5 horizontally
 * 
 * But we can always think of the larger step to move from 1 to 5
 * 
 * because the smaller 1 to 3 can happen by diagonally without any additional
 * cost
 * 
 * -------
 * 
 * Proof:
 * 
 * Statement: The time cost to travel between 2 neighboring points equals the
 * larger value between the absolute values of the difference of the respective
 * x and y coordinates of the 2 points
 * 
 * a.
 * 
 * Consider 2 points (x1, y1) and (x2, y2) and let dx = |x1 - x2|
 * 
 * dy = |y1 - y2|
 * 
 * According to the constraints of the problem, at each step we have at most 1
 * unit of moves along the x and y coordinates
 * 
 * Therefore the minTime >= max(dy, dy)
 * 
 * b. On the other hand, each step can move 1 unit along x / y coordinate to
 * cover the distance dx / dy whichever is greater
 * 
 * Therefore minTime <= max(dx, dy)
 * 
 * Combining the above 'a' and 'b' equations, we have: max(dx, dy) <= minTime <=
 * max(dx, dy)
 * 
 */
class Solution {

	public int minTimeToVisitAllPoints(int[][] points) {

		if (points.length == 1) {
			return 0;
		}
		int time = 0;
		for (int i = 1; i < points.length; ++i) {
			int xDiff = Math.abs(points[i][0] - points[i - 1][0]);
			int yDiff = Math.abs(points[i][1] - points[i - 1][1]);
			time += Math.max(xDiff, yDiff);
		}
		return time;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[][] points = { { 1, 1 }, { 5, 6 }, { 6, 5 } };
		my_obj.minTimeToVisitAllPoints(points);
	}
}
