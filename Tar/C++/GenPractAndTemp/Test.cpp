// C++ program for the above approach
#include <bits/stdc++.h>
using namespace std;

// Function to implement sieve of
// erastosthenes
void sieveOfEratosthenes(int N, int s[])
{
	// Create a boolean array and
	// initialize all entries as false
	vector<bool> prime(N + 1, false);

	// Initializing smallest
	// factor equal to 2
	// for all the even numbers
	for (int i = 2; i <= N; i += 2)
		s[i] = 2;

	// Iterate for odd numbers
	// less then equal to n
	for (int i = 3; i <= N; i += 2) {

		if (prime[i] == false) {

			// s(i) for a prime is
			// the number itself
			s[i] = i;

			// For all multiples of
			// current prime number
			for (int j = i; j * i <= N; j += 2) {

				if (prime[i * j] == false) {
					prime[i * j] = true;

					// i is the smallest
					// prime factor for
					// number "i*j"
					s[i * j] = i;
				}
			}
		}
	}
	for(int i=1; i<=N; ++i){
		if(prime[i]==false){
			cout<<i<<endl;
		}
	}
	cout<<"-------\n";
}

// Function to generate prime
// factors and its power
int generatePrimeFactors(int N)
{
	// s[i] is going to store
	// smallest prime factor of i
	int s[N + 1];
	int sum = 0;

	sieveOfEratosthenes(N, s);

	// Current prime factor of N
	int curr = s[N];

	// Power of current prime factor
	int cnt = 1;

	// Calculating prime factors
	// and their powers sum
	while (N > 1) {

		N /= s[N];

		if (curr == s[N]) {

			// Increment the count and
			// continue the process
			cnt++;
			continue;
		}

		// Add count to the sum
		sum = sum + cnt;

		curr = s[N];

		// Reinitialize count
		cnt = 1;
	}

	// Return the result
	return sum;
}

// Function to find the sum of all the
// power of prime factors of N
void findSum(int N)
{

	int sum = 0;

	// Iterate for in [2, N]
	//for (int i = 2; i <= N; i++) {
		sum += generatePrimeFactors(100);
	//}
	cout << sum << endl;
}

// Driver Code
int main()
{
	// Given Number N
	int N = 100;

	// Function Call
	findSum(N);
	return 0;
}