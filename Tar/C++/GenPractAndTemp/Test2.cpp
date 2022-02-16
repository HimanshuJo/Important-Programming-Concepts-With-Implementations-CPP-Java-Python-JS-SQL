#include<iostream>
#include<vector>
using namespace std;

int dfs(vector<int>&a, vector<int>&b, int n, int idx, int curmin, int &minn){
	if(idx>=n) return 0;
	int ans1=0, ans2=0;
	for(int x=0; x<=n-1; ++x){
		for(int y=x+1; y<n; ++y){
			ans1+=((a[x]+a[y])*(a[x]+a[y]));
		}
	}
	for(int x=0; x<=n-1; ++x){
		for(int y=x+1; y<n; ++y){
			ans2+=((b[x]+b[y])*(b[x]+b[y]));
		}
	}
	int curmintmp1=ans1+ans2;
	vector<int>tempa=a;
	vector<int>tempb=b;
	swap(tempa[idx], tempb[idx]);
	int ans1_=0, ans2_=0;
	for(int x=0; x<=n-1; ++x){
		for(int y=x+1; y<n; ++y){
			ans1_+=((tempa[x]+tempa[y])*(tempa[x]+tempa[y]));
		}
	}
	for(int x=0; x<=n-1; ++x){
		for(int y=x+1; y<n; ++y){
			ans2_+=((tempb[x]+tempb[y])*(tempb[x]+tempb[y]));
		}
	}
	int curmintmp2=ans1_+ans2_;
	cout<<curmintmp1<<" "<<curmintmp2<<endl;
	minn=min(minn, min(curmintmp1, curmintmp2));
	cout<<"-------\n";
	curmin=min(dfs(a, b, n, idx+1, curmintmp1, minn), dfs(tempa, tempb, n, idx+1, curmintmp2, minn));
	return curmin;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vector<int>a(n), b(n);
		for(int i=0; i<n; ++i)
			cin>>a[i];
		for(int i=0; i<n; ++i)
			cin>>b[i];
		int minn=INT_MAX, curmin=0;
		dfs(a, b, n, 0, curmin, minn);
		cout<<minn<<"\n";
	}
}
