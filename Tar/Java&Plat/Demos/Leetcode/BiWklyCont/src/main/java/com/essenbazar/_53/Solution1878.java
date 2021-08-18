package com.essenbazar._53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1878 {
	public int[] getBiggestThree(int[][] a) {
		int n = a.length, m = a[0].length;
		Set<Integer> all = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				all.add(a[i][j]);
				for (int k = 1; j + 2 * k < m && i - k >= 0 && i + k < n; k++) {
					int s = 0;
					for (int l = 0; l < k; l++) {
						s += a[i - l][j + l] + a[i - k + l][j + k + l] + a[i + l][j + 2 * k - l]
								+ a[i + k - l][j + k - l];
					}
					all.add(s);
				}
			}
		}
		List<Integer> li = new ArrayList<>(all);
		Collections.sort(li);
		int[] b = new int[Math.min(li.size(), 3)];
		for (int i = 0; i < b.length; i++) {
			b[i] = li.get(li.size() - 1 - i);
		}
		return b;
	}
}
