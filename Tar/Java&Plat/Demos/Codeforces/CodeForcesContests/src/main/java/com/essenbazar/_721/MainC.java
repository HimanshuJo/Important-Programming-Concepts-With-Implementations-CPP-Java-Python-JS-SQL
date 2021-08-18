package com.essenbazar._721;

/*
 * You are given an array a of n integers. Define the cost of some array t

as follows:

cost(t)=∑x∈set(t)last(x)−first(x),

where set(t) is the set of all values in t without repetitions, first(x), and last(x) are 
the indices of the first and last occurrence of x in t, respectively. 
In other words, we compute the distance between the first and last occurrences for 
each distinct element and sum them up.

You need to split the array a into k consecutive segments such that each element of a 
belongs to exactly one segment and the sum of the cost of individual segments is minimum.

Examples
Input

7 2
1 6 6 4 6 6 6

Output

3

Input

7 4
5 5 5 5 2 3 3

Output
Copy

1

Note

In the first example, we can divide the array into [1,6,6,4] and [6,6,6]. 
Cost of [1,6,6,4] will be (1−1)+(3−2)+(4−4)=1 and cost of [6,6,6] will be 3−1=2. 
Total cost would be 1+2=3

In the second example, divide the array into [5,5],[5],[5,2,3]
and [3]. Total Cost would be 1+0+0+0=1
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		long[] dp = new long[n + 1];
		Arrays.fill(dp, Long.MAX_VALUE / 2);
		dp[0] = 0;
		int[] prev = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			prev[i] = map.getOrDefault(arr[i], -1);
			map.put(arr[i], i);
		}
		System.out.println(map.toString());
		System.out.println(Arrays.toString(prev));
		System.out.println("-------");
		for (int i = 0; i < k; ++i) {
			long[] dp_ = new long[n + 1];
			Arrays.fill(dp_, Long.MAX_VALUE / 2);
			SegTree st = new SegTree(dp);
			for (int j = 1; j <= n; ++j) {
				int pr = prev[j - 1];
				if (pr != -1) {
					st.add(0, pr + 1, j - 1 - pr);
				}
				dp_[j] = st.min(0, j);
				System.out.println(Arrays.toString(dp_));
			}
			System.out.println("-------");
			dp = dp_;
		}
		System.out.println(dp[n]);
		sc.close();
	}
}

class SegTree {
	public final int M, H, N, LH;
	public long[] mins;
	public long[] plus;
	public static final long I = Long.MAX_VALUE / 4; // I+plus<long

	public SegTree(int n) {
		N = n;
		M = Integer.highestOneBit(Math.max(n - 1, 1)) << 2;
		H = M >>> 1;
		LH = Integer.numberOfTrailingZeros(H);
		mins = new long[M];
		plus = new long[H];
	}

	public SegTree(long[] a) {
		this(a.length);
		for (int i = 0; i < N; i++) {
			mins[H + i] = a[i];
		}
		Arrays.fill(mins, H + N, M, I);
		for (int i = H - 1; i >= 1; i--)
			propagate(i);
	}

	private void push1(int cur) {
		if (plus[cur] == 0)
			return;
		int L = cur * 2, R = L + 1;
		mins[L] += plus[cur];
		mins[R] += plus[cur];
		if (L < H) {
			plus[L] += plus[cur];
			plus[R] += plus[cur];
		}
		plus[cur] = 0;
	}

	private void propagate(int i) {
		mins[i] = Math.min(mins[2 * i], mins[2 * i + 1]) + plus[i];
	}

	private void add1(int cur, long v) {
		mins[cur] += v;
		if (cur < H) {
			plus[cur] += v;
		}
	}

	private void push(int l, int r) {
		for (int i = LH; i >= 1; i--) {
			if (l >>> i << i != l)
				push1(l >>> i);
			if (r >>> i << i != r)
				push1(r >>> i);
		}
	}

	public void add(int l, int r, long v) {
		if (l >= r)
			return;
		l += H;
		r += H;
		push(l, r);
		for (int ll = l, rr = r; ll < rr; ll >>>= 1, rr >>>= 1) {
			if ((ll & 1) == 1)
				add1(ll++, v);
			if ((rr & 1) == 1)
				add1(--rr, v);
		}
		for (int i = 1; i <= LH; i++) {
			if (l >>> i << i != l)
				propagate(l >>> i);
			if (r >>> i << i != r)
				propagate(r >>> i);
		}
	}

	public long min(int l, int r) {
		long min = I;
		if (l >= r)
			return min;
		l += H;
		r += H;
		push(l, r);
		for (; l < r; l >>>= 1, r >>>= 1) {
			if ((l & 1) == 1)
				min = Math.min(min, mins[l++]);
			if ((r & 1) == 1)
				min = Math.min(min, mins[--r]);
		}
		return min;
	}

	public int firstle(int l, long v) {
		if (l >= H)
			return -1;
		int cur = H + l;
		for (int i = 1, j = Integer.numberOfTrailingZeros(H) - 1; i <= cur; j--) {
			push1(i);
			i = i * 2 | cur >>> j & 1;
		}
		while (true) {
			push1(cur);
			if (mins[cur] <= v) {
				if (cur >= H)
					return cur - H;
				cur = 2 * cur;
			} else {
				cur++;
				if ((cur & cur - 1) == 0)
					return -1;
				cur = cur >>> Integer.numberOfTrailingZeros(cur);
			}
		}
	}

	public int lastle(int l, long v) {
		if (l < 0)
			return -1;
		int cur = H + l;
		for (int i = 1, j = Integer.numberOfTrailingZeros(H) - 1; i <= cur; j--) {
			push1(i);
			i = i * 2 | cur >>> j & 1;
		}
		while (true) {
			push1(cur);
			if (mins[cur] <= v) {
				if (cur >= H)
					return cur - H;
				cur = 2 * cur + 1;
			} else {
				if ((cur & cur - 1) == 0)
					return -1;
				cur = cur >>> Integer.numberOfTrailingZeros(cur);
				cur--;
			}
		}
	}

	public long[] toArray() {
		return toArray(1, 0, H, new long[H]);
	}

	private long[] toArray(int cur, int l, int r, long[] ret) {
		if (r - l == 1) {
			ret[cur - H] = mins[cur];
		} else {
			toArray(2 * cur, l, l + r >>> 1, ret);
			toArray(2 * cur + 1, l + r >>> 1, r, ret);
			for (int i = l; i < r; i++)
				ret[i] += plus[cur];
		}
		return ret;
	}
}
