/* Brute Force:

#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;

int calMx(vector<int>&in){
	set<int>tmp;
	for(auto &vals: in){
		tmp.insert(vals);
	}
	int x=0;
	for(auto &vals: tmp){
		if(vals!=x) return x;
		x++;
	}
	return tmp.size();
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vector<int>in(n);
		int currMx=-1;
		for(int i=0; i<n; ++i){
			cin>>in[i];
		}
		if(in.size()==1){
			cout<<1<<"\n";
			if(in[0]==0){
				cout<<1<<"\n";
				continue;
			} else{
				cout<<0<<"\n";
				continue;
			}
		}
		vector<int>mexSuff(n);
		mexSuff[n-1]=in[n-1]==0?1:0;
		for(int i=n-2; i>=0; --i){
			vector<int>curr;
			for(int x=i; x<n; ++x){
				curr.push_back(in[x]);
			}
			int mexx=calMx(curr);
			mexSuff[i]=mexx;
		}
		vector<int>res;
		for(int i=0; i<n; ++i){
			int currMx=mexSuff[i];
			vector<int>tmp_;
			for(int j=i; j<n; ++j){
				tmp_.push_back(in[j]);
				int nwMex=calMx(tmp_);
				if(currMx==nwMex){
					res.push_back(currMx);
					i=j;
					break;
				}
			}
		}
		cout<<res.size()<<"\n";
		for(auto &vals: res)
			cout<<vals<<" ";
		cout<<"\n";
	}
}
*/

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		int arr[n];
		vector<int>vec[n+1];
		for(int i=0; i<n; ++i){
			cin>>arr[i];
		}
		for(int i=n-1; i>=0; --i){
			vec[arr[i]].push_back(i);
		}
		cout<<"\n-------\n";
		for(int i=0; i<n; ++i){
			cout<<i<<" : ";
			for(int num: vec[i]){
				cout<<num<<" ";
			}
			cout<<"\n";
		}
		cout<<"\n-------\n";
		int idx=0;
		vector<int>ans;
		while(idx!=n){
			int mxIdx=idx;
			for(int i=0; i<n; ++i){
				while(vec[i].size()>0&&vec[i].back()<idx){
					vec[i].pop_back();
				}
				if(vec[i].size()>0){
					mxIdx=max(mxIdx, vec[i].back());
				} else{
					ans.push_back(i);
					// one greater than the least index of the prev vec 
					// which still has values
					idx=mxIdx+1;
					break;
				}
			}
		}
		cout<<ans.size()<<"\n";
		for(auto &vals: ans){
			cout<<vals<<" ";
		}
		cout<<"\n";
	}
}
