
/*

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> llist = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            if (i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                llist.add(list);
            }

            else if (i == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(1);
                llist.add(list);
            } else {
                List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 0));
                list.set(0, 1);
                list.set(list.size() - 1, 1);
                List<Integer> temp = llist.get(i - 1);

                int index = 0;
                for (int x = 1; x < i; ++x) {
                    list.set(x, temp.get(index) + temp.get(index + 1));
                    index++;
                }

                llist.add(list);
            }
        }

        return llist;
    }
}