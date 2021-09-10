#include<bits/stdc++.h>
using namespace std;

int main(){
    int arr[]={1,2,3};
    const int sz=sizeof(arr)/sizeof(arr[0]);
    int res[sz];
    for (int i=0; i<sz; ++i){
        res[arr[i]-1]=i+1;
    }
    for (int x: res){
        cout<<x<<" ";
    }
}