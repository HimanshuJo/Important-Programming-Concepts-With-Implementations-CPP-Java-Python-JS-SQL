#include<vector>
#include<map>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); ++i) {
            map[i] = nums[i];
        }
        vector<int> res;
        int otherIndex = 0;
        bool haveFound = false;
        for (int i = 0; i < nums.size(); ++i) {
            for (auto x : map) {
                if (x.second == target - nums[i] && x.first != i) {
                    otherIndex = x.first;
                    haveFound = true;
                }
            }
            if (haveFound) {
                res.push_back(i);
                res.push_back(otherIndex);
                break;
            }
        }
        return res;
    }
};