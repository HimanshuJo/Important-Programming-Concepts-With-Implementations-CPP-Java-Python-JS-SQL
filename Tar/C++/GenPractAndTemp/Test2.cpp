#include<iostream>
#include<vector>
#include<string>
#include<map>
#include<cmath>
using namespace std;
using ll=long long;

ll toDec(string str){
	int n=str.length();
	ll ans=0;
	int cnt=1;
	for(int i=0; i<n; ++i){
		ll temp=(pow(2, n-cnt))*(str[i]-'0');
		ans+=temp;
		cnt++;
	}
	return ans;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n=12;
	int toChk;
	vector<string>in(n);
	for(int i=0; i<n; ++i){
		cin>>in[i];
	}
	map<string, int>mp;
	for(auto &vals: in){
		string curr=vals;
		toChk=curr.length();
		for(int i=0; i<curr.length(); ++i){
			int tmp=i+1;
			string ky=to_string(tmp);
			if(curr[i]=='1'){
				ky+="1";
				mp[ky]++;
			} else{
				int tmp=i+1;
				ky+="0";
				mp[ky]++;
			}
		}
	}
	string curr="";
	for(int i=0; i<toChk; ++i){
		string ky1=to_string(i+1);
		ky1+="1";
		string ky2=to_string(i+1);
		ky2+="0";
		int val1=mp[ky1];
		int val2=mp[ky2];
		if(val1>val2){
			curr+="1";
		} else{
			curr+="0";
		}
	}
	ll ans1=toDec(curr);
	string nxt="";
	for(int i=0; i<toChk; ++i){
		if(curr[i]=='1'){
			nxt+="0";
		} else nxt+="1";
	}
	cout<<"-------\n";
	ll ans2=toDec(nxt);
	cout<<ans1*ans2<<endl;
	cout<<"-------\n";
	cout<<curr<<endl;
	cout<<nxt<<endl;
	cout<<"-------\n";
	for(auto &entries: mp){
		cout<<entries.first<<" "<<entries.second<<endl;
	}
}

