// 741. Cherry Pickup
/*
   You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

   0 means the cell is empty, so you can pass through,
   1 means the cell contains a cherry that you can pick up and pass through, or
   -1 means the cell contains a thorn that blocks your way.

   Return the maximum number of cherries you can collect by following the rules below:

   Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
   After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.

   When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
   If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.

Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
Output: 5
Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
 */

class Solution {
	public:
		
		int memo[51][51][51][51];

		bool areValidCoords(int r1, int c1, int r2, int c2, vector<vector<int>>&grid, int n){
			return (r1>n-1||c1>n-1||r2>n-1||c2>n-1||grid[r1][c1]==-1||grid[r2][c2]==-1||r1<0||r2<0||c1<0||c2<0);
		}

		int dfs(int r1, int c1, int r2, int c2, vector<vector<int>>&grid, int n){
			if(areValidCoords(r1, c1, r2, c2, grid, n)) return INT_MIN;
			if(r1==c1&&c1==n-1) return grid[r1][c1];
			if(memo[r1][c1][r2][c2]!=-1) return memo[r1][c1][r2][c2];
			int currCherry=0;
			if(r1==r2&&c1==c2){
				currCherry=grid[r1][c1];
			} else{
				currCherry=grid[r1][c1]+grid[r2][c2];
			}
			vector<vector<int>>dir={{1, 0}, {0, 1}};
			int nextCherry=INT_MIN;
			for(auto &dirs: dir){
				for(auto &dirs_: dir){
					int nr1=r1+dirs[0];
					int nc1=c1+dirs[1];
					int nr2=r2+dirs_[0];
					int nc2=c2+dirs_[1];
					nextCherry=max(nextCherry, dfs(nr1, nc1, nr2, nc2, grid, n));
				}
			}
			currCherry+=nextCherry;
			return memo[r1][c1][r2][c2]=currCherry;
		}

		int cherryPickup(vector<vector<int>>& grid) {
			int n=grid.size();
			for(int i=0; i<n; ++i){
				for(int j=0; j<n; ++j){
					for(int x=0; x<n; ++x){
						for(int y=0; y<n; ++y){
							memo[i][j][x][y]=-1;
						}
					}
				}
			}
			int res=dfs(0, 0, 0, 0, grid, n);
			int finalRes=res>0?res:0;
			return finalRes;
		}
};

int main(){
	vector<vector<int>>grid{{0,1,-1}, {1,0,-1}, {1,1,1}};
	Solution obj;
	cout<<obj.cherryPickup(grid);
}
