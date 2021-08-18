package com.essenbazar._344;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * Blake is the boss of Kris, however, this doesn't spoil their friendship. 
 * They often gather at the bar to talk about intriguing problems about maximizing some values. 
 * This time the problem is really special.
 * You are given an array a of length n. The characteristic of this array is the value 
 * c = i=1 to n sum(ai * i)
 * the sum of the products of the values ai by i. One may perform the following operation exactly once: 
 * pick some element of the array and move to any position. 
 * 
 * In particular, it's allowed to move the element to the beginning or to the end of the array. 
 * Also, it's allowed to put it back to the initial position. 
 * The goal is to get the array with the maximum possible value of characteristic.
 * Examples

	Input
	
	4
	4 3 2 5
	
	Output
	
	39
	
	Input
	
	5
	1 1 2 7 1
	
	Output
	
	49
	
	Input
	
	3
	1 1 2
	
	Output
	
	9
	
	Note
	
	In the first sample, one may pick the first element and place it before the third (before 5). 
	Thus, the answer will be 3·1 + 2·2 + 4·3 + 5·4 = 39.
	
	In the second sample, one may pick the fifth element of the array and place it before the third. 
	The answer will be 1·1 + 1·2 + 1·3 + 2·4 + 7·5 = 49.
 */
/*
 * The operation that has been described in the statement, is cyclic shift of some sub-array
 * 
 * We can solve this problem by left-cyclic shift and right-cyclic shift
 * 
 * Let's define ans' = sum(i=1 to n) ai * i as answer before(or without) cyclic shifts
 * 	delta ans = ans - ans'  -> difference between answer after cyclic shift and before cyclic shift
 * 
 * For the left cyclic shift:
 * 	Δl, r = (al·r + al+1·l + ... + ar·(r - 1)) - (al·l + al+1·(l + 1) + ... + ar·r)
 * 		  = al·(r - l) - (al+1 + al+2 + ... + ar)
 * 
 * For the right cyclic shift:
 * 	Δ'l, r = (al·(l+1) + al+1·(l + 2) + ... + ar·l) + (al·l + al + 1·(l + 1) + ... + ar·r)
 *         = (al + al + 1 + ... + ar - 1) + ar·(l - r)
 *         
 *  You can find this values with complexity , using prefix sums, .
 *  Let's try to rewrite previous formulas:

	For left cyclic shift: Δl, r = (al·r - sumr) + (suml - al·l)

	For right cyclic shift: Δ'l, r = (ar·l - suml - 1) + (sumr - 1 - ar·r)
	
	Rest we can solve the problem using Convex Hull
	
	Time: O(n log (n))
 */

public class MainE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n + 1];
		long[] sum = new long[n + 1];
		long res = 0;
		for (int i = 1; i <= n; ++i) {
			a[i] = sc.nextLong();
			sum[i] = sum[i - 1] + a[i];
			res += a[i] * i;
		}
		long max = 0;
		DynamicConvexHullM dcm = new DynamicConvexHullM();
		for (int r = 1; r <= n; ++r) {
			dcm.addLine(r, -sum[r - 1]);
		}
		for (int r = 1; r <= n; ++r) {
			max = Math.max(max, dcm.getMax(a[r]) + sum[r - 1] - a[r] * r);
		}
		dcm = new DynamicConvexHullM();
		for (int l = 1; l <= n; ++l) {
			dcm.addLine(l, -sum[l]);
		}
		for (int l = 1; l <= n; ++l) {
			max = Math.max(max, dcm.getMax(a[l]) + sum[l] - a[l] * l);
		}
		System.out.println(res + max);
		sc.close();
	}
}

class DynamicConvexHullM {
	public TreeSet<Line> slopeHull = new TreeSet<>(new Comparator<Line>() {
		public int compare(Line o1, Line o2) {
			return Long.compare(o1.slope, o2.slope);
		}
	});
	public TreeSet<Line> intervalHull = new TreeSet<>(new Comparator<Line>() {
		public int compare(Line o1, Line o2) {
			return Double.compare(o1.xLeft, o2.xLeft);
		}
	});

	public void addLine(long slope, long intercept) {
		Line line = new Line(Double.NEGATIVE_INFINITY, slope, intercept);
		if (slopeHull.isEmpty()) {
			slopeHull.add(line);
			intervalHull.add(line);
			return;
		}
		Line rightLine = slopeHull.higher(line);
		double xIntersect;
		if (rightLine != null) {
			xIntersect = 1.0 * (rightLine.intercept - intercept) / (slope - rightLine.slope);
			if (xIntersect <= rightLine.xLeft) {
				return;
			}
		}
		while (rightLine != null) {
			Line rightRightLine = slopeHull.higher(rightLine);
			xIntersect = 1.0 * (rightLine.intercept - intercept) / (slope - rightLine.slope);
			slopeHull.remove(rightLine);
			intervalHull.remove(rightLine);
			if ((rightRightLine == null) || (rightRightLine.xLeft > xIntersect)) {
				rightLine.xLeft = xIntersect;
				slopeHull.add(rightLine);
				intervalHull.add(rightLine);
				break;
			}
			rightLine = rightRightLine;
		}
		Line leftLine = slopeHull.floor(line);
		if ((leftLine != null) && (leftLine.slope == slope)) {
			slopeHull.remove(leftLine);
			intervalHull.remove(leftLine);
			leftLine = slopeHull.lower(line);
		}
		xIntersect = Double.NEGATIVE_INFINITY;
		while (leftLine != null) {
			xIntersect = 1.0 * (intercept - leftLine.intercept) / (leftLine.slope - slope);
			if (xIntersect > leftLine.xLeft) {
				break;
			}
			slopeHull.remove(leftLine);
			intervalHull.remove(leftLine);
			leftLine = slopeHull.lower(line);
			xIntersect = Double.NEGATIVE_INFINITY;
		}
		line.xLeft = xIntersect;
		slopeHull.add(line);
		intervalHull.add(line);
	}

	public void add(long slope, long intercept) {
		addLine(slope, intercept);
	}

	public long getMax(long x) {
		Line line = intervalHull.floor(new Line(x, 0, 0));
		return (line.slope * x + line.intercept);
	}

	public class Line {
		double xLeft;
		long slope;
		long intercept;

		Line(double xLeft, long slope, long intercept) {
			this.xLeft = xLeft;
			this.slope = slope;
			this.intercept = intercept;
		}
	}
}
