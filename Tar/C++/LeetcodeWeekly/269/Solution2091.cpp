#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
		int n=nums.size();
        int hfLen=n/2;
		int minInd=0, maxInd=0;
		int minn=INT_MAX, maxx=INT_MIN;
		for(int i=0; i<n; ++i){
			if(nums[i]<minn){
				minn=nums[i];
				minInd=i;
			}
			if(nums[i]>maxx){
				maxx=nums[i];
				maxInd=i;
			}
		}
		int ans=0;
		int maxbt=max(minInd, maxInd);
        int tmpminbt=min(minInd, maxInd);
		if(maxbt<=hfLen){
			return maxbt+1;
		} else{
            if(minInd<hfLen&&maxInd>=hfLen||(minInd>=hfLen&&maxInd<hfLen)){
                int minbt=min(minInd, maxInd);
                ans+=(minbt+1);
                ans+=(n-maxbt);   
            } else if(minInd>=hfLen&&maxInd>=hfLen){
                int minBt=min(minInd, maxInd);
                ans+=(n-minBt);
            }
		}
		return (min(ans, min(maxbt+1, (n-tmpminbt))));
    }
};

int main(){}

