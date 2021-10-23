#include<bits/stdc++.h>
using namespace std;

template <typename V>
void pop_front(V & v, int i)
{
    assert(!v.empty());
    v.erase(v.begin()+i);
}

template <typename V>
void popBack(V & v, int i)
{
    assert(!v.empty());
    v.erase(v.end()-i);
}

int main(){
    vector<int>tmp{1,2,3,4,5};
    popBack(tmp, 1);
    for(auto &nums: tmp){
        cout<<nums<<" ";
    }
}