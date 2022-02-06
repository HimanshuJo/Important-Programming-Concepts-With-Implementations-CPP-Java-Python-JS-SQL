#include<iostream>
using namespace std;

int main(){
	int n=5;
	int k=1;
	while((1<<(k+1))<=n-1){
		cout<<k<<endl;
		k++;
	}
}