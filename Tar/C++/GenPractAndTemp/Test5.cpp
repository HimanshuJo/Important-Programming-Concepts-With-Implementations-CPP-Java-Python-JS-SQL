// Efficient CPP program to find sum of first
// n natural numbers.
#include<iostream>
using namespace std;

// Returns sum of first n natural
// numbers
int findSum(int n)
{
return n * (n + 1) / 2;
}

// Driver code
int main()
{
int n1 = 8, n2=6;
cout << (findSum(n1)-findSum(n2))<<endl;
cout << findSum(n2)<<endl;
int ans=0;
for(int i=4; i<=9; ++i)
ans+=i;
cout<<(ans)<<endl;
}
