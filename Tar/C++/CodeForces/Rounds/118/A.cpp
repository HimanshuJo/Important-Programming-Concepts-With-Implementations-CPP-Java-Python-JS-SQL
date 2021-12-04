#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int x1, p1;
		cin>>x1>>p1;
		int x2, p2;
		cin>>x2>>p2;
		string frst=to_string(x1);
		string sec=to_string(x2);
		int l1=frst.length()+p1;
		int l2=sec.length()+p2;
		if(l1==l2){
			bool flag=false;
			int minn=min(frst.length(), sec.length());
			for(int i=0; i<minn; ++i){
				if(frst[i]-'0'>sec[i]-'0'){
					cout<<">\n";
					flag=true;
					break;
				} else if(frst[i]-'0'<sec[i]-'0'){
					cout<<"<\n";
					flag=true;
					break;
				}
				if(flag) break;
			}
			if(!flag){
				int maxx=max(frst.length(), sec.length());
				string maxStr=frst.length()>sec.length()?frst:sec;
				if(maxStr==frst){
					for(int i=minn; i<maxx; ++i){
						if(frst[i]-'0'>=1){
							cout<<">\n";
							flag=true;
							break;
						}
					}
				} else{
					for(int i=minn; i<maxx; ++i){
						if(sec[i]-'0'>=1){
							cout<<"<\n";
							flag=true;
							break;
						}
					}
				}
			}
			if(!flag)
				cout<<"=\n";
			continue;
		}
		if(l1<l2){
			cout<<"<\n";
			continue;
		}
		if(l1>l2){
			cout<<">\n";
			continue;
		}
	}
}
