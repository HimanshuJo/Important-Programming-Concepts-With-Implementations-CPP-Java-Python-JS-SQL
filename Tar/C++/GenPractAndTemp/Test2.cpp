#include<iostream>
#include<vector>
#include<cstring>
using namespace std;

int numWaysThreeContiguousPartsEqSum(vector<int>&arr, int sz){
	int sum=0;
	for(auto &vals: arr){
		sum+=vals;
	}
	if(sum%3!=0) return 0;
	int prtsSm=sum/3;
	vector<int>cntprtsSmArr(sz, 0);
	int tmpSm=0;
	for(int i=sz-1; i>=0; --i){
		tmpSm+=arr[i];
		if(tmpSm==prtsSm){
			cntprtsSmArr[i]=1;
		}
	}
	for(int i=sz-2; i>=0; --i){
		cntprtsSmArr[i]+=cntprtsSmArr[i+1];
	}
	int tmpSm_=0, ans=0;
	for(int i=0; i+2<sz; ++i){
		tmpSm_+=arr[i];
		if(tmpSm_==prtsSm){
			ans+=cntprtsSmArr[i+2];
		}
	}
	return ans;
}

int main(){
	vector<int>arr{3, 3, 3, 3, 3, 3};
	int sz=arr.size();
	int ans=numWaysThreeContiguousPartsEqSum(arr, sz);
	cout<<ans<<endl;
}