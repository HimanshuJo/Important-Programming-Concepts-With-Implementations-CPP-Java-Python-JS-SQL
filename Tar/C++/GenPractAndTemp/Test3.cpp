#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
using ll=long long;

ll gcd(ll A, ll B){
	if(B==0) return A;
	return gcd(B, A%B);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		vector<ll>in(3);
		ll minn=LONG_MAX;
		for(int i=0; i<3; ++i){
			cin>>in[i];
			if(in[i]<minn){
				minn=in[i];
			}
		}
		if(in[0]==in[1]&&in[1]==in[2]){
			cout<<"YES\n";
			continue;
		}
		if(in[0]==1&&in[1]==1){
			if(in[2]!=3){
				cout<<"NO\n";
				continue;
			} else{
				cout<<"YES\n";
				continue;
			}
		}
		if(in[1]==1&&in[2]==1){
			if(in[0]!=3){
				cout<<"NO\n";
				continue;
			} else{
				cout<<"YES\n";
				continue;
			}
		}
		int countZ=0;
		for(int i=0; i<3; ++i){
			if(in[i]==1){
				countZ++;
			}
		}
		if(countZ==2||countZ==1){
			cout<<"YES\n";
			continue;
		}
		if(in[0]==in[1]&&in[1]!=1){
			if(in[2]==1){
				cout<<"YES\n";
				continue;
			} else{
				cout<<"NO\n";
				continue;
			}
		}
		if(in[1]==in[2]&&in[2]!=1){
			if(in[0]==1){
				cout<<"YES\n";
				continue;
			} else{
				cout<<"NO\n";
				continue;
			}
		}
		if(in[0]==in[2]&&in[2]!=1){
			if(in[1]==1){
				cout<<"YES\n";
				continue;
			} else{
				cout<<"NO\n";
				continue;
			}
		}
		cout<<"gcd is: "<<gcd(gcd(in[0], in[1]), in[2])<<endl;
		cout<<"minn: "<<minn<<endl;
		if(gcd(gcd(in[0], in[1]), in[2])!=minn){
			cout<<"NO\n";
			continue;
		}
		cout<<"YES\n";
	}
}
