// Capacity To Ship Packages Within D Days
/*
A conveyor belt has packages that must be shipped from one port 
to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. 
Each day, we load the ship with packages on the conveyor belt 
(in the order given by weights). 
We may not load more weight than the maximum weight capacity of 
the ship.

Return the least weight capacity of the ship that will result in all 
the packages on the conveyor belt being shipped within days days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship 
all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, 
so using a ship of capacity 14 and splitting the packages 
into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is 
not allowed.
*/
/*
    We can use the Greedy Technique and Binary Search.

    The monotonicity of the problem can be observed that if all packages
        can be successfully shipped within D days with the capacity K,
        then definitely they can be shipped with any capacity larger than
        K.

    -------

    Algorithm:

        Initialize a variable, 'ans' as -1 to store the resultant minimum capacity
            of the ship
        
        Initialize two variables, say 'start' and 'end' with the max element in
            the given array and the total sum of the array, respectively which
            denotes the lower and upper bound of the search space

        Iterate until the value of 'start' is less than equal to 'end' and perform
            the following steps

            1. Initialize a variable, say mid=(start+end)/2
            2. Check if it is possible to ship all the packages within D days
                when the maximum capacity allowed is 'mid'

                If found to be true, then update the value of ans to mid and the value
                    of end to (mid-1)
            3. Otherwise, update the value of start to (mid+1)
*/

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

bool checkCond(int tar, vector<int>&weights, int days){
	int currT=tar;
	int tD=0;
	bool flag=false;
	bool edInd=false;
	for (int i=0; i<weights.size(); ++i){
		tD++;
		while (true){
			if (currT-weights[i]>=0){
				currT=currT-weights[i];
				++i;
				if (i==weights.size()){
					flag=true;
					edInd=true;
					break;
				}
			} else {
				break;
			}
		}
		if (flag){
			break;
		}
		--i;
		currT=tar;
	}
	return (tD==days?true:edInd==true&&tD<=days?true:false);;
}

    int shipWithinDays(vector<int>& weights, int days) {
        int ans=-1;
        int maxEle=INT_MIN;
        int smWei=0;
        for (int i=0; i<weights.size(); ++i){
            if (weights.at(i)>maxEle){
                maxEle=weights.at(i);
            }
            smWei+=weights.at(i);
        }
        int start=maxEle;
        int end=smWei;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (checkCond(mid, weights, days)){
                ans=mid;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        cout<<ans<<endl;
        return ans;
    }
};

int main(){
    Solution obj;
    vector<int>weights={9, 8, 10};
    int days=3;  
    obj.shipWithinDays(weights, days);
}