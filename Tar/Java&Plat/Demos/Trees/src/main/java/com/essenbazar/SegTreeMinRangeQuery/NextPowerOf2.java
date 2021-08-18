package com.essenbazar.SegTreeMinRangeQuery;

public class NextPowerOf2 {
	int nextPowerOf2(int n) {
		int count = 0;
		// First n in the below
		// condition is for the
		// case where n is 0
		if (n > 0 && (n & (n - 1)) == 0)
			return n;
		while (n != 0) {
			n >>= 1;
			count += 1;
		}
		return 1 << count;
	}
}
