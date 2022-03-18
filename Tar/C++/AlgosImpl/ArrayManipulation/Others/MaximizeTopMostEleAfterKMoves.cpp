// 2202. Maximize the Topmost Element After K Moves
/*
You are given a 0-indexed integer array nums representing the contents of a pile, 
where nums[0] is the topmost element of the pile.

In one move, you can perform either of the following:

If the pile is not empty, remove the topmost element of the pile.
If there are one or more removed elements, add any one of them back onto the pile. 
This element becomes the new topmost element.
You are also given an integer k, which denotes the total number of moves to be made.

Return the maximum value of the topmost element of the pile possible after exactly k moves. 
In case it is not possible to obtain a non-empty pile after k moves, return -1.

Example 1:

Input: nums = [5,2,2,4,0,6], k = 4
Output: 5
Explanation:
One of the ways we can end with 5 at the top of the pile after 4 moves is as follows:
- Step 1: Remove the topmost element = 5. The pile becomes [2,2,4,0,6].
- Step 2: Remove the topmost element = 2. The pile becomes [2,4,0,6].
- Step 3: Remove the topmost element = 2. The pile becomes [4,0,6].
- Step 4: Add 5 back onto the pile. The pile becomes [5,4,0,6].
Note that this is not the only way to end with 5 at the top of the pile. It can be shown that 5 is the largest answer possible after 4 moves.
Example 2:

Input: nums = [2], k = 1
Output: -1
Explanation: 
In the first move, our only option is to pop the topmost element of the pile.
Since it is not possible to obtain a non-empty pile after one move, we return -1.
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i], k <= 10^9
*/

/*
Solution 2:

class Solution {
public:
    int maximumTop(vector<int>& A, int k) {
        int N = A.size();
        if (k == 0) return N >= 1 ? A[0] : -1; // if no moves allowed, return the topmost element if any
        if (k == 1) return N == 1 ? -1 : A[1]; // if only one move is allowed, we can only remove the topmost element
        // if `N == 1`, we can return the topmost element if `k` is a even number 
        // (keep removing the topmost element and adding it back).
        if (N == 1) return k % 2 == 0 ? A[0] : -1;
        // we can take `min(k-1, N)` elements and put back the largest one on the top
        int mx = *max_element(begin(A), begin(A) + min(k - 1, N));
        if (k < N) mx = max(mx, A[k]); // If `k < N`, we can take all the topmost `k` elements and return the one left at the top
        return mx;
    }
};
*/

class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>>pq;
        int idx=0;
        int sz=nums.size();
        int res=-1;
        if(k==0) return nums[0];
        if(nums.size()==1&&k%2!=0) return -1;
        if(k==1){
            if(nums.size()==1) return -1;
            else return nums[1];
        }
        while(true){
            if(idx==k-1){
                if(idx+1<sz){
                    int tochk=pq.top().first;
                    if(nums[idx+1]>tochk){
                        res=nums[idx+1];
                        break;
                    } else{
                        res=tochk;
                        break;
                    }
                } else{
                    if(pq.empty()){
                        return -1;
                    }
                }
            }
            int curr=nums[idx];
            pq.push({curr, idx});
            idx++;
            if(idx==sz){
                if(!pq.empty()){
                    int last=pq.top().first;
                    int idx_=pq.top().second;
                    if(idx_==sz-1&&idx_==k-1){
                        pq.pop();
                        if(!pq.empty()){
                            return pq.top().first;
                        } else return -1;
                    }
                    return pq.top().first;   
                }
            }
        }
        return res;
    }
};