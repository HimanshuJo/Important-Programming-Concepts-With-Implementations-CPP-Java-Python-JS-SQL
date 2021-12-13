#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
using ll=long long;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n, k;
		cin>>n>>k;
		vector<int>in(n);
		ll sum_pos=0, sum_neg=0;
		for(int i=0; i<n; ++i){
			cin>>in[i];
			if(in[i]>0) sum_pos++;
			if(in[i]<0) sum_neg++;
		}
		sort(in.begin(), in.end());
		int last_neg=-1;
		for(int i=0; i<n; ++i){
			if(in[i]<0){
				last_neg=i;
			}
		}
		ll dist=0;
		ll ind=n-1;
		while(ind>=0&&in[ind]>0){
			dist+=2*in[ind];
			ind-=k;
		}
		ind=0;
		while(ind<n&&in[ind]<0){
			dist+=2*abs(in[ind]);
			ind+=k;
		}
		dist-=max(abs(in[0]), abs(in[n-1]));
		cout<<dist<<"\n";
	}
}
