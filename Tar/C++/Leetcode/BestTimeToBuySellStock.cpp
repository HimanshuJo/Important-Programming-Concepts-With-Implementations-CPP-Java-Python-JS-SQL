#include<bits/stdc++.h>
using namespace std;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/
/*
Brute Force:

class Solution {
public:
    int maxProfit(vector<int>& prices) {
		int n=prices.size();
		int maxx=INT_MIN;
		for(int i=0; i<n-1; ++i){
			int currMx=INT_MIN;
			for(int j=i+1; j<n; ++j){
				if(prices[j]>prices[i]){
					int curr=prices[j]-prices[i];
					currMx=max(currMx, curr);
				}
			}
			maxx=max(maxx, currMx);
		}
        return maxx==INT_MIN?0:maxx;
    }
};
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
		int n=prices.size();
		int maxx=INT_MIN;
		int currMx=INT_MIN;
        int minn=INT_MAX;
		for(int i=0; i<n-1; ++i){
            minn=min(prices[i], minn);
			currMx=max(currMx, prices[i+1]-minn);
			maxx=max(currMx, maxx);
		}
        return maxx<=0?0:maxx;
    }
};