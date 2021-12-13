// 410. Split Array Largest Sum
/*
Given an array nums which consists of non-negative integers and an integer m, you can 
split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

If we can split the array into several subarrays such that every subarray-sum is less than or equal to threshold. 
In this way, we discover the monotonicity of the problem: if feasible(m) is True, then all inputs larger than m can satisfy feasible function

def splitArray(nums: List[int], m: int) -> int:        
    def feasible(threshold) -> bool:
        count = 1
        total = 0
        for num in nums:
            total += num
            if total > threshold:
                total = num
                count += 1
                if count > m:
                    return False
        return True

    left, right = max(nums), sum(nums)
    while left < right:
        mid = left + (right - left) // 2
        if feasible(mid):
            right = mid     
        else:
            left = mid + 1
    return left
*/

class Solution {
public:

	bool isValid(vector<int>&nums, int m, int val){
		int count=1;
		int total=0;
		for(auto &num: nums){
			if(total+num>val){
				total=num;
				count++;
				if(count>m) return false;
			} else{
				total+=num;
			}
		}
		return true;
	}

    int splitArray(vector<int>& nums, int m) {
        int left=*max_element(nums.begin(), nums.end());
        int maxSm=0;
        for(auto &vals: nums)
        	maxSm+=vals;
        int right=maxSm;
        while(left<right){
        	int mid=left+(right-left)/2;
        	if(isValid(nums, m, mid)){
        		right=mid;
        	} else{
        		left=mid+1;
        	}
        }
        return left;
    }
};