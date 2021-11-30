#include<vector>
#include<iostream>
using namespace std;

class Solution {
  public:
    int maxDistance(vector < int > & colors) {
      int ans = 0;
      for (int x = 0; x < colors.size(); ++x) {
        int begin = colors[x];
        for (int i = 0; i < colors.size(); ++i) {
          if (colors[i] != begin) {
            int curr = abs(x - i);
            ans = max(ans, curr);
          }
        }
      }
      return ans;
    }
};

int main(){}
