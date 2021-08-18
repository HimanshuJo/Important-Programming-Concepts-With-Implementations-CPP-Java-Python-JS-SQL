#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
    vector<int> runningSum(vector<int> nums){
        vector<int> res(nums.size());
        int n=nums.size();
        res[0]=nums[0];
        for (int i=1; i<n; ++i){
            res[i]=res[i-1]+nums[i];
        }
        for (auto &nums: res){
            cout<<nums<<" ";
        }
        return res;
    }
};

int main(){
    Solution obj;
    vector<int> nums={1,2,3,4};
    obj.runningSum(nums);
}