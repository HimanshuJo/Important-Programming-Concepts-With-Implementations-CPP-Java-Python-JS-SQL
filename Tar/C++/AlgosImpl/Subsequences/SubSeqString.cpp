#include <bits/stdc++.h>
using namespace std;

unordered_set<string> st;

void subsequence(string str)
{

	for (int i = 0; i < str.length(); i++) {
		for (int j = str.length(); j > i; j--) {
			string sub_str = str.substr(i, j);
			st.insert(sub_str);
			for (int k = 1; k < sub_str.length(); k++) {
				string sb = sub_str;
				sb.erase(sb.begin() + k);
				subsequence(sb);
			}
		}
	}
}

int main()
{
	string s = "ababccccc";
	subsequence(s);
	for (auto i : st)
		cout << i <<endl;
	cout << endl;

	return 0;
}
