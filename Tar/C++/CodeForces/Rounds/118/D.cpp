#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;
using ll=long long;

int mod=998244353;

void genAllSubSeqUtil(vector<ll>&in, vector<vector<ll>>&res, vector<ll>subarr, int idx){
	if (idx == in.size())
	{
		int l = subarr.size(); 
		if (l != 0){
			res.push_back(subarr);
		}
	}
	else
	{
		genAllSubSeqUtil(in, res, subarr, idx+1); 
		subarr.push_back(in[idx]);
		genAllSubSeqUtil(in, res, subarr, idx+1);
	}
	return;
}

vector<vector<ll>> genAllSubSeq(vector<ll>&in){
	vector<ll>subarr;
	vector<vector<ll>>res;
	genAllSubSeqUtil(in, res, subarr, 0);
	return res;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vector<ll>in(n);
		for(int i=0; i<n; ++i){
			cin>>in[i];
		}
		vector<vector<ll>>allSubseq=genAllSubSeq(in);
		ll ans=0;
		for(auto &vals: allSubseq){
			vector<ll>curr=vals;
			sort(curr.begin(), curr.end());
			int msngNum=0;
			for(int i=0; i<5e5; ++i){
				auto it=find(curr.begin(), curr.end(), i);
				if(it==curr.end()){
					msngNum=i;
					break;
				}
			}
			bool flag=false;
			//cout<<"Minng Num: "<<msngNum<<endl;
			ll toChk=curr[curr.size()-1];
			if(abs(toChk-msngNum)>1) flag=true;
			//if(!flag) cout<<" valid ";
			//cout<<"\n-------\n";
			if(!flag) ans++;
		}
		cout<<ans<<"\n";
	}
}

