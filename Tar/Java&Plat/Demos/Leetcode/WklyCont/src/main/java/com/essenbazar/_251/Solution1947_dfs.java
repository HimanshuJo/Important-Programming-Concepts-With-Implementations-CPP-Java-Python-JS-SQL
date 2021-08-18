package com.essenbazar._251;

class Solution {
	int n, m;

	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		n = students[0].length;
		m = students.length;

		int[][] score = new int[m][m];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < m; j++)
				for (int k = 0; k < n; k++)
					score[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;

		int[][] dp = new int[m + 1][2 << m];
		return solve(0, 0, dp, score);
	}

	public int solve(int index, int mentorState, int[][] dp, int[][] scores) {
		if (index == m) {
			return 0;
		}

		if (dp[index][mentorState] > 0)
			return dp[index][mentorState];

		int score = 0;
		for (int i = 0; i < m; i++) {
			if (((mentorState >> i) & 1) == 0) {
				score = Math.max(score, scores[index][i] + solve(index + 1, mentorState | (1 << i), dp, scores));
			}
		}

		return dp[index][mentorState] = score;
	}
}