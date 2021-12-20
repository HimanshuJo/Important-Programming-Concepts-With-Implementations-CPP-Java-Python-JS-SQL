#include <iostream>
#include <string>
#include <algorithm>
#include<vector>
#include<cstring>
#include<sstream>
using namespace std;

vector<string> splitString(string str, char delimiter) { 
	vector<string> internal; 
	stringstream ss(str); 
	string tok; 
	while(getline(ss, tok, delimiter)) { 
		internal.push_back(tok); 
	} 
	return internal;  
}

 
int main()
{
    string str="hemnshh joshi";
    vector<string>splittedStr=splitString(str, ' ');
    for(auto &vals: splittedStr)
        cout<<vals<<endl;
    return 0;
}