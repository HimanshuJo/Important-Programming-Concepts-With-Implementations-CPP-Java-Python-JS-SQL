#include<iostream>
#include<vector>
#include<cstring>
#include<map>
using namespace std;

int numWaysThreeContiguousPartsEqSum(vector<int>&arr, int sz){
	map<int, vector<vector<int>>>mp;
	vector<vector<vector<int>>>vec;
	vector<int>temp1, prev1;
	vector<int>temp2, prev2;
	for(int i=0; i<=sz-3; ++i){
		temp1=prev1;
		temp1.push_back(arr[i]);
		prev1=temp1;
		for(int j=i+1; j<=sz-2; ++j){
			mp[i].push_back(temp1);
			temp2=prev2;
			temp2.push_back(arr[j]);
			prev2=temp2;
			mp[i].push_back(temp2);
			vector<int>temp3;
			for(int k=j+1; k<sz; ++k){
				temp3.push_back(arr[k]);
			}
			mp[i].push_back(temp3);
		}
		temp2.clear();
		prev2.clear();
	}
	for(auto &entries: mp){
		vector<vector<int>>adr1;
		for(auto &vecEntries: entries.second){
			vector<int>temp;
			for(auto &vals: vecEntries){
				temp.push_back(vals);
			}
			adr1.push_back(temp);
		}
		vec.push_back(adr1);
	}
	int ans=0;
	for(auto &vecEntries: vec){
		int counter=0, sm=0;
		bool flag=false;
		for(auto &entries: vecEntries){
			if(counter!=0){
				int tempsm=0;
				for(auto &vals: entries){
					tempsm+=vals;
				}
				if(tempsm!=sm){
					flag=true;
				}
			} else{
				for(auto &vals: entries){
					sm+=vals;
				}
			}
			counter++;
			if(counter==3){
				if(!flag) ans++;
				sm=0, counter=0;
				flag=false;
			}
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