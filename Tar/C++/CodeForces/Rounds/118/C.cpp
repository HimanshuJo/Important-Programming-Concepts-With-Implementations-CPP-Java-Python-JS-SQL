#include<vector>
#include<iostream>
#include<set>
using namespace std;
using ll=long long;

int main(){
	int t;
	cin>>t;
	while(t--){
		ll n, h;
		cin>>n>>h;
		vector<ll>in(n);
		for(int i=0; i<n; ++i){
			cin>>in[i];
		}
		ll ans=0;
		ll left=1, right=1e18;
		ll prev=0;
		while(left<=right){
			ll mid=left+(right-left)/2;
			ll currSm=0;
			ll prev=0;
			for(auto &vals: in){
				ll curr=vals;
				if(curr>prev){
					currSm+=mid;
					prev=(curr+mid)-1;
				} else{
					currSm+=(abs(prev-((curr+mid)-1)));
					prev=(curr+mid)-1;
				}
			}
			if(currSm>=h){
				ans=mid;
				right=mid-1;
			}
			else{
				left=mid+1;
			}
		}
		cout<<ans<<"\n";
	}
}
