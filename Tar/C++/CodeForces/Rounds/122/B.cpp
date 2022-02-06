// B. Minority
/*
You are given a string s, consisting only of characters '0' and '1'.

You have to choose a contiguous substring of s and remove all occurrences of the character, 
which is a strict minority in it, from the substring.

That is, if the amount of '0's in the substring is strictly smaller than the amount of '1's, 
remove all occurrences of '0' from the substring. If the amount of '1's is strictly smaller than the amount of '0's, 
remove all occurrences of '1'. If the amounts are the same, do nothing.

You have to apply the operation exactly once. What is the maximum amount of characters that can be removed?

Input
The first line contains a single integer t (1≤t≤10^4) — the number of testcases.

The only line of each testcase contains a non-empty string s, consisting only of characters '0' and '1'. 
The length of s doesn't exceed 2⋅10^5.

The total length of strings s over all testcases doesn't exceed 2⋅10^5.

Output
For each testcase, print a single integer — the maximum amount of characters that can be removed after 
applying the operation exactly once.

Example
input
4
01
1010101010111
00110001000
1

output
0
5
3
0

Note
In the first testcase, you can choose substrings "0", "1" or "01". In "0" the amount of '0' is 1, 
the amount of '1' is 0. '1' is a strict minority, thus all occurrences of it are removed from the 
substring. However, since there were 0 of them, nothing changes. 
Same for "1". And in "01" neither of '0' or '1' is a strict minority. 
Thus, nothing changes. So there is no way to remove any characters.

In the second testcase, you can choose substring "10101010101". 
It contains 5 characters '0' and 6 characters '1'. '0' is a strict minority. 
Thus, you can remove all its occurrences. There exist other substrings that produce the same answer.

In the third testcase, you can choose substring "011000100". It contains 6 characters '0' and 3 
characters '1'. '1' is a strict minority. Thus, you can remove all its occurrences.
*/

#include<iostream>
#include<string>
#include<unordered_map>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		unordered_map<char, int>mp;
		int len=s.length();
		for(int i=0; i<len; ++i){
			mp[s[i]]++;
		}
		int cnt1=mp['0'], cnt2=mp['1'];
		if(cnt1==cnt2){
			cout<<(cnt1-1)<<"\n";
		} else{
			cout<<(cnt1<cnt2?cnt1:cnt2)<<"\n";
		}
	}
}
