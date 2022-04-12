#include<string>
#include<iostream>
using namespace std;

int main(){
	string one="1223234";
	int num=9;
	one[2]=(char)num;
	cout<<one<<endl;
}