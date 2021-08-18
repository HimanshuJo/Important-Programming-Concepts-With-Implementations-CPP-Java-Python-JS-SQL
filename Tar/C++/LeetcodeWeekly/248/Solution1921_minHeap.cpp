#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int eliminateMaximum(vector<int> &dist, vector<int> &speed)
    {
        // min heap of ceil of time of arrivals of the monstors
        priority_queue<double, vector<double>, greater<double>> minArrivals;
        int ans = 0;
        for (int i = 0; i < dist.size(); ++i)
        {
            minArrivals.push(ceil((double)dist[i] / speed[i]));
        }
        int currTime = 0;
        while (!minArrivals.empty())
        {
            // Current time of arrival of the monster
            // has not reached yet
            if (currTime < minArrivals.top())
            {
                minArrivals.pop();
                ans++;
            }
            else
            {
                return ans;
            }
            currTime++;
        }
        return ans;
    }
};