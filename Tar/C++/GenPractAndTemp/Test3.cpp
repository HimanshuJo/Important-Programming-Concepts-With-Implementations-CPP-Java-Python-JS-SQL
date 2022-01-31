#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

int main(){
    vector<int>in{3,9,19,5,21};
    sort(in.begin(), in.end());
    for(auto &vals: in)
        cout<<vals<<" ";
    cout<<endl;
    int currval=19;
    auto it=lower_bound(in.begin(), in.end(), 19);
    if(*it>currval) it--;
    if(it!=in.end()&&it>=in.begin()){
        cout<<*it<<endl;
        int idx=it-in.begin();
        cout<<"idx "<<idx<<endl;
    }
    else cout<<-1<<endl;
}