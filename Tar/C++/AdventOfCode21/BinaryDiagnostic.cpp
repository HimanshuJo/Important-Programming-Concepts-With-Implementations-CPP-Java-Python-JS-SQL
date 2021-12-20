#include<iostream>
#include<vector>
#include<string>
#include<map>
#include<cmath>
using namespace std;
using ll=long long;

ll toDec_(string str){
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

ll toDec(string n)
{
	string num = n;
	ll dec_value = 0;
	ll base = 1;
	int len = num.length();
	for (int i = len - 1; i >= 0; i--) {
		if (num[i] == '1')
			dec_value += base;
		base = base * 2;
	}
	return dec_value;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n=1000;
	int toChk;
	vector<string>in(n);
	for(int i=0; i<n; ++i){
		cin>>in[i];
	}
	map<string, ll>mp;
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
	vector<string>temp;
	int counter=0;
	while(temp.size()!=1){
		for(int i=counter; i<toChk; ++i){
			if(temp.size()!=0){
				for(auto &vals: temp){
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
			}
			string ky1=to_string(i+1);
			ky1+="1";
			string ky2=to_string(i+1);
			ky2+="0";
			ll val1=mp[ky1];
			ll val2=mp[ky2];
			if(val1>val2){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='1'){
							temp.push_back(vals);
						}
					}
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='1'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}	
			} else if(val2>val1){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='0'){
							temp.push_back(vals);
						}
					}	
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='0'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}
			} else if(val1==val2){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='1'){
							temp.push_back(vals);
						}
					}
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='1'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}
			}
			mp.clear();
			if(temp.size()==1) break;
		}
		counter++;
	}
	ll ans1=toDec(temp[0]);
	temp.clear();
	counter=0;
	while(temp.size()!=1){
		for(int i=counter; i<toChk; ++i){
			if(temp.size()!=0){
				for(auto &vals: temp){
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
			}
			string ky1=to_string(i+1);
			ky1+="1";
			string ky2=to_string(i+1);
			ky2+="0";
			ll val1=mp[ky1];
			ll val2=mp[ky2];
			if(val1>val2){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='0'){
							temp.push_back(vals);
						}
					}
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='0'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}
			} else if(val2>val1){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='1'){
							temp.push_back(vals);
						}
					}	
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='1'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}
			} else if(val1==val2){
				if(temp.size()==0){
					for(auto &vals: in){
						if(vals[i]=='0'){
							temp.push_back(vals);
						}
					}
				} else{
					vector<string>nwTemp;
					for(auto &vals: temp){
						if(vals[i]=='0'){
							nwTemp.push_back(vals);
						}
					}
					temp.clear();
					temp=nwTemp;
				}
			}
			mp.clear();
			if(temp.size()==1) break;
		}
		counter++;
	}
	ll ans2=toDec(temp[0]);
	cout<<ans1*ans2<<endl;
}

