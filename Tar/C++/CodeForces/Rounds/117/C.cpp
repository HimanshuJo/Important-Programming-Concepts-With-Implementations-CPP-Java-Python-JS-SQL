#include<iostream>
#include<vector>
#include<cmath>
using ll=long long;
using namespace std;

long long sumDigits(long long n)
{
	return n * (n + 1) / 2;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		ll k, x;
		cin>>k>>x;
		ll fnCount=2*k-1;
		ll low=0, high=fnCount;
		ll ans=fnCount;
		while(low<=high){
			ll mid=low+(high-low)/2;
			ll temp_=mid;
			ll toSmDig=temp_;
			if(mid<=k){
				temp_=sumDigits(mid);
			} else {
				toSmDig=k*2-1-mid;
				temp_=k*k-sumDigits(toSmDig);
			}
			if(temp_>=x){
				ans=mid;
				high=mid-1;
			} else{
				low=mid+1;
			}
		}
		cout<<ans<<"\n";
	}
}

