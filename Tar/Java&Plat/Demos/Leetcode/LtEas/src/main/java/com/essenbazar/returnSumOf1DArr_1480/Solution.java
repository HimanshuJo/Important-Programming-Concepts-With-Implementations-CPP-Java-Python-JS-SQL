package com.essenbazar.returnSumOf1DArr_1480;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

 */

/*
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
*/

class Solution {

    public int[] runningSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp_res = 0;
            temp_res += nums[i];
            for (int j = i - 1; j >= 0; j--) {
                temp_res += nums[j];
            }
            list.add(temp_res);
        }
        Collections.reverse(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
