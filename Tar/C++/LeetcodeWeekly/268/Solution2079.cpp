#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
 		int stps=0;
		int counter=0;
		int tmpCap=capacity;
		for(int i=0; i<plants.size(); ++i){
			if(tmpCap>=plants[i]){
				stps++;
				tmpCap-=plants[i];
			} else{
				stps+=counter;
				stps+=(i+1);
				tmpCap=capacity;
				tmpCap-=plants[i];
			}
			counter++;
		}
		return stps;
    }
};
