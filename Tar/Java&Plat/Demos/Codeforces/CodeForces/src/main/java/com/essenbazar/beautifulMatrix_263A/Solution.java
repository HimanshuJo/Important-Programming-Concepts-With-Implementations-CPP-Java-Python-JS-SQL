package com.essenbazar.beautifulMatrix_263A;
/*

You've got a 5 × 5 matrix, consisting of 24 zeroes and a single number one. 

Let's index the matrix rows by numbers from 1 to 5 from top to bottom, let's index the 
matrix columns by numbers from 1 to 5 from left to right. 

In one move, you are allowed to apply one of the two following transformations to the matrix:

    Swap two neighboring matrix rows, that is, rows with indexes i and i + 1 for some integer i (1 ≤ i < 5).
    Swap two neighboring matrix columns, that is, columns with indexes j and j + 1 for some integer j (1 ≤ j < 5). 

You think that a matrix looks beautiful, if the single number one of the matrix is located in 
its middle (in the cell that is on the intersection of the third row and the third column). 
Count the minimum number of moves needed to make the matrix beautiful.

Input

The input consists of five lines, each line contains five integers: the j-th integer 
in the i-th line of the input represents the element of the matrix that is located on 
the intersection of the i-th row and the j-th column. 

It is guaranteed that the matrix consists of 24 zeroes and a single number one.

Output

Print a single integer — the minimum number of moves needed to make the matrix beautiful.

Examples

Input

0 0 0 0 0
0 0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0

Output
3

 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			List<List<Integer>> llist = new ArrayList<>();
			for (int ii = 0; ii < 5; ++ii) {
			    List<Integer> list = new ArrayList<>();
			    for (int i = 0; i < 5; ++i) {
			        int num = sc.nextInt();
			        list.add(num);
			    }
			    llist.add(list);
			}

			for (int x = 0; x < llist.size(); ++x) {
			    List<Integer> temp;
			    temp = llist.get(x);
			    for (int j = 0; j < temp.size(); ++j) {
			        switch (x) {
			            case 0 -> {
			                if (temp.get(4) == 1 || temp.get(0) == 1) {
			                    System.out.println(4);
			                    return;
			                } else if (temp.get(3) == 1 || temp.get(1) == 1) {
			                    System.out.println(3);
			                    return;
			                } else if (temp.get(2) == 1) {
			                    System.out.println(2);
			                    return;
			                }
			            }
			            case 1 -> {
			                if (temp.get(4) == 1 || temp.get(0) == 1) {
			                    System.out.println(3);
			                    return;
			                } else if (temp.get(3) == 1 || temp.get(1) == 1) {
			                    System.out.println(2);
			                    return;
			                } else if (temp.get(2) == 1) {
			                    System.out.println(1);
			                    return;
			                }
			            }
			            case 2 -> {
			                if (temp.get(4) == 1 || temp.get(0) == 1) {
			                    System.out.println(2);
			                    return;
			                } else if (temp.get(3) == 1 || temp.get(1) == 1) {
			                    System.out.println(1);
			                    return;
			                } else if (temp.get(2) == 1) {
			                    System.out.println(0);
			                    return;
			                }
			            }
			            case 3 -> {
			                if (temp.get(4) == 1 || temp.get(0) == 1) {
			                    System.out.println(3);
			                    return;
			                } else if (temp.get(3) == 1 || temp.get(1) == 1) {
			                    System.out.println(2);
			                    return;
			                } else if (temp.get(2) == 1) {
			                    System.out.println(1);
			                    return;
			                }
			            }
			            default -> {
			                if (temp.get(4) == 1 || temp.get(0) == 1) {
			                    System.out.println(4);
			                    return;
			                } else if (temp.get(3) == 1 || temp.get(1) == 1) {
			                    System.out.println(3);
			                    return;
			                } else if (temp.get(2) == 1) {
			                    System.out.println(2);
			                    return;
			                }
			            }
			        }
			    }
			}
		}
    }
}
