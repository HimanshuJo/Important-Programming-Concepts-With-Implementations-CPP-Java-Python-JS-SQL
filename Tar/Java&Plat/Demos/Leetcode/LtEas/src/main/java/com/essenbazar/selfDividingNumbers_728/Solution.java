package com.essenbazar.selfDividingNumbers_728;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number,
including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

 */

class Solution {

    private boolean isGood(int temp_right, int right) {
        while (temp_right > 0) {
            int temp_right_ = temp_right % 10;
            if (temp_right_ == 0) {
                return false;
            } else if (right % temp_right_ != 0) {
                return false;
            }
            temp_right = temp_right / 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if (left < 10 && right < 10) {
            for (int i = left; i < 10; i++) {
                list.add(i);
            }
        } else if (left < 10 && right >= 10) {
            for (int i = left; i < 10; i++) {
                list.add(i);
            }
            while (right >= 10) {
                int temp_right = right;
                if (isGood(temp_right, right) == true) {
                    list.add(right);
                }
                right--;
            }
        } else if (left >= 10 && right >= 10) {
            while (left >= 10 && left <= right) {
                int temp_left = left;
                if (isGood(temp_left, left) == true) {
                    list.add(left);
                }
                left++;
            }
        }
        Collections.sort(list);
        System.out.println(list.toString());
        return list;
    }
    
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	obj.selfDividingNumbers(15, 22);
    }
}

/*
#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:

    bool isGoodNum(int num, int pr){
        string numStr=to_string(num);
        for (int i=0; i<numStr.length(); ++i){
            int currNum=numStr[i]-'0';
            if (currNum==0 || pr%currNum!=0){
                return false;
            }
        }
        return true;
    }

    vector<int> selfDividingNumbers(int left, int right){
        vector<int> curr;
        if (left<10 && right<10){
            for (int i=left; i<10; ++i){
                curr.push_back(i);
            }
            sort(curr.begin(), curr.end());
            for (auto &num: curr){
                cout<<num<<" ";
            }
            return curr;
        } else if (left<10 && right>=10){
            for (int i=left; i<10; ++i){
                curr.push_back(i);
            }
            while (right>=10){
                int rgCp=right;
                if (isGoodNum(right, rgCp)){
                    curr.push_back(right);
                }
                right--;
            }
            sort(curr.begin(), curr.end());
            for (auto &num: curr){
                cout<<num<<" ";
            }
            return curr;
        } else {
            while (left<=right){
                int ltCp=left;
                if (isGoodNum(left, ltCp) == 1){
                    curr.push_back(left);
                }
                left++;
            }
            sort(curr.begin(), curr.end());
            for (auto &num: curr){
                cout<<num<<" ";
            }
            return curr;
        }
    }
};

int main(){
    Solution obj;
    obj.selfDividingNumbers(1,22);
}
*/