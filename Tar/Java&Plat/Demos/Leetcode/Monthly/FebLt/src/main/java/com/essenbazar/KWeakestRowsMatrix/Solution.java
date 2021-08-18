/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.KWeakestRowsMatrix;

/**
 *
 * @author himan
 */

/*

Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of
soldiers in row j, or they have the same number of soldiers but i is less than j.

Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

*/

/*

Sorting:

    PriorityQueue  --> hold int []
        where
            0th index gives num soldiers
            1st index gives index of that particular row

    Sorting PriorityQueue:

        MaxHeap  --> eliminating the max values
        
        given a and b  --> first we need to sort based on a[0] and b[0] in desc
            if a[0] =  b[0]  --> sort  according to index
                a[1] and b[1] in desc
*/

import java.util.*;

public class Solution {
    
    public int[] weakestRows(int[][] mat, int k) {
        
        // getting a sorted priority Queue
        // based on soldiers (b[0] - a[0])
        // based on indexes (b[1] - a[1])
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        
        int [] res = new int[k];
        
        // find soldiers in each row and put their number in the pq
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else break;
            }
            
            pq.offer(new int [] {soldiers, i});
        }
        
        // removing etra values from pq
        while (pq.size() > k) {
            pq.poll();
        }
        
        while (k > 0) {
            res[--k] = pq.poll()[1];
        }
        
        return res;
    }
    
}
