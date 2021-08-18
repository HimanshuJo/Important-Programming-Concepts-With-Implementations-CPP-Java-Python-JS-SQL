package com.essenbazar._233;

/*
 * You are given a 2D integer array orders, where each orders[i] = [pricei, amounti, orderTypei]
 * denotes that amounti orders have been placed of type orderTypei at the price pricei. The orderTypei is:

    0 if it is a batch of buy orders, or
    1 if it is a batch of sell orders.

	Note that orders[i] represents a batch of amounti independent orders with the same price and order type.
	All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.

	There is a backlog that consists of orders that have not been executed. The backlog is initially empty.
	When an order is placed, the following happens:

    If the order is a buy order, you look at the sell order with the smallest price in the backlog.
    If that sell order's price is smaller than or equal to the current buy order's price, they will match and be executed,
    and that sell order will be removed from the backlog. Else, the buy order is added to the backlog.
    Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog.

    If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed,
    and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.

	Return the total amount of orders in the backlog after placing all the orders from the input.
	Since this number can be large, return it modulo 109 + 7.

	Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
	Output: 6
	Explanation: Here is what happens with the orders:
	- 5 orders of type buy with price 10 are placed. There are no sell orders, so the 5 orders are added to the backlog.
	- 2 orders of type sell with price 15 are placed. There are no buy orders with prices larger than or equal to 15, so
		the 2 orders are added to the backlog.
	- 1 order of type sell with price 25 is placed. There are no buy orders with prices larger than or equal to 25
		in the backlog, so this order is added to the backlog.
	- 4 orders of type buy with price 30 are placed. The first 2 orders are matched with the 2 sell orders of the least
		price, which is 15 and these 2 sell orders are removed from the backlog.
		The 3rd order is matched with the sell order of the least price, which is 25 and this sell order is
		removed from the backlog. Then, there are no more sell orders in the backlog, so the 4th order is added to the backlog.
	Finally, the backlog has 5 buy orders with price 10, and 1 buy order with price 30. So the total number of
		orders in the backlog is 6.
 */

import java.util.PriorityQueue;

class Solution {
	public int getNumberOfBacklogOrders(int[][] orders) {
		PriorityQueue<int[]> buyQueue = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
		PriorityQueue<int[]> sellQueue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		for (int[] order : orders) {
			if (order[2] == 0) { // processing buy orders:
				while (!sellQueue.isEmpty() && order[0] >= sellQueue.peek()[0] && order[1] >= sellQueue.peek()[1]) {
					order[1] -= sellQueue.peek()[1];
					sellQueue.poll();
				}
				if (!sellQueue.isEmpty() && order[0] >= sellQueue.peek()[0] && order[1] > 0) {
					sellQueue.peek()[1] -= order[1];
					order[1] = 0;
				}
				if (order[1] > 0) {
					buyQueue.offer(order);
				}
			} else { // processing sell orders:
				while (!buyQueue.isEmpty() && order[0] <= buyQueue.peek()[0] && order[1] >= buyQueue.peek()[1]) {
					order[1] -= buyQueue.peek()[1];
					buyQueue.poll();
				}
				if (!buyQueue.isEmpty() && order[0] <= buyQueue.peek()[0] && order[1] > 0) {
					buyQueue.peek()[1] -= order[1];
					order[1] = 0;
				}
				if (order[1] > 0) {
					sellQueue.offer(order);
				}
			}
		}
		long res = 0;
		for (int[] o : sellQueue) {
			res += o[1];
		}
		for (int[] o : buyQueue) {
			res += o[1];
		}
		return (int) (res % 1000000007);
	}
}
