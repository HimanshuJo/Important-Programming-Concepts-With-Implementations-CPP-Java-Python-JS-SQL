
package com.essenbazar.pyramidForm;

/*

Pyramid form (increasing then decreasing) consecutive array using reduce operations

We have N (where N > 2) stones of various heights laid out in a row.

Task is to make a pyramid from given array of stones.
In a pyramid, height of the stones start from 1, increase by 1, until it reaches some value x,
then decreases by 1 until it reaches 1 again i.e.
the stones should be 1, 2, 3, 4…x – 1, x, x – 1, x – 2 … 1.

All other stones not part of the pyramid should have a height 0.
We cannot move any of the stones from their current position, however, by paying a fee of 1,
we can reduce the heights of the stones. We wish to minimize the cost of building a pyramid.

Output the minimum cost to build this pyramid.
Examples:

Input  : 1 2 3 4 2 1
Output : 4
The best pyramid that can be formed in this case is:
1 2 3 2 1 0
The cost is thus:
(4 - 2) + (2 - 1) + (1 - 0) = 4

*/

/*

How to find the maximum height for each position

    We can start by setting the maximum of height of a temple at position i to be H(i)
        where H(i) is the height of the stone at that point

    We can then move to the left
        If the height of the stone at this point is less than H(i)-1
            we can set the maximum height now to be H(i-1)-1

        Similarly in this way we can find the maximum height of each position

    -------

    If H(i) is the height of a stone at a position i then
        maxHeight(i)=Minimum(H(i),i,maxHeight(i-1))

        This can be explained as follows

            The maximum possible height cannot exceed H(i) as we can only decrease the height of the stone
                not increase

            The maximum possible height cannot exceed i, as the pyramid has to start from a height 1
            
            The maximum possible height cannot exceed the maximum possible height of the stone before it -1
                as the stones have to increase by 1 at each step


*/

class GFG {

// Returns minimum cost to form a pyramid
	static int minPyramidCost(int arr[], int N) {

		// Store the maximum possible pyramid height
		int left[] = new int[N];
		int right[] = new int[N];

		// Maximum height at start is 1
		left[0] = Math.min(arr[0], 1);

		// For each position calculate maximum height
		for (int i = 1; i < N; ++i)
			left[i] = Math.min(arr[i], Math.min(left[i - 1] + 1, i + 1));

		// Maximum height at end is 1
		right[N - 1] = Math.min(arr[N - 1], 1);

		// For each position calculate maximum height
		for (int i = N - 2; i >= 0; --i)
			right[i] = Math.min(arr[i], Math.min(right[i + 1] + 1, N - i));

		// Find minimum possible among
		// calculated values
		int tot[] = new int[N];
		for (int i = 0; i < N; ++i)
			tot[i] = Math.min(right[i], left[i]);

		// Find maximum height of pyramid
		int max_ind = 0;
		for (int i = 0; i < N; ++i)
			if (tot[i] > tot[max_ind])
				max_ind = i;

		// Calculate cost of this pyramid
		int cost = 0;
		int height = tot[max_ind];

		// Calculate cost of left half
		for (int x = max_ind; x >= 0; --x) {
			cost += arr[x] - height;
			if (height > 0)
				--height;
		}

		// Calculate cost of right half
		height = tot[max_ind] - 1;
		for (int x = max_ind + 1; x < N; ++x) {
			cost += arr[x] - height;
			if (height > 0)
				--height;
		}
		return cost;
	}

// Driver code
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 2, 1 };
		int N = arr.length;

		System.out.print(minPyramidCost(arr, N));
	}
}

// This code is contributed by chitranayal
