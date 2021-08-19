#include<bits/stdc++.h>
using namespace std;

bool getBit(int n, int i){
    return (n&(1<<i))!=0;
}

int hammingWeight(int n){
    int count=0;
    for (int i=1; i<33; ++i){
        if (getBit(n,i)==1){
            count++;
        }
    }
    return count;
}

int main(){
    cout<<hammingWeight(11);
}