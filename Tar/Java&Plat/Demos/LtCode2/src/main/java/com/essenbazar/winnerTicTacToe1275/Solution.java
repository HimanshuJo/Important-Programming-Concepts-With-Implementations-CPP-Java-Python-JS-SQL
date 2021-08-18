package com.essenbazar.winnerTicTacToe1275;

import java.util.Arrays;

class Solution {
	public String tictactoe(int[][] moves) {
		int i = 0;
		int[][] res = new int[3][3];
		for (int[] arr : res) {
			Arrays.fill(arr, -1);
		}
		for (int[] arr : moves) {
			int x = arr[0];
			int y = arr[1];
			if (i % 2 == 0) {
				res[x][y] = 1;
			} else {
				res[x][y] = 0;
			}
			++i;
		}
		for (int[] arr : res)
			System.out.println(Arrays.toString(arr));
		int countR0One = 0;
		int countR0Zero = 0;
		int countR1One = 0;
		int countR1Zero = 0;
		int countR2One = 0;
		int countR2Zero = 0;
		int col0Count0 = 0;
		int col1Count0 = 0;
		int col2Count0 = 0;
		int col0Count1 = 0;
		int col1Count1 = 0;
		int col2Count1 = 0;
		int dLeft0 = 0;
		int dRight0 = 0;
		int dLeft1 = 0;
		int dRight1 = 0;
		int x = 0;
		int y = res.length - 1;
		int ii = 0;
		for (int[] arr : res) {
			int x0 = arr[0];
			int x1 = arr[1];
			int x2 = arr[2];
			if (x0 == 1) {
				col0Count1++;
			} else if (x0 == 0) {
				col0Count0++;
			}
			if (x1 == 1) {
				col1Count1++;
			} else if (x1 == 0) {
				col1Count0++;
			}
			if (x2 == 1) {
				col2Count1++;
			} else if (x2 == 0) {
				col2Count0++;
			}
			if (arr[x] == 1) {
				dLeft1++;
				if (x < 2) {
					++x;
				}
			} else if (arr[x] == 0) {
				dLeft0++;
				if (x < 2) {
					++x;
				}
			}
			if (arr[y] == 1) {
				dRight1++;
				if (y > 0) {
					--y;
				}
			} else if (arr[y] == 0) {
				dRight0++;
				if (y > 0) {
					--y;
				}
			}
			for (int num : arr) {
				if (ii == 0) {
					if (num == 1) {
						countR0One++;
					} else if (num == 0) {
						countR0Zero++;
					}
				} else if (ii == 1) {
					if (num == 1) {
						countR1One++;
					} else if (num == 0) {
						countR1Zero++;
					}
				} else if (ii == 2) {
					if (num == 1) {
						countR2One++;
					} else if (num == 0) {
						countR2Zero++;
					}
				}
			}
			++ii;
		}
		if (countR0One == 3 || countR1One == 3 || countR2One == 3 || col0Count1 == 3 || col1Count1 == 3
				|| col2Count1 == 3 || dLeft1 == 3 || dRight1 == 3) {
			return "A";
		} else if (countR0Zero == 3 || countR1Zero == 3 || countR2Zero == 3 || col0Count0 == 3 || col1Count0 == 3
				|| col2Count0 == 3 || dLeft0 == 3 || dRight0 == 3) {
			return "B";
		} else {
			for (int[] arr : res) {
				for (int num : arr) {
					if (num == -1) {
						return "Pending";
					}
				}
			}
		}
		return "Draw";
	}
}