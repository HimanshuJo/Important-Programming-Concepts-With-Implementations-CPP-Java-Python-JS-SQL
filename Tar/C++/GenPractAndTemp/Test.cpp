#include<iostream>
#include<vector>
#include<set>
using namespace std;

int binarySearch(vector<int>&in, int left, int right, int first){
	if(left<right){
		int mid=(left+right)/2;
		if(in[mid]!=mid+first){
			return (binarySearch(in, left, mid, first));
		} else{
			return (binarySearch(in, mid+1, right, first));
		}
	}
	return left+first;
}

int smallestMissingNumber(vector<int>&in, int n){
	if(in[0]!=0) return 0;
	if(in[n-1]==n-1) return n;
	int first=in[0], left=0, right=n-1;
	return (binarySearch(in, left, right, first));
}

int main(){
	vector<int>in{0, 1, 2, 2, 2, 3, 7};
	int n=in.size();
	int ans=smallestMissingNumber(in, n);
	cout<<ans<<endl;
}