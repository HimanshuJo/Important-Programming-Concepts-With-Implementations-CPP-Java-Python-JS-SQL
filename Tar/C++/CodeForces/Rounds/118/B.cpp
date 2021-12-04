#include<iostream>
#include<vector>
#include<map>
#include<cmath>
#include<set>
#include<algorithm>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vector<int>in(n);
		vector<int>evnNms;
		map<int, int>mp;
		for(int i=0; i<n; ++i){
			cin>>in[i];
			if(in[i]%2==0){
				evnNms.push_back(in[i]);
			}
			mp[in[i]]++;
		}
		vector<pair<int, int>>res;
		set<pair<int, int>>seen;
		int lm=floor(n/2);
		sort(in.begin(), in.end());
		sort(evnNms.begin(), evnNms.end());
		int end_=evnNms.size()-1;
		bool flag=false;
		for(int i=0; i<evnNms.size(); ++i){
			pair<int, int>curr={evnNms[end_], evnNms[i]};
			int toChk=evnNms[end_]%evnNms[i];
			if(mp.find(toChk)==mp.end()&&seen.find({curr})==seen.end()&&evnNms[end_]!=evnNms[i]){
				res.push_back(curr);
				seen.insert(curr);
				lm--;
			}
			if(lm==0){
				flag=true;
				break;
			} 
		}
		if(!flag){
			if(end_>0){
				end_--;
				while(end_!=0){
					for(int i=0; i<end_; ++i){
						pair<int, int>curr={evnNms[end_], evnNms[i]};
						int toChk=evnNms[end_]%evnNms[i];
						if(mp.find(toChk)==mp.end()&&seen.find({curr})==seen.end()&&evnNms[end_]!=evnNms[i]){
							res.push_back(curr);
							seen.insert(curr);
							lm--;
						}
						if(lm==0){
							flag=true;
							break;
						}
						end_--;
					}
					if(flag||end_==0) break;
				}
			}
		}
		if(!flag){
			int start=0;
			while(lm){
				for(int i=start+1; i<in.size(); ++i){
					pair<int, int>curr={in[i], in[0]};
					int toChk=in[i]%in[0];
					if(mp.find(toChk)==mp.end()&&seen.find({curr})==seen.end()&&in[i]!=in[0]){
						res.push_back(curr);
						seen.insert(curr);
						lm--;
						if(lm==0) break;
					}
				}
				if(lm==0) break;
			}
		}
		for(auto &vals: res){
			cout<<vals.first<<" "<<vals.second<<endl;
		}
	}
}

