#include<iostream>
#include<vector>
using namespace std;

int calDist(int X1, int Y1, int X2, int Y2){
	return((abs(X1-X2))+(abs(Y1-Y2)));
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int x, y;
		cin>>x>>y;
		bool flag=false;
		int ansX=0;
		int ansY=0;
		int origDist=calDist(x, y, 0, 0);
		for(int i=0; i<50; ++i){
			for(int j=0; j<50; ++j){
				int NwcurrX=i;
				int NwcurrY=j;
				int currDist1=calDist(NwcurrX, NwcurrY, 0, 0); //AC
				int currDist2=calDist(x, y, NwcurrX, NwcurrY); //BC
//				cout<<"AC "<<currDist1<<endl;
//				cout<<"BC "<<currDist2<<endl;
//				cout<<"-------\n";
				if(2*currDist1==origDist&&2*currDist2==origDist){
					flag=true;
					ansX=NwcurrX;
					ansY=NwcurrY;
					break;
				}
			}
		}
		if(flag){
			cout<<ansX<<" "<<ansY<<"\n";
		} else{
			cout<<"-1 -1\n";
		}
	}
}
