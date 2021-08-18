package com.essenbazar._244;

import java.util.Arrays;

// Minimum Space Wasted From Packaging
/*
 * You have n packages that you are trying to place in boxes, one package in each box.
 * There are m suppliers that each produce boxes of different sizes (with infinite supply).
 * A package can be placed in a box if the size of the package is less than or equal to the
 * size of the box.

	The package sizes are given as an integer array packages,
	where packages[i] is the size of the ith package. The suppliers are given as a 2D
	integer array boxes, where boxes[j] is an array of box sizes that the jth supplier produces.

	You want to choose a single supplier and use boxes from them such that the total
	wasted space is minimized. For each package in a box, we define the space wasted to be
	size of the box - size of the package. The total wasted space is the sum of the space wasted
	in all the boxes.

    For example, if you have to fit packages with sizes [2,3,5] and the supplier offers
    boxes of sizes [4,8], you can fit the packages of size-2 and size-3 into
    two boxes of size-4 and the package with size-5 into a box of size-8.
    This would result in a waste of (4-2) + (4-3) + (8-5) = 6.

	Return the minimum total wasted space by choosing the box supplier optimally, or -1
	if it is impossible to fit all the packages inside boxes.
	Since the answer may be large, return it modulo 10^9 + 7.

	Example 1:

	Input: packages = [2,3,5], boxes = [[4,8],[2,8]]
	Output: 6
	Explanation: It is optimal to choose the first supplier, using two size-4 boxes and
		one size-8 box.
	The total waste is (4-2) + (4-3) + (8-5) = 6.

	Example 2:

	Input: packages = [2,3,5], boxes = [[1,4],[2,3],[3,4]]
	Output: -1
	Explanation: There is no box that the package of size 5 can fit in.

	Example 3:

	Input: packages = [3,5,8,10,11,12], boxes = [[12],[11,9],[10,5,14]]
	Output: 9
	Explanation: It is optimal to choose the third supplier, using two size-5 boxes,
		two size-10 boxes, and two size-14 boxes.
	The total waste is (5-3) + (5-5) + (10-8) + (10-10) + (14-11) + (14-12) = 9.

	Constraints:

	    n == packages.length
	    m == boxes.length
	    1 <= n <= 105
	    1 <= m <= 105
	    1 <= packages[i] <= 10^5
	    1 <= boxes[j].length <= 10^5
	    1 <= boxes[j][k] <= 10^5
	    sum(boxes[j].length) <= 10^5
	    The elements in boxes[j] are distinct.
 */
/*
 * Some intuition:
 *
 * 		Obviously we need to have check the availability of the boxes with each of the suppliers
 *
 * 		However, since we have 10^5 packages, and suppliers highest range is also 10^5 which is 'n' here
 *
 * 			Also, for each of the supplier the max box size is also 10^5
 *
 * 		So going by the standard way it will definitely cause TLE
 * 			as in total we have 10^5 suppliers and for each supplier we can have 10^5 box sizes
 *
 * 		The total different box sizes across all the suppliers is also 10^5 (sum(boxes[j].length) <= 10^5)
 *
 * 		-------
 *
 * 		Here we have to come up with an O(n * log n) solution
 *
 * 		-------
 *
 * 		Going over the greedily for each of the package we will look for the smallest box that can fit
 * 			that package (as we want to minimize the total wasted space)
 *
 * 	-------
 *
 * 	Approach:
 *
 * 		We can use Binary Search here
 *
 * 			Suppose we sort our packages (lowest to highest) and for each of the supplier we also sort
 * 				the boxes (smallest to the biggest)
 *
 * 			Finally for each of the box size, we can simply do a binary search
 *
 * 			Suppose we have our packages as: 2, 3, 5
 * 			Suppose our boxes is as follows: [3, 5]
 *
 * 				so for box of size 3, we can do a binary search in the package array
 * 					and we reach the index 1, and we will know that, we can put all the packages
 * 					starting from this index until the start
 *
 *  				We have to calculate the total waste:
 *  					since we have two packages here (2, 3), so the total required size is 5
 *
 *  				the size of both of these packages is less than or equal to box size 3
 *  					so we will require 2 boxes of size 3, to fit them properly
 *
 *  				Total waste is 6 - 5
 *
 *  			for the next box of size 5, when we do a binary search in the package array we will reach
 *  				the index 2
 *
 *  				and we put the package in that box
 *
 *  		-------
 *
 *  		In order to efficiently calculate, we will need a prefixSum
 *  			in that we will need a startRange and endRange of the packages to add them in a box
 *
 *  -------
 *
 *  Code:
 *
 *  	class Solution:
 *  		def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
 *  			packages.sort()
 *  			preSum = [0]
 *  			n = len(packages)
 *  			for p in packages:
 *  				preSum.append(preSum[-1] + p)
 *  			ans = sys.maxsize
 *  			for box in boxes:
 *  				box.sort()
 *  				if box[-1] < packages[-1]:  # if the biggest box is less than the biggest packages
 * 						continue
 * 					preIndex = 0
 * 					cost = 0
 * 					for size in box:
 * 						index = bisect_right(packages, size)
 * 						# total size the current box can handle
 * 						totalSize = preSum[index] - preSum[preIndex]
 * 						totalCount = index - preIndex  # total packages count the current box can handle
 * 						cost += size * totalCount - totalSize
 * 						if index == n:  # we have already covered all the packages
 * 							break
 * 						preIndex = index
 * 					ans = min(ans, cost)
 * 			return ans % 1000000007 if ans < sys.maxsize else -1
 *
 * 	-------
 *
 * 	Time:
 *
 * 		Sorting the packages: O(n*log n)
 *
 * 		for the boxes:
 * 			since the max size for each of the box by any supplier is 10^5
 * 			so the inner for loop is O(n)
 *
 * 			for each of the inner loop we have a binary search (another O(n*log n))
 */
class Solution {
	public int minWastedSpace(int[] packages, int[][] boxes) {
		Arrays.sort(packages);
		long inf = (long) 1e11, res = inf, mod = (long) 1e9 + 7, sumA = 0L;
		for (int pack : packages) {
			sumA += pack;
		}
		for (int[] box : boxes) {
			Arrays.sort(box);
			if (packages[packages.length - 1] > box[box.length - 1]) {
				continue;
			}
			long cost = 0, preIndex = 0, index;
			for (int size : box) {
				index = binarySearch(packages, size + 1);
				cost += size * (index - preIndex);
				preIndex = index;
			}
			res = Math.min(res, cost);
		}
		return res < inf ? (int) ((res - sumA) % mod) : -1;
	}

	private int binarySearch(int[] arr, int num) {
		int left = 0, right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
