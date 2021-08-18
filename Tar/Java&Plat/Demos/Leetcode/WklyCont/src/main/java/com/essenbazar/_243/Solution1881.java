package com.essenbazar._243;

/*
 * You are given a very large integer n, represented as a string,​​​​​​ and an integer digit x.
 * The digits in n and the digit x are in the inclusive range [1, 9], and n may represent a negative number.

	You want to maximize n's numerical value by inserting x anywhere in the decimal representation of n​​​​​​.
	You cannot insert x to the left of the negative sign.

	    For example, if n = 73 and x = 6, it would be best to insert it between 7 and 3, making n = 763.
	    If n = -55 and x = 2, it would be best to insert it before the first 5, making n = -255.

	Return a string representing the maximum value of n​​​​​​ after the insertion.
 */

class Solution {

	public boolean isMin(int n, String s) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); ++i) {
			if (Character.getNumericValue(s.charAt(i)) < min) {
				min = Character.getNumericValue(s.charAt(i));
			}
		}
		return n <= min;
	}

	public String maxValue(String n, int x) {
		int bigNumIndex = 0;
		int smallNum = 0;
		int min = Integer.MAX_VALUE;
		StringBuilder res = new StringBuilder();
		if (!n.contains("-")) {
			for (int i = 0; i < n.length(); ++i) {
				if (Character.getNumericValue(n.charAt(i)) < x) {
					bigNumIndex = i;
					break;
				}
			}
			if (bigNumIndex != 0) {
				for (int i = 0; i < bigNumIndex; ++i) {
					res.append(n.charAt(i));
				}
				res.append(String.valueOf(x));
				for (int i = bigNumIndex; i < n.length(); ++i) {
					res.append(n.charAt(i));
				}
			} else {
				if (isMin(x, n)) {
					for (int i = 0; i < n.length(); ++i) {
						res.append(n.charAt(i));
					}
					res.append(String.valueOf(x));
				} else {
					res.append(String.valueOf(x));
					for (int i = 0; i < n.length(); ++i) {
						res.append(n.charAt(i));
					}
				}
			}
		} else {
			for (int i = 1; i < n.length(); ++i) {
				if (Character.getNumericValue(n.charAt(i)) < min) {
					min = Character.getNumericValue(n.charAt(i));
					smallNum = min;
				}
			}
			if (x < smallNum) {
				res.append("-");
				res.append(String.valueOf(x));
				for (int i = 1; i < n.length(); ++i) {
					res.append(n.charAt(i));
				}
			} else {
				int tempBig = 0;
				int max_ = Integer.MIN_VALUE;
				for (int i = 1; i < n.length(); ++i) {
					if (Character.getNumericValue(n.charAt(i)) > max_) {
						max_ = Character.getNumericValue(n.charAt(i));
						tempBig = max_;
					}
				}
				if (x >= tempBig) {
					res.append("-");
					for (int i = 1; i < n.length(); ++i) {
						res.append(n.charAt(i));
					}
					res.append(String.valueOf(x));
				} else {
					int globalMin = Integer.MAX_VALUE;
					int globalMinIndex = Integer.MAX_VALUE;
					for (int i = 1; i < n.length(); ++i) {
						if (Character.getNumericValue(n.charAt(i)) > x) {
							min = Character.getNumericValue(n.charAt(i));
							if (Math.abs(x - min) <= globalMin && i < globalMinIndex) {
								smallNum = min;
								globalMinIndex = i;
							}
						}
					}
					res.append("-");
					for (int i = 1; i < globalMinIndex; ++i) {
						res.append(n.charAt(i));
					}
					res.append(String.valueOf(x));
					for (int i = globalMinIndex; i < n.length(); ++i) {
						res.append(n.charAt(i));
					}
				}
			}
		}
		return res.toString();
	}

	class SolutionOpt {
		public String maxValue(String n, int x) {
			if (n.startsWith("-")) {
				for (int i = 1; i < n.length(); i++) {
					if (n.charAt(i) - '0' > x) {
						return n.substring(0, i) + x + n.substring(i);
					}
				}
				return n + x;
			} else {
				for (int i = 0; i < n.length(); i++) {
					if (n.charAt(i) - '0' < x) {
						return n.substring(0, i) + x + n.substring(i);
					}
				}
				return n + x;
			}
		}
	}
}