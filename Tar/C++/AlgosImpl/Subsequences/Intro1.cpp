#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
using ll=long long;

void genAllSubSeqUtil(vector<ll>&in, vector<vector<ll>>&res, vector<ll>subarr, int idx){
	if (idx == in.size())
	{
		int l = subarr.size(); 
		if (l != 0){
			res.push_back(subarr);
		}
	}
	else
	{
		genAllSubSeqUtil(in, res, subarr, idx+1); 
		subarr.push_back(in[idx]);
		genAllSubSeqUtil(in, res, subarr, idx+1);
	}
	return;
}

vector<vector<ll>> genAllSubSeq(vector<ll>&in){
	vector<ll>subarr;
	vector<vector<ll>>res;
	genAllSubSeqUtil(in, res, subarr, 0);
	return res;
}

int main(){}