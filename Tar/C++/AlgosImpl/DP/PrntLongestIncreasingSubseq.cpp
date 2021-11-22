// Construction of Longest Increasing Subsequence(LIS) and printing LIS sequence
/*
The longest Increasing Subsequence (LIS) problem is to find the length of 
the longest subsequence of a given sequence such that all elements of the 
subsequence are sorted in increasing order.

Examples: 

Input:  [10, 22, 9, 33, 21, 50, 41, 60, 80]
Output: [10, 22, 33, 50, 60, 80] 
OR [10 22 33 41 60 80] or any other LIS of same length.
*/

/*
Let arr[0..n-1] be the input array. We define vector L such that L[i] is 
itself is a vector that stores LIS of arr that ends with arr[i]. 
For example, for array [3, 2, 6, 4, 5, 1], 

L[0]: 3
L[1]: 2
L[2]: 2 6
L[3]: 2 4
L[4]: 2 4 5
L[5]: 1
Therefore, for index i, L[i] can be recursively written as – 

L[0] = {arr[O]}
L[i] = {Max(L[j])} + arr[i] 
where j < i and arr[j] < arr[i] and if there is no such j then L[i] = arr[i]
*/

#include<iostream>
#include<vector>
using namespace std;

void prntLIS(vector<int>&arr){
    for (int x: arr){
        cout<<x<<" ";
    }
}

void constructPrntLIS(int arr[], int n){
    vector<vector<int>>L(n);
    L[0].push_back(arr[0]);
    for (int i=1; i<n; ++i){
        for (int j=0; j<i; ++j){
            // if comparing with only (L[j].size()) e.g. for i=4, j=0 arr[i]>arr[j] copy L[0] to L[4]
            // next iteration i=4, j=1 arr[i]>arr[j] can't copy current L size is same, but current L[1] is optimal
            if ((arr[j]<arr[i])&&(L[j].size()+1)>L[i].size()){
                L[i]=L[j];
            }
        }
        L[i].push_back(arr[i]);
    }
    vector<int>maxx=L[0];
    for (vector<int>x: L){
        if (x.size()>maxx.size()){
            maxx=x;
        }
    }
    prntLIS(maxx);
}

int main(){
    int arr[]={3, 2, 6, 4, 5, 7};
    constructPrntLIS(arr, sizeof(arr)/sizeof(arr[0]));
}