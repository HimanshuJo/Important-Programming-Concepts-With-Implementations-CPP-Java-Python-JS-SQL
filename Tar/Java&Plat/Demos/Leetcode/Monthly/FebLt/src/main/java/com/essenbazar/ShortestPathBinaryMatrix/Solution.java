package com.essenbazar.ShortestPathBinaryMatrix;

/**
 *
 * @author himan
 */

/*

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of
cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and
share an edge or corner)

C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

Return the length of the shortest such clear path from top-left to bottom-right.
If such a path does not exist, return -1.

 */

 /*

If we take a middle cell in a 3*3 grid, from that cell we can move to
up, down, left, right, diagonal left up, diagonal left down, diagonal right up, diagonal right down
so the directions can be represented as:
x, y + 1
x, y - 1
x + 1, y
x - 1, y
x + 1, y + 1
x + 1, y - 1
x - 1, y + 1
x - 1, y - 1

In our grid, the blocking cells (containing 1 can be marked as 'cross' or unwanted)
Initially we will be at grid[0][0] and step will be 1
When we move to further cells, we can mark the cells from which we have come as already visited

 */
import java.util.*;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();  // for storing the directions

        // first two zeros are for x and y coordinates, last number is for initial count/step
        queue.add(new int[]{0, 0, 1});  // adding initial cell to visited
        grid[0][0] = 1;  // mark the initial grid as visited

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();  // will give the first level of the nearest nodes
            while (size-- > 0) {
                // I am still at the same level
                int[] point = queue.poll();

                // checking if I am at the bottom right corner or not
                if (point[0] == m - 1 && point[1] == n - 1) {
                    return point[2];
                }

                for (int[] d : dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    // checking boundary conditions
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        // as the above is only the valid conditon so putting it in the queue
                        queue.add(new int[]{r, c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return -1;
    }
    
    public int shortestPathBinaryMatrix_2(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        return helper_bfs(grid, queue, dir, m, n);
    }

    private int helper_bfs(int[][] grid, Queue<int[]> queue, int[][] dir, int m, int n) {
        int steps = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();  // will give the first level of the nearest nodes
            while (size-- > 0) {
                // I am still at the same level
                int[] point = queue.poll();

                // checking if I am at the bottom right corner or not
                if (point[0] == m - 1 && point[1] == n - 1) {
                    steps = point[2];
                    break;
                }

                for (int[] d : dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    // checking boundary conditions
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        // as the above is only the valid conditon so putting it in the queue
                        queue.add(new int[]{r, c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        
        return steps;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(my_obj.shortestPathBinaryMatrix_2(grid));
    }
}
