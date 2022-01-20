#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<cmath>
#include<cstring>
using namespace std;

int main(){
	int arr[5][5];
	memset(arr, -1, sizeof(arr));
	for(int i=0; i<5; ++i)
	for(int j=0; j<5; ++j)
	cout<<arr[i][j]<<" ";
}