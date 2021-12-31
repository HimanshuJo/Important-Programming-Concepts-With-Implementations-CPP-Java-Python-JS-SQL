// 
/*
Given two arrays arr[] and brr[] containing integers. 
The task is to find the Kth largest product of a pair (arr[i], brr[j]).

Input: arr[] = {1, -2, 3}, brr[] = {3, -4, 0}, K = 3
Output: 3
Explaination: All product combinations in descending order are : [9, 8, 3, 0, 0, 0, -4, -6, -12] and 
3rd largest element is 3.

Input: arr[] = {-1, -5, -3}, brr[] = {-3, -4, 0}, K =5
Output: 4
Explaination: All product combinations in descending order are : [20, 15, 12, 9, 4, 3, 0, 0, 0] and 
5th largest element is 4.
*/

/*
Naive Approach: Generate all the possible products combination for each element in array arr[] with 
each element in array brr[]. Then sort the array of results and return the Kth element of the results array.

Time Complexity: O(N*M + (N+M) * Log(N+M))
Auxiliary Space: O(N+M)
*/

/*
Efficient Approach: This problem can be solved by using the Greedy Approach and Heaps. 

Sort the brr[] array.
Keep larger size array in the array arr[]. 
Create a max heap to store the elements with their respective indices.
Traverse each element from array arr[]. The element can be either positive or negative.
Positive:
	Multiply current element from arr[] with the largest element of sorted array brr[]. 
	To ensure that maximum element is obtained.
Negative:
	In this case multiply with the smallest value, i.e. with the first element from array brr[]. 
	This is due to the property of negation, as a larger value can be obtained by multiplying with the 
	smallest one.
Insert three values into heap such that : (product, i, j) where i & j are the indices of arrays arr[] and brr[]. 
Now run a for loop K times and pop elements from the heap.
Now check if the value present at arr[i] is positive or negative
Positive:
	So next_j = (current_j–1) because as max heap is been used, all the higher indices might have 
	been already popped from the heap.
Negative:
	next_j = (current_j+1) because all the smaller values yielding larger elements might have been 
	already popped from the heap.
Finally, return the answer
Note:  Max heap is implemented with the help of min-heap, by negating the signs of the 
       values while inserting them into the heap in Python.
*/

#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int KthLargestPairwiseProduct_solNaive(vector<int>&vec1, vector<int>&vec2, int k){
	vector<int>ans;
	int n=vec1.size();
	int m=vec2.size();
	for(int i=0; i<n; ++i){
		for(int j=0; j<m; ++j){
			int prod=vec1[i]*vec2[j];
			ans.push_back(prod);
		}
	}
	sort(ans.begin(), ans.end());
	reverse(ans.begin(), ans.end());
	return ans[k-1];
}

int KthLargestPairwiseProduct_Effi(vector<int>&vec1, vector<int>&vec2, int k){
	priority_queue<vector<int>, vector<vector<int>>>pq;
	int n=vec1.size();
	int m=vec2.size();
	int smSz, bgSz;
	vector<int>temp1;
	vector<int>temp2;
	if(n<m){
		temp1=vec1;
		temp2=vec2;
		smSz=temp1.size();
		bgSz=temp2.size();
		sort(temp1.begin(), temp1.end());
	} else if(m<n){
		temp1=vec2;
		temp2=vec1;
		smSz=temp1.size();
		bgSz=temp2.size();
		sort(temp1.begin(), temp1.end());
	}
	int x=1;
	int y=0;
	for(int i=0; i<bgSz; ++i){
		int currval=temp2[i];
		if(currval>=0){
			int prod=currval*temp1[smSz-x];
			pq.push({prod, i, smSz-x});
		} else{
			int prod=currval*temp1[y];
			pq.push({prod, i, y});
		}
	}
	k--;
	for(int i=0; i<k; ++i){
		vector<int>curr=pq.top();
		pq.pop();
		int val=curr[0], i_=curr[1], j_=curr[2];
		int next_j;
		if(temp2[i_]<0){
			next_j=j_+1;
		} else{
			next_j=j_-1;
		}	
		if(0<=next_j<smSz){
			int newVal=temp2[i_]*temp1[next_j];
			pq.push({newVal, i_, next_j});
		}
	}
	int ans=pq.top()[0];
	return ans;
}

int main(){
	vector<int>vec1{1, -2, 3};
	vector<int>vec2{3, -4, 0};
	int k=3;
	int ans=KthLargestPairwiseProduct_solNaive(vec1, vec2, k);
	cout<<ans;
	cout<<"\n-------\n";
	int ans_=KthLargestPairwiseProduct_Effi(vec1, vec2, k);
	cout<<ans_;
}