#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

struct custComp{
    const bool operator()(const pair<int, int>A, const pair<int, int>B) {
        return A.second==B.second?A.first>B.first:A.second>B.second;
    }
};
int main(){
    vector<pair<int, int>>vec{{1, 1}, {2, 4},  {5, 2}, {8, 3}, {7, 1}};
    sort(vec.begin(), vec.end(), custComp());
    for(auto &vals: vec){
        cout<<vals.first<<" "<<vals.second;
        cout<<endl;
    }
}

/*
2 4
8 3
5 2
7 1
1 1
*/