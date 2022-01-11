// 994. Rotting Oranges
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) 
is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

class Solution {
public:
    
    bool areValidCoords(int rw, int col, vector<vector<int>>&grid){
        return (rw>=0&&col>=0&&rw<grid.size()&&col<grid[0].size()&&grid[rw][col]==1);
    }
    
    int orangesRotting(vector<vector<int>>& grid) {
        int time=0, freshOrng=0;
        int rw=grid.size(), col=grid[0].size();
        queue<pair<int, int>>q;
        for(int i=0; i<rw; ++i){
            for(int j=0; j<col; ++j){
                if(grid[i][j]==1){
                    freshOrng++;
                } else if(grid[i][j]==2){
                    q.push({i, j});
                }
            }
        }
        vector<vector<int>>directions{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.empty()&&freshOrng>0){
            int qSz=q.size();
            while(qSz--){
                pair<int, int>curCord=q.front();
                q.pop();
                for(auto &dir: directions){
                    int nwRw=curCord.first+dir[0];
                    int nwCol=curCord.second+dir[1];
                    if(areValidCoords(nwRw, nwCol, grid)){
                        q.push({nwRw, nwCol});
                        grid[nwRw][nwCol]=2;
                        freshOrng--;
                    }
                }
            }
            time++;
        }
        return freshOrng==0?time:-1;
    }
};