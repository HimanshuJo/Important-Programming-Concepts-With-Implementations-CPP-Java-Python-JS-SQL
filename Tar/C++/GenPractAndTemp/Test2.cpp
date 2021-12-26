#include<iostream>
#include<vector>
#include<set>
using namespace std;

void genAllSubSeq(string&str, int n, int idx, set<string>&allSubseq, string&subseq){
	if(idx==n){
		allSubseq.insert(subseq);
		if(subseq.size()==0){
			allSubseq.insert({});
		}
		return;
	}
	subseq.push_back(str[idx]);
	genAllSubSeq(str, n, idx+1, allSubseq, subseq);
	subseq.pop_back();
	genAllSubSeq(str, n, idx+1, allSubseq, subseq);
}

int main(){
	string str="ababccccc";
	int n=str.size();
	int idx=0;
	set<string>allSubseq;
	string subseq="";
	genAllSubSeq(str, n, idx, allSubseq, subseq);
	for(auto &vals: allSubseq){
		cout<<vals;
		cout<<endl;
	}
}
