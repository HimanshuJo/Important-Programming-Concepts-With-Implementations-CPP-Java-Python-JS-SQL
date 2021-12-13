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
		for(int i=0; i<n; ++i){
			cin>>in[i];
		}
		//sort(in.begin(), in.end());
		ll res=0;
		int curr=0;
		int i=0;
		bool flag=false;
		while(true){
			int currPkg=k;
			while(currPkg--){	
				ll l=curr-in[i];
				cout<<l<<endl;	
				res+=abs(l);
				curr=in[i];
				i++;
				if(i>=n-1){
					flag=true;
					ll l_=curr-in[i];	
					res+=abs(l_);
					if(currPkg==0){
						ll r_=abs(0-curr);
						r_*=2;
						res+=r_;
					}
					break;
				}
			}
			if(flag) break;
			ll r=abs(0-curr);
			r*=2;
			res+=r;
			cout<<r<<endl;
			cout<<res<<endl;
			cout<<"-------\n";
		}
		cout<<res<<"\n";
	}
}

