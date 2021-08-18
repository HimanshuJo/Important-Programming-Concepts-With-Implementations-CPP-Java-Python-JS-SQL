
public class Solution
{

    public int numIslands(char[][] grid)
    {

        int num_of_islands = 0;

        int rows = grid.length;

        if (rows == 0)
        {
            return 0;
        }

        int columns = grid[0].length;

        for (int i = 0; i < rows ; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (grid[i][j] == '1')
                {
                    DFS_island(grid, i, j, rows, columns);
                    num_of_islands += 1;
                }
            }
        }

        return num_of_islands;

    }

    private void DFS_island(char[][] grid, int i, int j, int rows, int columns)
    {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] != '1')
        {
            return;
        }
        grid[i][j] = '2';
        DFS_island(grid, i + 1, j, rows, columns);
        DFS_island(grid, i, j + 1, rows, columns);
        DFS_island(grid, i - 1, j, rows, columns);
        DFS_island(grid, i, j - 1, rows, columns);
    }
}
