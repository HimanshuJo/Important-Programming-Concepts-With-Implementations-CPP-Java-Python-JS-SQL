package com.essenbazar.segmentTree;

//Program for Segment Tree operations like construction, query and update
public class SegmentTree {
	int[] st; // array that will store segment tree nodes

	// constructor to construct segment tree from the given array.
	// This constructor allocates memory for the segment tree and calls
	// constructionSTUtil()
	// to fill the allocated memory
	SegmentTree(int[] arr, int n) {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int maxSize = 2 * (int) Math.pow(2, x) - 1; // Maximum size of the segment tree
		st = new int[maxSize];
		constructSTUtil(arr, 0, n - 1, 0);
	}

	// A recursive function that constructs Segment Tree for an array[ss..se]
	// si is index of the current node in the segment tree st

	int constructSTUtil(int[] arr, int ss, int se, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
		return st[si];
	}

	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	void updateValue(int[] arr, int n, int i, int newVal) {
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input");
			return;
		}
		int diff = newVal - arr[i];
		arr[i] = newVal;
		updateValueUtil(0, n - 1, i, diff, 0);
	}

	/*
	 * A recursive function to update the nodes which have the given index in their
	 * range. The following are the parameters st, si, ss and se are same as
	 * getSumUtil() i -> index of the element to be updated. This index is in the
	 * input array diff ->value to be added to all the nodes which have i in their
	 * range
	 */

	void updateValueUtil(int ss, int se, int i, int diff, int si) {
		if (i < ss || i > se) {
			return;
		}
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

	// Return the sum of the elements in a range from index qs (query start) to qe
	// (query end)
	// It mainly uses getSumUtil()

	int getSum(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	/*
	 * A recursive function to get the sum of the values in a given range of the
	 * array. The following are the parameters for this function
	 * 
	 * st -> Pointer to the segment tree si -> Index of the current node in the
	 * segment tree. Initially 0 is passed as root is always at index 0 ss & se ->
	 * starting and the ending indexes of the segment represented by the current
	 * node, i.e. st[si] qs & qe -> starting and ending indexes of the query range
	 */

	int getSumUtil(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && qe >= se) {
			return st[si];
		}
		if (se < qs || ss > qe) {
			return 0;
		}
		int mid = getMid(ss, se);
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);
		System.out.println(tree.getSum(n, 1, 3));
		tree.updateValue(arr, n, 1, 10);
		System.out.println(tree.getSum(n, 1, 3));
	}
}
