#include<iostream>
#include<vector>
#include<string>
#include<sstream>
#include<set>
using namespace std;
using ll=long long;

bool isValid(vector<vector<bool>>&vec){
	for(int i=0; i<5; ++i){
		bool flag=false;
		vector<bool>rw=vec[i];
		for(int x=0; x<5; ++x){
			if(!rw[x]){
				flag=true;
				break;
			}
		}
		if(!flag){
			return true;
		} else{
			flag=false;
			for(int x=0; x<5; ++x){
				if(!vec[x][i]){
					flag=true;
					break;
				}
			}
			if(!flag) return true;
		}
	}
	return false;
}

vector<string> splitString(string str, char delimiter) { 
	vector<string> internal; 
	stringstream ss(str); 
	string tok; 
	while(getline(ss, tok, delimiter)) { 
		internal.push_back(tok); 
	} 
	return internal;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	string order;
	cin>>order;
	vector<vector<vector<int>>>bingos(3, vector<vector<int>>(5, vector<int>(5)));
	vector<vector<vector<bool>>>binB(3, vector<vector<bool>>(5, vector<bool>(5, false)));
	vector<string>nwOrders=splitString(order, ',');
	for(int i=0; i<3; ++i){
		for(int x=0; x<5; ++x){
			for(int y=0; y<5; ++y){
				cin>>bingos[i][x][y];
			}
		}
	}
	vector<pair<int, int>>fnIdx;
	set<int>completed;
	//vector<int>fnNum;
	bool flag=false;
	for(string str: nwOrders){
		int vals=stoi(str);
		for(int i=0; i<bingos.size(); ++i){
			vector<vector<int>>curr=bingos[i];
			for(int x=0; x<5; ++x){
				for(int y=0; y<5; ++y){
					if(curr[x][y]==vals){
						binB[i][x][y]=true;
						if(isValid(binB[i])){
							//flag=true;
							fnIdx.push_back({i, vals});
							completed.insert(i);
							if(completed.size()==3){
							    flag=true;
							    break;
							}
							//fnNum.push_back(vals);
							//break;
						}
					}
				}
				if(flag){
				    break;
				}
			}
			if(flag) break;
		}
		if(flag) break;
	}
	for(auto &vals: fnIdx)
	    cout<<vals.first<<" "<<vals.second<<endl;
	cout<<endl;
	auto it=fnIdx.end();
	--it;
	vector<vector<int>>fn=bingos[(*it).first];
	vector<vector<bool>>fnB=binB[(*it).first];
	ll sum=0;
	for(int i=0; i<5; ++i){
		for(int j=0; j<5; ++j){
			if(fnB[i][j]==false){
				sum+=fn[i][j];
			}
		}
	}
	cout<<(sum*(*it).second)<<"\n";
}


