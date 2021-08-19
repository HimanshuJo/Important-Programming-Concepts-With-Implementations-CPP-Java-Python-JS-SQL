#include<bits/stdc++.h>
using namespace std;

int singleNumber(vector<int>nums){
    int ones=0, twos=0, threes=0;
    for (int i=0; i<nums.size(); ++i){
        twos|=ones&nums[i];
        ones^=nums[i];
        threes=ones&twos;
        ones&=~threes;
        twos&=~threes;
    }
    return ones;
}

int main(){
    vector<int>nums={1,1,1,2,3,3,3};
    cout<<singleNumber(nums);
}