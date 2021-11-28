#include<iostream>
#include<vector>
#include<set>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n, a, b;
		cin>>n>>a>>b;
		vector<int>res(n);
		res[0]=a;
		int temp=n;
		set<int>seen;
		seen.insert(a);
		for(int i=1; i<n/2; ++i){
			auto it=seen.find(temp);
			if(it==seen.end()&&temp!=b){
				seen.insert(temp);
				res[i]=temp--;
			}
			else{
				while(true){
					temp--;
					auto it_=seen.find(temp);
					if(it_==seen.end()) break;
				}
				res[i]=temp;
				seen.insert(temp);
			}
		}
//		for(auto &vals: res){
//			cout<<vals<<" ";
//		}
		res[n-1]=b;
		seen.insert(b);
//		cout<<"\n***---***\n";
//		for(int x: seen)
//			cout<<x<<" ";
//		cout<<endl;
		for(int i=n/2; i<n-1; ++i){
			auto it=seen.find(temp);
			if(it==seen.end()){
				seen.insert(temp);
				res[i]=temp--;
			} else{
				while(true){
					temp--;
					auto it_=seen.find(temp);
					if(it_==seen.end()) break;
				}
				res[i]=temp;
				seen.insert(temp);
			}
		}
//		cout<<"\n-------\n";
//		for(auto &vals: res){
//			cout<<vals<<" ";
//		}
//		cout<<endl;
		bool flag=false;
		for(int i=0; i<n/2; ++i){
			if(res[i]<a){
				flag=true;
				break;
			}
		}
		for(int i=n/2; i<n; ++i){
			if(res[i]>b){
				flag=true;
				break;
			}
		}
		if(flag){
			cout<<"-1\n";
		} else{
			for(auto &vals: res){
				cout<<vals<<" ";
			}
			cout<<"\n";
		}
	}
}
