#include<iostream>
#include<vector>
#include<string>
#include<set>
using namespace std;

void genDistinctSubsequeUtil(string str, int idx, set<vector<char>>&res, 
                             vector<char>cursubseque){
	if(idx>=str.length()){
		res.insert(cursubseque);
		return;
	}
	cursubseque.push_back(str[idx]);
	genDistinctSubsequeUtil(str, idx+1, res, cursubseque);
	cursubseque.pop_back();
	genDistinctSubsequeUtil(str, idx+1, res, cursubseque);
}

set<vector<char>> genDistinctSubseque(string str){
	set<vector<char>>res;
	vector<char>cursubseque;
	genDistinctSubsequeUtil(str, 0, res, cursubseque);
	return res;
}

int main(){
	string str="abcd";
	set<vector<char>>allsubseque=genDistinctSubseque(str);
	for(auto &vals: allsubseque){
		if(vals.size()==0) cout<<"{}";
		else{
			for(char ch: vals){
				cout<<ch;
			}
		}
		cout<<endl;
	}
}