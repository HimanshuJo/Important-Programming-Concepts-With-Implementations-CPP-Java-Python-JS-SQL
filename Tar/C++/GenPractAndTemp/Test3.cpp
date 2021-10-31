#include<bits/stdc++.h>
using namespace std;

vector<string> split(const string &s, char delim){
	vector<string>elems;
	stringstream ss(s);
	string item;
	while(getline(ss, item, delim))
		elems.push_back(item);
	return elems;
}

void printPowerSet(vector<int>&arr, int n){
	vector<string>list;
	for(int i=0; i<(1<<n); ++i){
		string subset="";
		for(int j=0; j<n; ++j){
			if((i&(1<<j))!=0)
				subset+=to_string(arr[j])+"|";
		}
		if(find(list.begin(), list.end(), subset)==list.end()){
			list.push_back(subset);
		}
	}
	for(string subset: list){
		vector<string>arr=split(subset, '|');
		for(string str: arr)
			cout<<str<<" ";
		cout<<endl;
	}
	cout<<list.size();
}

int main(){
	auto start=chrono::high_resolution_clock::now();
	vector<int>arr{10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2};
	int n=arr.size();
	printPowerSet(arr, n);
	auto end=chrono::high_resolution_clock::now();
	double time_taken =
	chrono::duration_cast<chrono::nanoseconds>(end - start).count();
	time_taken *= 1e-9;
	cout << "Time taken by program is : " << fixed
		<< time_taken << setprecision(9);
	cout << " sec" << endl;
}
