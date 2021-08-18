/*
You are given a string num, representing a large integer, and an integer k.

We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num. 
There can be many wonderful integers. However, we only care about the smallest-valued ones.

    For example, when num = "5489355142":
        The 1st smallest wonderful integer is "5489355214".
        The 2nd smallest wonderful integer is "5489355241".
        The 3rd smallest wonderful integer is "5489355412".
        The 4th smallest wonderful integer is "5489355421".

Return the minimum number of adjacent digit swaps that needs to be applied to num to 
reach the kth smallest wonderful integer.

The tests are generated in such a way that kth smallest wonderful integer exists.

Input: num = "5489355142", k = 4
Output: 2
Explanation: The 4th smallest wonderful number is "5489355421". To get this number:
- Swap index 7 with index 8: "5489355142" -> "5489355412"
- Swap index 8 with index 9: "5489355412" -> "5489355421"
*/
/*
	To find the next permutation

		suppose we have a number 54586

			we initially start from the end amd we find the first index of the number who is
				smaller than the number next to it

				e.g. in the above case that first number is 5 which is smaller than 8

				That's the place where we want to place a bigger number

			next step is to find the first number scanning from the end that is greater than the number
				which we have just found

				in this case we will find number 6

				then we swap those two numbers

			after swapping we just have to reverse the numbers after the swapped index as we know
				all the numbers after the swapped index will be in decreasing order
*/

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
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

    vector<char> nextPermutation(vector<char> nums)
    {
        vector<char> res;
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

    int getMinSwaps(string nums, int k)
    {
        vector<char> num;
        for (int i = 0; i < nums.length(); ++i)
        {
            num.push_back(nums.at(i));
        }
        string oldNums = nums;
        vector<char> pr = num;
        while (k--)
        {
            vector<char> cust;
            cust = nextPermutation(pr);
            for (auto &entry : cust)
            {
                cout << entry << " ";
            }
            pr.clear();
            pr = cust;
            cout << "\n";
        }
        int ans = 0;
        cout << "\n";
        for (int i = 0; i < num.size(); ++i)
        {
            if (pr.at(i) != oldNums.at(i))
            {
                int j = i + 1;
                while (oldNums[j] != pr[i])
                {
                    j += 1;
                }
                while (j != i)
                {
                    swap(oldNums.at(j), oldNums[j - 1]);
                    j -= 1;
                    ans += 1;
                }
            }
        }
        cout << ans << "\n";
        return ans;
    }
};

int main()
{
    Solution obj;
    string nums = "5489355142";
    int k = 4;
    obj.getMinSwaps(nums, k);
}