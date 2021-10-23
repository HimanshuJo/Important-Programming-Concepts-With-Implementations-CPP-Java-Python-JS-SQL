#include<bits/stdc++.h>
#include<array>
using namespace std;
/*
BF
class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        set<pair<int, int>>st;
        for(auto &mine: mines){
            st.insert({mine[0], mine[1]});
        }
        int ans=0;
        for(int r=0; r<n; ++r)
            for(int c=0; c<n; ++c){
                int k=0;
                while(k<=r&&k<=c&&r<n-k&&c<n-k&&
                    st.find({r-k, c})==st.end()&&
                    st.find({r+k, c})==st.end()&&
                    st.find({r, c-k})==st.end()&&
                    st.find({r, c+k})==st.end()){
                    ++k;
                }
                ans=max(ans, k);
            }
        return ans;
    }
};
*/
const int N=501;
class Solution {
public:

    int minEle(array<array<int, N>, N>&dp, int count, int i, int j){
        return dp[i][j]<count?dp[i][j]:count;
    }

    int maxEle(array<array<int, N>, N>&dp, int count, int i, int j){
        return dp[i][j]>count?dp[i][j]:count;
    }

    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        set<pair<int, int>>st;
        array<array<int, N>, N>dp;
        for(auto &mine: mines){
            st.insert({mine[0], mine[1]});
        }
        int ans=0, count;
        for(int i=0; i<n; ++i){
            count=0;
            for(int j=0; j<n; ++j){
                count=st.find({i, j})!=st.end()?0:++count;
                dp[i][j]=count;
            }
            count=0;
            for(int j=n-1; j>=0; --j){
                count=st.find({i, j})!=st.end()?0:++count;
                dp[i][j]=minEle(dp, count, i, j);
            }
        }
        for(int i=0; i<n; ++i){
            count=0;
            for(int j=0; j<n; ++j){
                count=st.find({j, i})!=st.end()?0:++count;
                dp[j][i]=minEle(dp, count, j, i);
            }
            count=0;
            for(int j=n-1; j>=0; --j){
                count=st.find({j, i})!=st.end()?0:++count;
                dp[j][i]=minEle(dp, count, j, i);
                ans=maxEle(dp, ans, j, i);
            }
        }
        return ans;
    }
};