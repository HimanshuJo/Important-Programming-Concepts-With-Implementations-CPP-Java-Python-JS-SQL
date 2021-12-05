#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define mp make_pair
#define F first
#define S second

int x[] = {1, 0, -1, 0};
int y[] = {0, 1, -0, -1};

int main()
{
	//     std::ios_base::sync_with_stdio(false);

#ifdef kimbbakar
	freopen("in.txt", "r", stdin);
	//        freopen ( "out.txt", "w", stdout );
#endif

	int r;
	int cl;
	cin >> r >> cl;

	char g[505][505];
	int mark[505][505] = {0};

	for (int i = 1; i <= r; i++)
	{
		for (int j = 1; j <= cl; j++)
			scanf(" %c", &g[i][j]);
	}

	int a, b, c, d;
	cin >> a >> b >> c >> d;

	queue<pair<int, int>> q;

	q.push(mp(a, b));

	mark[a][b] = 1;

	bool ok = false;

	if (g[c][d] == 'X')
	{
		cout<<"here1"<<endl;
		while (!q.empty() && !ok)
		{
			pair<int, int> nw = q.front();
			q.pop();

			//            printf("nw %d %d\n",nw.F,nw.S);

			for (int i = 0; i < 4; i++)
			{
				pair<int, int> k = mp(nw.F + x[i], nw.S + y[i]);
				//          printf("k %d %d\n",k.F,k.S);
				if (!mark[k.F][k.S] && g[k.F][k.S] != 'X' && k.F >= 1 && k.S >= 1 && k.F <= r && k.S <= cl)
				{
					mark[k.F][k.S] = 1 + mark[nw.F][nw.S];
					q.push(k);
				}
				else if (k.F == c && k.S == d)
				{
					cout<<"here2"<<endl;
					mark[k.F][k.S] = 1 + mark[nw.F][nw.S];

					ok = true;
					break;
				}
			}
		}
	}
	else
	{
		while (!q.empty() && !ok)
		{
			pair<int, int> nw = q.front();
			q.pop();

			for (int i = 0; i < 4; i++)
			{
				pair<int, int> k = mp(nw.F + x[i], nw.S + y[i]);

				if (!mark[k.F][k.S] && g[k.F][k.S] != 'X' && k.F >= 1 && k.S >= 1 && k.F <= r && k.S <= cl)
				{
					mark[k.F][k.S] = 1 + mark[nw.F][nw.S];
					q.push(k);
					g[k.F][k.S] = 'X';
				}
				else if (k.F == c && k.S == d && g[k.F][k.S] == 'X')
				{
					mark[k.F][k.S] = 1 + mark[nw.F][nw.S];

					ok = true;
					break;
				}
			}
		}
	}

	if (ok)
		printf("YES\n");
	else
		printf("NO\n");

	return 0;
}