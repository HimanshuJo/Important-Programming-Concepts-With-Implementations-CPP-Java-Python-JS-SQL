/*
Given weights and values of n items, put these items in a knapsack of capacity W 
to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which 
represent values and weights associated with n items respectively. 

Also given an integer W which represents knapsack capacity, find out the maximum value 
subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
*/

#include <bits/stdc++.h>
using namespace std;

int knapSackRec(int W, int wt[], int val[], int i, int** dp)
{
	if (i < 0)
		return 0;
	if (dp[i][W] != -1)
		return dp[i][W];
	if (wt[i] > W) {
		dp[i][W] = knapSackRec(W, wt, val, i - 1, dp);
		return dp[i][W];
	}
	else {
		dp[i][W] = max(val[i] + knapSackRec(W - wt[i], wt, val, i - 1, dp), 
			       knapSackRec(W, wt, val, i - 1, dp));
		return dp[i][W];
	}
}

int knapSack(int W, int wt[], int val[], int n)
{
	// double pointer to declare the
	// table dynamically
	int** dp;
	dp = new int*[n];
	for (int i = 0; i < n; i++)
		dp[i] = new int[W + 1];
	for (int i = 0; i < n; i++)
		for (int j = 0; j < W + 1; j++)
			dp[i][j] = -1;
	return knapSackRec(W, wt, val, n - 1, dp);
}

int main()
{
	int val[] = { 60, 100, 120 };
	int wt[] = { 10, 20, 30 };
	int W = 50;
	int n = sizeof(val) / sizeof(val[0]);
	cout << knapSack(W, wt, val, n);
	return 0;
}
