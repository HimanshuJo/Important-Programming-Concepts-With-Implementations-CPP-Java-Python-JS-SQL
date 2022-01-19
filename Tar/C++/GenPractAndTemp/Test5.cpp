#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

struct custComp{
    const bool operator()(const pair<int, pair<int, int>>A, const pair<int, pair<int, int>>B) {
        return A.first==B.first?A.second.first>B.second.first:A.first<B.first;
    }
};

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		string in;
		cin>>in;
		int len=in.length();
		if(in.length()==1){
			cout<<in<<"\n";
			continue;
		}
		bool flag=false;
		for(int i=len-1; i>0; --i){
			string temp;
			int sm=in[i-1]-'0'+in[i]-'0';
			temp=to_string(sm);
			cout<<"temp "<<temp<<endl;
			if(temp.size()>=2){
				string s1="";
				for(int j=0; j<i-1; ++j){
					s1+=in[j];
				}
				cout<<"s1 "<<s1<<endl;
				s1+=temp;
				for(int j=i+1; j<len; ++j){
					s1+=in[j];
				}
				cout<<s1<<"\n";
				flag=true;
				break;
			}
		}
		if(flag) continue;
		int sm=in[0]-'0'+in[1]-'0';
		string temp=to_string(sm);
		for(int i=2; i<len; ++i){
			temp+=in[i];
		}
		cout<<temp<<"\n";
		continue;
	}
}

