/* A k-mirror number is a positive integer without leading zeros that reads the same both forward and 
backward in base-10 as well as in base-k.

For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, 
which read the same both forward and backward.
On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the 
same both forward and backward.
Given the base k and the number n, return the sum of the n smallest k-mirror numbers.

Example 1:

Input: k = 2, n = 5
Output: 25
Explanation:
The 5 smallest 2-mirror numbers and their representations in base-2 are listed as follows:
  base-10    base-2
    1          1
    3          11
    5          101
    7          111
    9          1001
Their sum = 1 + 3 + 5 + 7 + 9 = 25. 
*/

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
	
	bool isPalindrome(string str){
		for(int i=0; i<str.length()/2; ++i){
			if(str[i]!=str[str.length()-i-1]){
				return false;
			}
		}
		return true;
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

int main(){
	Solution obj;
	obj.kMirror(3, 121);
}
