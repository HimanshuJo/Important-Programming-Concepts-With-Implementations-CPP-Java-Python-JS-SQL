#include <bits/stdc++.h>
using namespace std;

int main()
{
	vector<vector<int>> num{{1, 2},
							{3, 4},
							{5, 6}};
	unordered_map<int, vector<int>> gr;
	int sz = num.size();
	for (int i = 0; i < sz; ++i)
	{
		gr[num[i][0]].push_back(num[i][1]);
		gr[num[i][1]].push_back(num[i][0]);
	}
	for (const auto &pair : gr)
	{
		std::cout << "key: " << pair.first << "  value: [  ";

		for (int d : pair.second)
			std::cout << d << "  ";

		std::cout << "]\n";
	}
}