// C++ implementation of the approach
#include <bits/stdc++.h>
using namespace std;


int num_swaps(vector<int>&x, int n) {
  if (n == 0) {
    return 0;
  } else if (x[n - 1] == n  - 1) {
    return num_swaps(x, n - 1);
  } else {
    auto i = std::find(x.begin(), x.end(), n - 1);
    std::swap(*i, x[n - 1]);
    return num_swaps(x, n - 1) + 1;
  }
}


// Driver code
int main()
{
	// 1-based indexing
	vector<int>x = {1,2,3 };
	int n = 3;

	// Calling function
	cout << (num_swaps(x, n));

	return 0;
}

