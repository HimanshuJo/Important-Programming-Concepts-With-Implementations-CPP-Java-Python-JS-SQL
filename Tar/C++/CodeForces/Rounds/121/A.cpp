#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		sort(s.begin(), s.end());
		cout<<s<<"\n";
	}
}
