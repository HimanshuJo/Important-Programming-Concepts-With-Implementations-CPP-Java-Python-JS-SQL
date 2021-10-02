// C++ program to find prime factorization of a
// number n in O(Log n) time with precomputation
// allowed.
#include "bits/stdc++.h"
using namespace std;

#define MAXN 10000000

// stores smallest prime factor for every number
int spf[MAXN];

// Calculating SPF (Smallest Prime Factor) for every
// number till MAXN.
// Time Complexity : O(nloglogn)
void sieve()
{
  spf[1] = 1;
  for (int i = 2; i < MAXN; i++)

    // marking smallest prime factor for every
    // number to be itself.
    spf[i] = i;

  // separately marking spf for every even
  // number as 2
  for (int i = 4; i < MAXN; i += 2)
    spf[i] = 2;

  for (int i = 3; i * i < MAXN; i++)
  {
    // checking if i is prime
    if (spf[i] == i)
    {
      // marking SPF for all numbers divisible by i
      for (int j = i * i; j < MAXN; j += i)

        // marking spf[j] if it is not
        // previously marked
        if (spf[j] == j)
          spf[j] = i;
    }
  }
}

// A O(log n) function returning primefactorization
// by dividing by smallest prime factor at every step
vector<int> getFactorization(int x)
{
  vector<int> ret;
  while (x != 1)
  {
    ret.push_back(spf[x]);
    x = x / spf[x];
  }
  return ret;
}

int lcm(int x, int y, int z)
{
  long max, lcom, count, flag = 0;
  if (x >= y && x >= z)
    max = x;
  else if (y >= x && y >= z)
    max = y;
  else if (z >= x && z >= y)
    max = z;
  for (count = 1; flag == 0; count++)
  {
    lcom = max * count;
    if (lcom % x == 0 && lcom % y == 0 && lcom % z == 0)
    {
      flag = 1;
    }
  }
  return lcom;
}

// driver program for above function
int main(int argc, char const *argv[])
{
  // precalculating Smallest Prime Factor
  sieve();
  int x1 = 30;
  int x2 = 10;
  int x3 = 20;

  // calling getFactorization function
  vector<int> p1 = getFactorization(x1);
  int res1 = 1;
  vector<int> p2 = getFactorization(x2);
  int res2 = 1;
  vector<int> p3 = getFactorization(x3);
  int res3 = 1;
  for (int i = 0; i < p1.size(); i++)
  {
    res1 *= p1[i];
    //cout << p1[i] << " ";
  }
  for (int i = 0; i < p2.size(); i++)
    res2 *= p2[i];
  //cout << p2[i] << " ";
  for (int i = 0; i < p3.size(); i++)
    res3 *= p3[i];
  //cout << p3[i] << " ";
  cout << lcm(res1, res2, res3);
  return 0;
}
