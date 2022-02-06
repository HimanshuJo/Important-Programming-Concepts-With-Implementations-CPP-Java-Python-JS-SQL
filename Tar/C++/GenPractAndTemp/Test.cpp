#include<vector>
#include<iostream>
#include<algorithm>
#include<map>
using namespace std;

vector<char> reverseNums(vector<char> nums, int left, int right)
{
    while (left < right)
    {
        swap(nums.at(left), nums.at(right));
        left += 1;
        right -= 1;
    }
    return nums;
}

vector<char> nextPermutation(vector<char>nums)
{
    vector<char>res;
    int n = nums.size();
    int index1 = -1;
    // starting from the end find the first number that is smaller than nums[i + 1]
    for (int i = n - 2; i >= 0; --i)
    {
        if (nums.at(i) < nums.at(i + 1))
        {
            index1 = i;
            break;
        }
    }
    /*
        If we couldn't find any index then all the numbers are already in the descending
        order, and there is no next permutation
    */
    if (index1 != -1)
    {
        int index2 = -1;
        for (int i = n - 1; n >= 0; --i)
        {
            if (nums.at(i) > nums.at(index1))
            {
                index2 = i;
                break;
            }
        }
        swap(nums.at(index1), nums.at(index2));
        res = reverseNums(nums, index1 + 1, n - 1);
    }
    return res;
}

int main(){
    string str="54586";
    vector<char>num;
    for(char ch: str)
    num.push_back(ch);
    vector<char>res=nextPermutation(num);
    for(char ch: res)
        cout<<ch<<" ";
}