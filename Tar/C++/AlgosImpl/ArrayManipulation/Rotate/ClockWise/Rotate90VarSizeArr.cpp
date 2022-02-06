#include<bits/stdc++.h>
using namespace std;

void funcRotate(vector<vector<int>>&vec){
	int N=vec.size();
	int n=N;
	int strt=0;
	int l1=strt, l2=strt, t1=strt, t2=strt, r1=strt, r2=strt, b1=strt, b2=strt;
	for(int i=0; i<N/2; ++i){
		t1=strt, t2=strt;
		r1=strt, r2=n-1;
		b1=n-1, b2=n-1;
		l1=n-1, l2=strt;
		for(int ii=strt; ii<n-1; ++ii){
			int temp=vec[t1][t2];
			vec[t1][t2]=vec[l1][l2];
			vec[l1][l2]=vec[b1][b2];
			vec[b1][b2]=vec[r1][r2];
			vec[r1][r2]=temp;
			t2++, l1--, b2--, r1++;
		}
		strt++;
		n--;
	} 
}

int main(){
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
	cout<<"****----****\n";
	funcRotate(vec);
	for(int i=0; i<4; ++i){
		for(int j=0; j<4; ++j){
			cout<<vec[i][j]<<" ";
		}
		cout<<endl;
	}
}
