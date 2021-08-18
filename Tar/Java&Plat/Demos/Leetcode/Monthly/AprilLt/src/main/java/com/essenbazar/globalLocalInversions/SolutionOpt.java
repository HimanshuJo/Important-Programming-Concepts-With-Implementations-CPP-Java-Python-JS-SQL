/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.globalLocalInversions;

/**
 *
 * @author himanshu
 */

/*

Intution:

    All local inversions are global inversions

    If the number of global inversions is equal to the number of local inversions,
        it means that all the global inversions in permutations are local inversions

        it also mean that, we can't find A[i] > A[j] with i + 2 <= j

        In other words, max(A[i]) < A[i + 2]

*/

public class SolutionOpt {
    public boolean isIdealPermutation(int [] A) {
        int cmax = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            
            if (cmax > A[i + 2]) return false;
        }
        
        return true;
    }
}
