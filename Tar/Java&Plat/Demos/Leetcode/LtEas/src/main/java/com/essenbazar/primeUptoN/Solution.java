/*

Get prime number up to n

*/
/*
#include <bits/stdc++.h>
using namespace std;

const int N=111;
bool primeArray[N];

void createSieve(){
    for (int i=0; i<=N; ++i){
        primeArray[i]=true;
    }
    primeArray[0]=false;
    primeArray[1]=false;
    for (int i=2; i*i<=N; ++i){
        if (primeArray[i]){
            for (int j=i*i; j<=N; j+=i){
                primeArray[j]=false;
            }
        }
    }
}

void printSieve(){
    for (int i=0; i<=N; ++i){
        if (primeArray[i]){
            cout<<i<<" ";
        }
    }
}

int main(){
    createSieve();
    printSieve();
}
*/

package com.essenbazar.primeUptoN;

public class Solution {

    static boolean primeArray[] = new boolean[100000];

    void createSieve(int N){
        for (int i=0; i<=N; ++i){
            primeArray[i]=true;
        }
        primeArray[0]=false;
        primeArray[1]=false;
        for (int i=2; i*i<=N; ++i){
            if (primeArray[i]){
                for (int j=i*i; j<=N; j+=i){
                    primeArray[j]=false;
                }
            }
        }
    }
    
    void printSieve(int N){
        for (int i=0; i<=N; ++i){
            if (primeArray[i]){
                System.out.println(i + " ");
            }
        }
    }

    public void getPrime(int N) {
        createSieve(N);
        printSieve(N);
    }
    
    
    public static void main(String[] args) {
        Solution my_obj = new Solution();
        my_obj.getPrime(111);
    }
}
