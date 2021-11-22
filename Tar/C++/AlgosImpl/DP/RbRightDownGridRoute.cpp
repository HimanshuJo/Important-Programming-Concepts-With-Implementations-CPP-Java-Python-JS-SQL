#include<iostream>
#include<vector>
#include<set>
using namespace std;

bool getPath(vector<vector<bool>>&maze, int rw, int col, vector<pair<int, int>>&path, set<pair<int, int>>&seenCoords){
	if(col<0||rw<0||!maze[rw][col]) return false;
	pair<int, int>curr={rw, col};
	auto it=seenCoords.find(curr);
	if(it!=seenCoords.end()) return false;
	bool isAtOrigin=(rw==0)&&(col==0);
	if(isAtOrigin||getPath(maze, rw, col-1, path, seenCoords)||getPath(maze, rw-1, col, path, seenCoords)){
		path.push_back(curr);
		return true;
	}
	seenCoords.insert(curr);
	return false;
}

vector<pair<int, int>> getpath(vector<vector<bool>>maze){
	int n=maze.size();
	if(n==0) return {make_pair(0, 0)};
	vector<pair<int, int>>path;
	set<pair<int, int>>seenCoords;
	if(getPath(maze, n-1, maze[0].size(), path, seenCoords)) return path;
	return {make_pair(0, 0)};
}

int main(){
}
