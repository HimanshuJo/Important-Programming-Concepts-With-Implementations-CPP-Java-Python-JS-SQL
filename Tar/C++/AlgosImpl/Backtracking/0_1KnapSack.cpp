#include<bits/stdc++.h>
using ll = long long;
#define rep1(i, n) for (int i = 0; i <= n; ++i)
#define rep2(w, W) for (ll w = 0; w <= W; ++w)
using namespace std;

// Utility function that returns maximum of two integers
ll max(ll a, ll b) {
	return (a > b) ? a : b;
}

// Function that prints items which are put in a knapsack of capacity W
void printKnapSack(ll W, ll wt[], ll val[], ll n) {
	int i;
	ll w;
	ll dp[(int)(n + 1)][(int) (W + 1)];
	// Bottom up DP
	rep1(i, n) {
		rep2(w, W) {
			if (i == 0 || w == 0) {
				dp[i][(int)w] = 0;
			} else if (wt[i - 1] <= w) {
				dp[i][(int)w] = max(val[i - 1] + dp[i - 1][(int) (w - wt[i - 1])], dp[i - 1][(int)w]);
			} else {
				dp[i][(int)w] = dp[i - 1][(int)w];
			}
		}
	}
	// Storing the result of Knapsack
	ll res = dp[(int)n][(int)W];
	cout << res << "\n";
	w = W;
	for (i = n; i > 0 && res > 0; --i) {
		// either the result comes from the top
		// dp[i - 1][(int)w] or from 
		// (val[i - 1] + dp[i - 1][(int)w - wt[i - 1]])
		// If it comes from the later one that means the item is included
		if (res == dp[i - 1][w]) {
			continue;
		} else {
			cout << wt[i - 1] << " ";
			res = res - val[i - 1];
			w = w - wt[i - 1];
		}
	}
}

int main() {
	ll val[] = {1000000000L, 1000000000L, 1000000000L, 1000000000L, 1000000000L};
	ll wt[] = {1L, 1L, 1L, 1L, 1L};
	ll W = 5;
	ll n = 5;
	printKnapSack(W, wt, val, n);
	return 0;
}