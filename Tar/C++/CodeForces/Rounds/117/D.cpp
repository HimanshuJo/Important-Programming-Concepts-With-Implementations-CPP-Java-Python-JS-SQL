#include<vector>
#include<iostream>
using ll=long long;
using namespace std;

bool solve(long long a,long long b,long long x) {
	if(a>b) swap(a, b);
	if (x>b || !a) return false;
	if ((b-x)%a==0) return true;
	return solve(a, b%a, x);
}

int main(){
	int t;
	cin>>t;
	while(t--){
		ll a, b, x;
		cin>>a>>b>>x;
		cout<<((solve(a, b, x))==1?"YES":"NO")<<"\n";
	}
}


