// Find All Groups of Farmland
/*
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
*/

#include <bits/stdc++.h>
using namespace std;

/*
class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>&mat) 
    {
        vector<vector<int>>ans;
        int n=mat.size();
        int m=mat[0].size();
        vector<pair<int,int>>d={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                vector<int>v;
                if(mat[i][j]==1)
                {
                    mat[i][j]=0;
                    v.push_back(i);
                    v.push_back(j);
                    queue<pair<int,int>>q;
                    q.push({i,j});
                    vector<int>res;
                    while(q.size())
                    {
                        res.clear();
                        auto temp=q.front();
                        q.pop();
                        int x=temp.first;
                        int y=temp.second;
                        res.push_back(x);
                        res.push_back(y);
                        for(auto it:d)
                        {
                            int nx=x+it.first;
                            int ny=y+it.second;
                            if(nx>=0&&ny>=0&&nx<n&&ny<m&&mat[nx][ny]==1)
                            {
                                mat[nx][ny]=0;
                                q.push({nx,ny});
                            }
                        }
                    }
                    for(int i=0;i<res.size();i++)
                    {
                        v.push_back(res[i]);
                    }
                    ans.push_back(v);
                }
            }
        }
        return ans;
    }
};
*/

class Solution
{
public:
    vector<vector<int>> findFarmland(vector<vector<int>> &a)
    {
        vector<vector<int>> ans;
        int n = a.size();
        int m = a[0].size();
        int offsets[] = {0, 1, 0, -1, 0};
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (a[i][j] == 1)
                {
                    pair<int, int> first = {i, j};
                    pair<int, int> last = first;
                    queue<pair<int, int>> todo;
                    todo.push({i, j});
                    a[i][j] = 0;
                    while (!todo.empty())
                    {
                        pair<int, int> p = todo.front();
                        todo.pop();
                        for (int k = 0; k < 4; k++)
                        {
                            int r = p.first + offsets[k], c = p.second + offsets[k + 1];
                            if (r >= 0 && r < n && c >= 0 && c < m && a[r][c] == 1)
                            {
                                a[r][c] = 0;
                                todo.push({r, c});
                                last = {r, c};
                                cout << r << " " << c << endl;
                            }
                        }
                    }
                    ans.push_back({first.first, first.second, last.first, last.second});
                }
            }
        }
        return ans;
    }
};