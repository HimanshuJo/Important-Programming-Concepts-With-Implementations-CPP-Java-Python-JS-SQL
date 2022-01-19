// 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number
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

// 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number
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

-------

CATCH : JUST FIND THE MIN NUMBER OF STEPS TO MAKE ABOVE TWO STRINGS EQUAL 👀

Iterate and reach to a point when the character don't match, See below i is pointing at '1' 
in string1 and j is pointing at '4' in string2 because s1[i] != s2[j]

string1 : 5489355142
string2 : 5489355421

We do j++ till they match, which bring j to '1' in string2 as 5489355421
Now we will swap from i to j and get following results,

5489355421 ----(swap 1 with 2)----> 5489355412
5489355421 ----(swap 1 with 4)----> 5489355142

i == j ? STOP

Do the same for rest of the string. No of swaps = No of steps required to make them equal.
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

    int getMinSwaps(string num, int k) {
        string original = num;
        vector<char>nums;
        for (char ch : num)
            nums.push_back(ch);
        vector<char>curr;
        while (k--) {
            curr = nextPermutation(nums);
            nums.clear();
            nums = curr;
        }
        string fn = "";
        for (auto &vals : curr) {
            fn += vals;
        }
        return minSteps(original, fn);
    }

    int minSteps(string s1, string s2) {
        int size = s1.length();
        int i = 0, j = 0;
        int result = 0;

        while (i < size) {
            j = i;
            while (s1[j] != s2[i]) j++;

            while (i < j) {
                swap(s1[j], s1[j - 1]);
                j--;
                result++;
            }
            i++;
        }
        return result;
    }
};

int main()
{
    Solution obj;
    string nums = "5489355142";
    int k = 4;
    obj.getMinSwaps(nums, k);
}