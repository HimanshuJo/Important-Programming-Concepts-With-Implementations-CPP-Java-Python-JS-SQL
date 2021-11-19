#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class Solution{
public:
	int minimizedMaximum(int n, vector<int>&arr){
		int left=1, right=100000;
		while(left<right){
			int mid=left+(right-left)/2;
			int sum=0;
			for(auto &vals: arr){
				sum+=(vals+mid-1)/mid;
			}
			if(sum>n){
				left=mid+1;
			} else{
				right=mid;
			}
		}
		return left;
	}

	int BinarySearch(int left, int right, vector<int>&arr, vector<int>&res, const int n){
		res.push_back(left);
		if(left>=right) return left;
		int mid=left+(right-left)/2;
		int sum=0;
		for(auto &vals: arr){
			sum+=(vals+mid-1)/mid;
		}
		if(sum>n) BinarySearch(mid+1, right, arr, res, n);
		else BinarySearch(left, mid, arr, res, n);
		return left;
	}

	int minimizedMaximum2(int n, vector<int>&arr){
		int left=1, right=100000;
		vector<int>res;
		int ans=BinarySearch(left, right, arr, res, n);
		return res[res.size()-1];
	}
};

int main(){}