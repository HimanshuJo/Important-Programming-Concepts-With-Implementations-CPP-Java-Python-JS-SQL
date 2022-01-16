// 2136. Earliest Possible Day of Full Bloom
/*
You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom. 
Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer arrays plantTime and growTime, of length n each:

plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work on planting exactly one seed.
You do not have to work on planting the same seed on consecutive days, but the planting of a seed is not complete until you have worked plantTime[i] days on planting it in total.
growTime[i] is the number of full days it takes the ith seed to grow after being completely planted. After the last day of its growth, the flower blooms and stays bloomed forever.
From the beginning of day 0, you can plant the seeds in any order.

Return the earliest possible day where all seeds are blooming.

E.g.

Input: plantTime = [1,2,3,2], growTime = [2,1,2,1]
Output: 9
Explanation: The grayed out pots represent planting days, colored pots represent growing days, and the flower represents the day it blooms.
One optimal way is:
On day 1, plant the 0th seed. The seed grows for 2 full days and blooms on day 4.
On days 0 and 3, plant the 1st seed. The seed grows for 1 full day and blooms on day 5.
On days 2, 4, and 5, plant the 2nd seed. The seed grows for 2 full days and blooms on day 8.
On days 6 and 7, plant the 3rd seed. The seed grows for 1 full day and blooms on day 9.
Thus, on day 9, all the seeds are blooming.
*/
/*
Solution 2:

class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        int n = plantTime.size();
        // growTime larger first
        vector<pair<int, int>> times(n);
        for (int i = 0; i < n; i++) {
            times[i].first = growTime[i];
            times[i].second = plantTime[i];
        }
        sort(times.rbegin(), times.rend());
        int tot = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
        	// endTime=max(pi+gi, pi+pj+gj)
            tot = max(tot, cur + times[i].second + times[i].first);
            cur += times[i].second;
        }
        return tot;
    }
};
*/

struct custComp{
	const bool operator()(const pair<int, int>A, const pair<int, int>B){
		return(A.second==B.second?A.first<B.first:A.second<B.second);
	}
};


class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
		vector<pair<int, int>>fB;
		int psz=plantTime.size();
		for(int i=0; i<psz; ++i){
			fB.push_back({plantTime[i], growTime[i]});
		}
		sort(fB.begin(), fB.end(), custComp());
		int ptime=-1;
		int res=0;
		for(auto &vals: fB){
			// if the leading time for all processed flowers can cover the grow time of the current flower.
            res=max(res, vals.second)+vals.first;
		}
		return res;
    }
};
