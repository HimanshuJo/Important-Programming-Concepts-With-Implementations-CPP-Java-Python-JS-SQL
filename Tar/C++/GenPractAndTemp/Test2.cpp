#include<bits/stdc++.h>
using namespace std;

void genAllSubsutil(vector<int>&arr, set<vector<int>>&res, vector<int>&subset, int index){
	res.insert(subset);
	for(int i=index; i<arr.size(); ++i){
		subset.push_back(arr[i]);
		genAllSubsutil(arr, res, subset, i+1);
		subset.pop_back();
	}
	return;
}

set<vector<int>> genAllSubs(vector<int>&arr){
	set<vector<int>>res;
	vector<int>subset;
	genAllSubsutil(arr, res, subset, 0);
	return res;
}

int main(){
	auto start=chrono::high_resolution_clock::now();
	vector<int>arr{10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2};
	set<vector<int>>allSubs=genAllSubs(arr);
	for(auto &vals: allSubs){
		for(auto &val: vals){
			cout<<val<<" ";
		}
		cout<<endl;
	}
	auto end=chrono::high_resolution_clock::now();
	double time_taken=chrono::duration_cast<chrono::nanoseconds>(end-start).count();
	time_taken*=1e-9;
	cout<<"Time: "<<fixed<<time_taken<<setprecision(9);
	cout<<" sec "<<endl;
	cout<<allSubs.size();
}

