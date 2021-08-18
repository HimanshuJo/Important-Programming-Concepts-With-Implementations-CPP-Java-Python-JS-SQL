package com.essenbazar.matrixDiagonalSum_1572;

/*

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the
secondary diagonal that are not part of the primary diagonal.

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

 */

import java.util.*;

class Solution {

    public int diagonalSum(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list_ = new ArrayList<>();
        int res = 0;
        int j = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            int[] arr = mat[i];
            int[] arr_ = mat[j];
            list.add(arr[i]);
            if (i != j) {
                list_.add(arr_[i]);
            }
            map.put(0, list);
            map.put(1, list_);
            j--;
        }
        int[] arr1 = map.get(0).stream().mapToInt(i -> i).toArray();
        int[] arr2 = map.get(1).stream().mapToInt(i -> i).toArray();
        for (int num : arr1) {
            res += num;
        }
        for (int num : arr2) {
            res += num;
        }
        return res;
    }
}

/*
#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
    int diagonalSum(vector<vector<int>> mat) {
        int ltDiogSm=0;
        int rtDiogSm=0;
        int igNum=mat.size()/2;
        for (int i=0; i<mat.size(); ++i){
            vector<int> temp=mat[i];
            ltDiogSm+=temp[i];
        }
        int j=mat.size()-1;
        for (int i=0; i<mat.size(); ++i){
            if (i!=igNum){
                vector<int> temp=mat[i];
                rtDiogSm+=temp[j];
            }
            --j;
        }
        cout<<ltDiogSm+rtDiogSm;
        return ltDiogSm+rtDiogSm;
    }
};  

int main(){
    Solution obj;
    vector<vector<int>> mat = {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
    obj.diagonalSum(mat);
}

*/