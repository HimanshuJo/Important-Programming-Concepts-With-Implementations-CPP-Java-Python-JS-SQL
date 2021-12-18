#include<iostream>
#include<vector>
#include<stack>
using namespace std;

class Solution {
public:

	vector<int> fndNxtSmLftInd(vector<int>&nums){
		stack<int>decStack;
		int n=nums.size();
		vector<int>res(n);
		for(int i=0; i<n; ++i){
			while(!decStack.empty()&&nums[decStack.top()]>nums[i]){
				decStack.pop();
			}
			if(decStack.empty()){
				res[i]=-1;
			} else{
				res[i]=decStack.top();
			}
			decStack.push(i);
		}
		return res;
	}

	vector<int> fndNxtSmRghtInd(vector<int>&nums){
		stack<int>decStack;
		int n=nums.size();
		vector<int>res(n);
		for(int i=n-1; i>=0; --i){
			while(!decStack.empty()&&nums[decStack.top()]>=nums[i]){
				decStack.pop();
			}
			if(decStack.empty()){
				res[i]=n;
			} else{
				res[i]=decStack.top();
			}
			decStack.push(i);
		}
		return res;
	}

	vector<int> fndNxtLargLftInd(vector<int>&nums){
		stack<int>incStack;
		int n=nums.size();
		vector<int>res(n);
		for(int i=0; i<n; ++i){
			while(!incStack.empty()&&nums[incStack.top()]<nums[i]){
				incStack.pop();
			}
			if(incStack.empty()){
				res[i]=-1;
			} else{
				res[i]=incStack.top();
			}
			incStack.push(i);
		}
		return res;
	}

	vector<int> fndNxtLargRghtInd(vector<int>&nums){
		stack<int>incStack;
		int n=nums.size();
		vector<int>res(n);
		for(int i=n-1; i>=0; --i){
			while(!incStack.empty()&&nums[incStack.top()]<=nums[i]){
				incStack.pop();
			}
			if(incStack.empty()){
				res[i]=n;
			} else{
				res[i]=incStack.top();
			}
			incStack.push(i);
		}
		return res;
	}


    long long subArrayRanges(vector<int>& nums) {
        long long res=0;
		vector<int>nxtSmLft=fndNxtSmLftInd(nums);
		vector<int>nxtSmRght=fndNxtSmRghtInd(nums);
		vector<int>nxtLargLft=fndNxtLargLftInd(nums);
		vector<int>nxtLargRght=fndNxtLargRghtInd(nums);
		int n=nums.size();
		for(int i=0; i<n; ++i){
			long long minLftCnt=(i-nxtSmLft[i])-1;
			long long minRghtCnt=(nxtSmRght[i]-i)-1;
			long long maxLftCnt=(i-nxtLargLft[i])-1;
			long long maxRghtCnt=(nxtLargRght[i]-i)-1;
			long long totalMinCnt=minLftCnt+minRghtCnt+(minLftCnt*minRghtCnt);
			long long totalMaxCnt=maxLftCnt+maxRghtCnt+(maxLftCnt*maxRghtCnt);
			res+=(totalMaxCnt-totalMinCnt)*nums[i];
		}
		return res;
    }
};

