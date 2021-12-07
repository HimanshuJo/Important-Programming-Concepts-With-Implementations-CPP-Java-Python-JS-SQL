// C++ program for the above approach

#include <bits/stdc++.h>
using namespace std;

// Stores the parent of each vertex
int parent[1000000];
int uRank[100000];
map<int, int> mp;
int maxVal = 0;

// Function to find the topmost
// parent of vertex a
int root(int a)
{
	// If current vertex is
	// the topmost vertex
	if (a == parent[a])
	{
		return a;
	}

	// Otherwise, set topmost vertex of
	// its parent as its topmost vertex
	return parent[a] = root(parent[a]);
}

// Function to connect the component
// having vertex a with the component
// having vertex b
void connect(int a, int b)
{
	// Connect edges
	a = root(a);
	b = root(b);
	if(a==b) return;
	if (uRank[a] < uRank[b])
		parent[a] = b;
	else if (uRank[b] < uRank[a])
		parent[b] = a;
	else
	{
		parent[b] = a;
		uRank[a]++;
	}
	/*cout << "urank " << a << " " << uRank[a] << endl;
	cout << "urank " << b << " " << uRank[b] << endl;
	cout << "parent " << a << " " << parent[a] << endl;
	cout << "parent " << b << " " << parent[b] << endl;
	if(parent[a]!=a) mp[parent[a]]++;
	if(parent[b]!=b) mp[parent[b]]++;
	cout<<"mp: "<<endl;*/
	int currmax=INT_MIN;
	int currParent=0;
	for (auto &entries : mp)
	{
		cout<<entries.first<<" "<<entries.second<<endl;
		if(entries.second>currmax){
			currmax=entries.second;
			currParent=entries.first;
		}
	}
	for (auto &entries : mp)
	{
		if(entries.first!=currParent){
			if(parent[entries.first]==currParent){
				currmax+=entries.second;
			}
		}
	}
	cout << "currmax " << currmax << endl;
	//cout << "-------\n";
}

void connectedComponents(int n)
{
	set<int> s;
	for (int i = 1; i <= n; i++)
	{
		s.insert(root(parent[i]));
	}
	//cout << s.size() << '\n';
}

void printAnswer(int N,
				 vector<vector<int>> edges)
{
	for (int i = 1; i <= N; i++)
	{
		parent[i] = i;
		uRank[i] = 0;
	}
	for (int i = 0; i < edges.size(); i++)
	{
		connect(edges[i][0], edges[i][1]);
	}
	//connectedComponents(N);
}

int main()
{
	int N = 7;

	// Given edges
	vector<vector<int>> edges = {
		{1, 2}, {3, 4}, {2, 4}, {7, 6}, {6, 5}, {1, 7}};

	// Function call
	printAnswer(N, edges);

	return 0;
}
