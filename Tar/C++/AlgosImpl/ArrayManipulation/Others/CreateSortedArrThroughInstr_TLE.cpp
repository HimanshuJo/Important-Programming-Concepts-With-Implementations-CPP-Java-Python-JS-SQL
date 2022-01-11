/*
Given an integer array instructions, you are asked to create a sorted array from the elements 
in instructions. 

You start with an empty container nums. For each element from left to right in instructions, 
insert it into nums. 

The cost of each insertion is the minimum of the following:

    The number of elements currently in nums that are strictly less than instructions[i].
    The number of elements currently in nums that are strictly greater than instructions[i].

For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) 
(elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, 
return it modulo 10^9 + 7

Example 1:

Input: instructions = [1,5,6,2]
Output: 1
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
The total cost is 0 + 0 + 0 + 1 = 1.

Example 2:

Input: instructions = [1,2,3,6,5,4]
Output: 3
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
*/

#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int createSortedArray(vector<int>&instructions){
        int mod=1e9+7;
        vector<int>nums;
        int ans=0;
        vector<int>::iterator low, up;
        for (auto &ins: instructions){
            sort(nums.begin(), nums.end());
            low=lower_bound(nums.begin(), nums.end(), ins);
            up=upper_bound(nums.begin(), nums.end(), ins);
            int numsLThanIns=low-nums.begin();
            int numsBThanIns=nums.size()-(up-nums.begin());
            if (numsLThanIns>nums.size()-1){
                numsLThanIns=nums.size()-1;
            }
            if (numsBThanIns>nums.size()-1){
                numsBThanIns=nums.size()-1;
            }
            ans+=min(numsLThanIns, numsBThanIns);
            nums.push_back(ins);
        }
        cout<<ans%mod;
        return ans%mod;
    }
};

int main(){
    Solution obj;
    vector<int>instructions={1,2,3,6,5,4};
    obj.createSortedArray(instructions);
}