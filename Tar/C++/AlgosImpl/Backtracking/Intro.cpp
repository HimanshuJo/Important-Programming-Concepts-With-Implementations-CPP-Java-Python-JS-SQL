#include<bits/stdc++.h>
using namespace std;

// In the array A at every step we have two choices for each element either, we can ignore
// the element or we can include the element in our subset
void subsetsUtil(vector<int>& A, vector<vector<int>>& res, vector<int>& subset, int index) {
	res.push_back(subset);
	for (int i = index; i < A.size(); ++i) {
		// include the A[i] in subset
		subset.push_back(A[i]);
		// move onto the next element
		subsetsUtil(A, res, subset, i + 1);
		// exclude the A[i] from subset and triggers
		// backtracking
		subset.pop_back();
	}
	return;
}

// function that will call the subsetsUtil and returns the subsets of vector A
vector<vector<int>> subsets(vector<int>& A) {
	vector<int> subset;
	vector<vector<int>> res;
	// keeps track of the current element in vector A
	int index = 0;
	subsetsUtil(A, res, subset, index);
	return res;
}

int main() {
	// find the subsets of the below vector
	vector<int> array = {1, 2, 3, 4, 5};
	// res will store all the subsets
	// O(2^(number of elements inside the array))
	// because at every step we have two choices
	// either include or ignore
	vector<vector<int>> res = subsets(array);
	for (int i = 0; i < res.size(); ++i) {
		for (int j = 0; j < res[i].size(); ++j) {
			cout << res[i][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}

