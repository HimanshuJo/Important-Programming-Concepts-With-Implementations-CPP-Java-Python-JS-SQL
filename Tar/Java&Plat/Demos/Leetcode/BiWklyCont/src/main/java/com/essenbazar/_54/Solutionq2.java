package com.essenbazar._54;

public class Solutionq2 {

	public int chalkReplacer(int[] chalk, int k) {
		int sum = 0;
		for (int i = 0; i < chalk.length; ++i) {
			sum += chalk[i];
			k -= chalk[i];
			if (k < 0) {
				return i;
			}
		}
		k %= sum;
		for (int i = 0; i < chalk.length; ++i) {
			k -= chalk[i];
			if (k < 0) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solutionq2 obj = new Solutionq2();
		// int[][] nums = {{1, 2, 3}, {4, 5, 6}};
		// int[] arr = {1, 2, 3, 4, 5};
		System.out.println(obj);
	}

}
