#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimumDifference(vector<int> &nums, int k)
    {
        sort(nums.begin(), nums.end());
        int strt=nums[0];
        int end=nums[k-1];
        int diff1=end-strt;
        int strt2=nums.size()-k;
        int end2=nums[nums.size()-1];
        int diff2=end2-strt2;
        cout<<diff1<<endl;
        cout<<diff2<<endl;
        return 1;
    }
};

int main()
{
    Solution obj;
    vector<int> nums = 
    {93614,91956,83384,14321,29824,89095,96047,25770,39895};
    int k = 3;
    obj.minimumDifference(nums, k);
}