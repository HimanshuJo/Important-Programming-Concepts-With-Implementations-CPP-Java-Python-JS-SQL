#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
	vector<int>in{33, 43, 12, 56, 78, 12, 45};
	sort(in.begin(), in.end());
	for(auto &vals: in)
	cout<<vals<<" ";
	cout<<endl;
	cout<<"-------\n";
	int num=46;
	auto it=lower_bound(in.begin(), in.end(), num);
	int numG=it-in.begin();
	cout<<*it<<endl;
	cout<<numG<<endl;
	cout<<"-------\n";
	auto it2=upper_bound(in.begin(), in.end(), num);
	int numToCheck=it2-in.begin();
	//int numL=(in.size()-(it2-in.begin()));
	cout<<*it2<<endl;
	//cout<<numL<<endl;
	cout<<numToCheck<<endl;
}