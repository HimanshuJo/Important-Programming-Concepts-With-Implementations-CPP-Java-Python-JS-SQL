#include<iostream>
#include<vector>
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
		for(int i=0; i<n; ++i){
			cin>>in[i];
		}
		int ans=0;
		vector<int>toChk=in;
		while(true){
			int curr=toChk[n-1];
			vector<int>left;
			vector<int>right;
			vector<int>equal;
			vector<int>currComb;
			for(int i=0; i<n; ++i){
				if(toChk[i]<curr){
					left.push_back(toChk[i]);
				} else if(toChk[i]>curr){
					right.push_back(toChk[i]);
				} else if(toChk[i]==curr&&i!=n-1){
					equal.push_back(toChk[i]);
				}
			}
			for(auto &vals: left){
				currComb.push_back(vals);
			}
			currComb.push_back(curr);
			for(auto &vals: equal){
				currComb.push_back(vals);
			}
			for(auto &vals: right){
				currComb.push_back(vals);
			}
			for(auto &vals: toChk)
				cout<<vals<<" ";
			cout<<endl;
			for(auto &vals: currComb)
				cout<<vals<<" ";
			cout<<endl;
			cout<<"-------\n";
			if(currComb==toChk){
				break;
			} else{
				toChk=currComb;
				ans++;
			}
		}
		cout<<ans<<"\n";
	}
}
