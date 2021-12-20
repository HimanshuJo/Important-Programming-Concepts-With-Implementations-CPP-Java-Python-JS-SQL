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
	int oxGenRt=0;
	int co2GenRt=0;
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
	vector<string>temp;
	for(int i=0; i<toChk; ++i){
		if(temp.size()==1) break;
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
		int val1=mp[ky1];
		int val2=mp[ky2];
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
			cout<<"***---***\n";
			for(auto &vals: temp)
				cout<<vals<<" ";
			cout<<endl;
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
	}
	cout<<"-------\n";
	cout<<temp[0]<<endl;
	ll ans1=toDec(temp[0]);
	temp.clear();
	for(int i=0; i<toChk; ++i){
		if(temp.size()==1) break;
		if(temp.size()!=0){
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
		}
		string ky1=to_string(i+1);
		ky1+="1";
		string ky2=to_string(i+1);
		ky2+="0";
		int val1=mp[ky1];
		int val2=mp[ky2];
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
	}
	ll ans2=toDec(temp[0]);
	cout<<ans1*ans2<<endl;
}

