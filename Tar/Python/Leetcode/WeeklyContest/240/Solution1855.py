'''
1855. Maximum Distance Between a Pair of Values

You are given two non-increasing 0-indexed integer arrays nums1
and nums2.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, 
is valid if both i <= j and nums1[i] <= nums2[j].
The distance of the pair is j - i.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.


Example 1:

Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).
Example 2:

Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).
Example 3:

Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
Output: 2
Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
The maximum distance is 2 with pair (2,4).
 

Constraints:

1 <= nums1.length, nums2.length <= 10^5
1 <= nums1[i], nums2[j] <= 10^5
Both nums1 and nums2 are non-increasing.

TLE:

class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        vector<pair<int, int>>comb1;
        vector<pair<int, int>>comb2;
        int sz1=nums1.size(), sz2=nums2.size();
        for(int i=0; i<sz1; ++i){
            comb1.push_back({nums1[i], i});
        }
        for(int i=0; i<sz2; ++i){
            comb2.push_back({nums2[i], i});
        }
        sort(comb1.begin(), comb1.end());
        sort(comb2.begin(), comb2.end(), greater<>());
        int res=INT_MIN;
        for(auto &vals: comb1){
            for(auto &vals_: comb2){
                if(vals.first>vals_.first) break;
                if(vals.first<=vals_.first){
                    if(vals.second<=vals_.second){
                        res=max(res, vals_.second-vals.second);
                    }
                }
            }
        }
        return res==INT_MIN?0:res;
    }
};

class Solution {
public:
    int maxDistance(vector<int>& n1, vector<int>& n2) {
        int i = 0, j = 0, res = 0;
        while (i < n1.size() && j < n2.size())
            if (n1[i] > n2[j])
                ++i;
            else
                res = max(res, j++ - i);
        return res;
    }
};
'''

def maxDistance(self, A, B):
    res = i = 0
    for j, b in enumerate(B):
        while i < len(A) and A[i] > b:
            i += 1
        if i == len(A): break
        res = max(res, j - i)
    return res