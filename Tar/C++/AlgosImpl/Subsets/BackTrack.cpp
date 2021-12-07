#include<bits/stdc++.h>
#include<chrono>
using namespace std;

void subsetsUtil(vector<int> &A, vector<vector<int>> &res, vector<int> &subset, int index)
{
	res.push_back(subset);
	for (int i = index; i < A.size(); ++i)
	{
		subset.push_back(A[i]);
		subsetsUtil(A, res, subset, i + 1);
		subset.pop_back();
	}
	return;
}

vector<vector<int>> subsets(vector<int> &A)
{
	vector<int> subset;
	vector<vector<int>> res;
	int index = 0;
	subsetsUtil(A, res, subset, index);
	return res;
}

int main(){
    vector<int>tmp{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8};
    unsigned __int64 now = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
    vector<vector<int>>res=subsets(tmp);
    unsigned __int64 then = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
    cout<<res.size()<<endl;
    cout<<then-now<<endl;
}