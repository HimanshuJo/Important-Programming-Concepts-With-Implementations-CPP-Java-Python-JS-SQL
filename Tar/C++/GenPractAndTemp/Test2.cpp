// C++ implementation of the approach
#include <bits/stdc++.h>
using namespace std;

int main()
{
	vector<vector<int>>vec(4, vector<int>(4));
	int cnt=1;
	for(int i=0; i<4; ++i){
		for(int j=0; j<4; ++j){
			vec[i][j]=cnt++;
		}
	}
	for(int i=0; i<4; ++i){
		for(int j=0; j<4; ++j){
			cout<<vec[i][j]<<" ";
		}
		cout<<endl;
	}
	int n=vec.size();
	for(int i=0; i<n/2; ++i){
		int frst=i;
		int last=n-1-i;
		for(int ii=frst; ii<last; ++ii){
			int offset=ii-frst;
			int top=vec[frst][ii];
			vec[frst][ii]=vec[last-offset][frst];
			vec[last-offset][frst]=vec[last][last-offset];
			vec[last][last-offset]=vec[ii][last];
			vec[ii][last]=top;
		}
	}
	cout<<"-------\n";
	for(int i=0; i<4; ++i){
		for(int j=0; j<4; ++j){
			cout<<vec[i][j]<<" ";
		}
		cout<<endl;
	}
    
	return 0;
}

