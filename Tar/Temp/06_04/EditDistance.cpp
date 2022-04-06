#include<vector>
#include<string>
#include<iostream>
#include<map>
using namespace std;

int getmin(int A, int B, int C){
	return (min(A, min(B, C)));
}

int dfs(string str1, string str2, int lenstr1, int lenstr2, map<tuple<string, string, int, int>, int>&memo){
	if(lenstr1==0) return lenstr2;
	if(lenstr2==0) return lenstr1;
	tuple<string, string, int, int>temp(str1, str2, lenstr1, lenstr2);
	if(memo.find(temp)!=memo.end()) return memo[temp];
	if(str1[lenstr1-1]==str2[lenstr2-1]) return dfs(str1, str2, lenstr1-1, lenstr2-1, memo);
	return (memo[temp]=1+getmin(dfs(str1, str2, lenstr1, lenstr2-1, memo), 
				dfs(str1, str2, lenstr1-1, lenstr2, memo),
				dfs(str1, str2, lenstr1-1, lenstr2-1, memo)));
}

int editDistance(string str1, string str2, int lenstr1, int lenstr2){
	map<tuple<string, string, int, int>, int>memo;
	int res=dfs(str1, str2, lenstr1, lenstr2, memo);
	return res;
}

int main(){
	string str1="voldemort";
	string str2="dumbledore";
	int lenstr1=str1.length(), lenstr2=str2.length();
	int ans=editDistance(str1, str2, lenstr1, lenstr2);
	cout<<ans<<endl;
}