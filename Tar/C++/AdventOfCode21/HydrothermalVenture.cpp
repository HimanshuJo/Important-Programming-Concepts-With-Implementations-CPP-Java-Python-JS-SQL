#include<iostream>
#include<vector>
#include<string>
#include<sstream>
#include<algorithm>
using namespace std;
using ll=long long;

vector<string> splitString(string str, char delimiter) { 
	vector<string> internal; 
	stringstream ss(str); 
	string tok; 
	while(getline(ss, tok, delimiter)) { 
		internal.push_back(tok); 
	} 
	return internal;
}

void eraseAllSubStr(std::string & mainStr, const std::string & toErase)
{
	size_t pos = std::string::npos;
	while ((pos  = mainStr.find(toErase) )!= std::string::npos)
	{
		mainStr.erase(pos, toErase.length());
	}
}

void remove_extra_whitespaces(const string &input, string &output)
{
	output.clear();
	unique_copy (input.begin(), input.end(), back_insert_iterator<string>(output),
			[](char a,char b){ return isspace(a) && isspace(b);});  
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n=10;
	vector<vector<pair<int, int>>>segs(n);
	for(int i=0; i<n; ++i){
		string in;
		cin>>in;
		eraseAllSubStr(in, "->");
		string output="";
		remove_extra_whitespaces(in, output);
		int n=output.length();
		for(int i=0; i<n; ++i){
			if(output[i]==' '){
				output[i]=',';
			}
		}
		vector<string>fn=splitString(output, ',');
		for(auto &vals: fn)
			cout<<vals<<endl;
		cout<<"-------\n";
		/*int x1=stoi(fn[0]), y1=stoi(fn[1]), x2=stoi(fn[2]), y2=stoi(fn[3]);
		vector<pair<int, int>>curr={{x1, y1}, {x2, y2}};
		sort(curr.begin(), curr.end());
		segs.push_back(curr);*/
	}
	for(auto &vals: segs){
		for(auto &pairs: vals){
			cout<<pairs.first<<" "<<pairs.second<<endl;
		}
		cout<<endl;
	}
}
