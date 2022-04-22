// C++ implementation to increment values in the
// given range by a value d for multiple queries
#include <bits/stdc++.h>

using namespace std;

// structure to store the (start, end) index pair for
// each query
struct query {
	int start, end;
};

// function to increment values in the given range
// by a value d for multiple queries
void incrementByD(int arr[], struct query q_arr[],
				int n, int m, int d)
{
	int sum[n];
	memset(sum, 0, sizeof(sum));

	// for each (start, end) index pair perform the
	// following operations on 'sum[]'
	for (int i = 0; i < m; i++) {

		// increment the value at index 'start' by
		// the given value 'd' in 'sum[]'
		sum[q_arr[i].start] += d;

		// if the index '(end+1)' exists then decrement
		// the value at index '(end+1)' by the given
		// value 'd' in 'sum[]'
		if ((q_arr[i].end + 1) < n)
			sum[q_arr[i].end + 1] -= d;
	}

	// Now, perform the following operations:
	// accumulate values in the 'sum[]' array and
	// then add them to the corresponding indexes
	// in 'arr[]'
	arr[0] += sum[0];
	for (int i = 1; i < n; i++) {
		sum[i] += sum[i - 1];
		arr[i] += sum[i];
	}
}

// function to print the elements of the given array
void printArray(int arr[], int n)
{
	for (int i = 0; i < n; i++)
		cout << arr[i] << " ";
}

// Driver program to test above
int main()
{
	int arr[] = { 3, 5, 4, 8, 6, 1 };
	struct query q_arr[] = { { 0, 3 }};
	int n = sizeof(arr) / sizeof(arr[0]);
	int m = sizeof(q_arr) / sizeof(q_arr[0]);
	int d = 2;

	cout << "Original Array:\n";
	printArray(arr, n);

	// modifying the array for multiple queries
	incrementByD(arr, q_arr, n, m, d);

	cout << "\nModified Array:\n";
	printArray(arr, n);

	return 0;
}
