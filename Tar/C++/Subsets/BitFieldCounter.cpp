#include<bits/stdc++.h>
#include <chrono>
using namespace std;

vector<vector<int>>res;

void genSubs(vector<int>A, int N){
    for(int B=0; B<(1<<N); ++B){
        // vector<int>curr;
        // for(int b=0; b<N; ++b){
        //     if(B&(1<<b)>0){
        //         curr.push_back(A[b]);
        //     }
        // }
        // res.push_back(curr);
        std::string binary = std::bitset<16>(B).to_string();
        cout<<binary<<endl;
    }
}

int main(){
    vector<int>tmp{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,56,67,8768,9,809,456,456,45};
    unsigned __int64 now = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
    genSubs(tmp, tmp.size());
    unsigned __int64 then = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
    cout<<res.size()<<endl;
    cout<<then-now<<endl;
}