'''
A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum,
and both diagonal sums are all equal. The integers in the magic square do not have to be distinct.
Every 1 x 1 grid is trivially a magic square.

Given an m x n integer grid, return the size (i.e., the side length k) of the
largest magic square that can be found within this grid.

Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
Output: 3
Explanation: The largest magic square has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j] <= 106

'''

'''
This is particularly an implementation based question.
We have to check all the possible squares, within the grid

Furthermore for each of the square we have to check, all the rows and all the columns
    also the left and the right diagonal, whether they have the same sum or not
    
A small improvement we can make here is:
    given a particular grid of any dimensions, when we check in any of our rows and columns
    we don't have to check the rows and the columns one-by-one
    
    We can already calculate a preSum of each row and each column
        so that we can check for each row in O(1) time
'''


class Solution:
    def largestMagicSquare(self, grid):
        # initially we have to create a preSum for each row and column
        m = len(grid)
        n = len(grid[0])
        rowPreSum = []
        for i in range(m):
            # the actual preSum will be a list of dictionary
            # index will represent each row and the value will be a preSum dictionary
            preSum = {-1: 0}
            for j in range(n):
                preSum[j] = preSum[j - 1] + grid[i][j]
            rowPreSum.append(preSum)
        colPreSum = []
        # here we will be looping through the j first
        for j in range(n):
            preSum = {-1: 0}
            for i in range(m):
                preSum[i] = preSum[i - 1] + grid[i][j]
            colPreSum.append(preSum)
        # Now all that left is to find out the squares
        ans = 1
        print(rowPreSum)
        print(colPreSum)
        for i in range(m):
            for j in range(n):
                # The case for square of length 1 is already handled
                # Now we have to find the possible squares which could be larger than 1
                # What could be the largest square possible
                # That will be of length: m - i, n - j
                for length in range(2, min(m - i, n - j) + 1):
                    # for the sum of the first row, we have to find 2 indices as we already have the 
                    # required preSums
                    # the first index will be i, second will be j + length - 1
                    # then we subtract it with the preSum value at i, j - 1
                    # This sum can be served as a base checking condition for each row, column and diagonals
                    sum = rowPreSum[i][j + length - 1] - rowPreSum[i][j - 1]
                    diagonal = antiDiagonal = 0
                    flag = True
                    for l in range(length):
                        row = rowPreSum[i + l][j + length - 1] - rowPreSum[i + l][j - 1]
                        if row != sum:
                            flag = False
                            break
                        col = colPreSum[j + l][i + length - 1] - colPreSum[j + l][i - 1]
                        if col != sum:
                            flag = False
                            break
                        diagonal += grid[i + l][j + l]
                        antiDiagonal += grid[i + l][j + length - l - 1]
                    if flag and diagonal == antiDiagonal == sum:
                        ans = max(ans, length)
        print(ans)
        return ans

obj = Solution()
grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
obj.largestMagicSquare(grid)

'''
We are looping through each of the square. And for each of the square, we are also looping through the
    each row and column
Time: O(n^4)
'''
