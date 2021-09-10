// CPP program to generate power set in
// lexicographic order.
#include <bits/stdc++.h>
using namespace std;

// str : Stores input string
// n : Length of str.
// curr : Stores current permutation
// index : Index in current permutation, curr
vector<string>res;
void allSubSeqRec(string str, int n, int index, string curr)
{
	// base case
	if (index == n)
		return;

	if (!curr.empty()) {
		res.push_back(curr);
        //cout << curr << "\n";
	}

	for (int i = index + 1; i < n; i++) {

		curr += str[i];
		allSubSeqRec(str, n, i, curr);

		// backtracking
		curr = curr.erase(curr.size() - 1);
	}
	return;
}

// Generates power set in lexicographic
// order.
void allSubSeq(string str)
{
	allSubSeqRec(str, str.size(), -1, "");
}

// Driver code
int main()
{
	string str = "cab";
	allSubSeq(str);
    for (auto &entry: res){
        cout<<entry<<" ";
    }
	return 0;
}
