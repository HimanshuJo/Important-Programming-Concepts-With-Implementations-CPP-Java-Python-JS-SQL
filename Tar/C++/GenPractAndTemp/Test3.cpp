#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    
	string toBase(int num, int base){
		string res="";
		while(num>=1){
			int quo=num%base;
			res+=to_string(quo);
			num/=base;
			if(num<1) break;
		}
		return res;
	}
	
	long long kMirror(int k, int n) {
    	long long sm=0;
		int count=0;
		for(int i=8388608; i>=0; --i){
			if(isPalindrome(to_string(i))){
				string toChk=toBase(i, k);
				if(isPalindrome(toChk)){
					count++;
					if(count>n) break;
					sm+=i;
				}
			}
		}
		return sm;
	}
};

bool isPalindrome(string str){
		for(int i=0; i<str.length()/2; ++i){
			if(str[i]!=str[str.length()-i-1]){
				return false;
			}
		}
		return true;
}


int main(){
	//Solution obj;
	//obj.kMirror(3, 121);
	vector<int>vec;
	for(int i=1; i<=88888888; ++i){
		if(isPalindrome(i)){
			vec.push_back(to_string(i));
		}
	}
}
