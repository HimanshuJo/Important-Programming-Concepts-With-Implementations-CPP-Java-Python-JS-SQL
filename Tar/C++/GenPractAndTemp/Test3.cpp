#include <bits/stdc++.h>
using namespace std;
 
typedef long long ll;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ll> vl;
typedef vector<vl> vvl;
double pi = acos(-1);
#define tezi        ios_base::sync_with_stdio(false);\
                    cin.tie(0);\
                    cout.tie(0);
#define FOR(i,a,b)  for(int i=a;i<b;i++)
#define FORR(i,b,a) for(int i=b;i>=a;i--)
#define fill(a,b)   memset(a,b,sizeof(a))
#define _time_      1.0 * clock() / CLOCKS_PER_SEC
#define fi          first
#define se          second
#define mp          make_pair 
#define pb          push_back
#define all(a)      a.begin(),a.end()
#define rev(a)      reverse(all(a))
#define reva(a,n)   reverse(a,a+n)
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
 
ll powerm(ll a,ll b,ll m){
    if(b==0) return 1;
    if(b&1) return a*powerm(a*a%m,b/2,m)%m;
    return powerm(a*a%m,b/2,m);
}
ll power(ll a,ll b){
    if(b==0) return 1;
    if(b&1) return a*power(a*a,b/2);
    return power(a*a,b/2);
}
ll sqroot(ll number){ 
    ll x = sqrt(number);
    while(x*x<number)x++;
    while(x*x>number)x--;
    return x;
}
ll cbroot(ll number){
    ll x = cbrt(number);
    while(x*x*x<number)x++;
    while(x*x*x>number)x--;
    return x;
}
 
const int maxn=1e5+5;
//bool prime[maxn];
 
 
const ll mod = 998244353;
ll dp[1005][1005][2];
 
int main(){
    tezi
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    //sieve
    //memset(prime,true,sizeof(prime)); 
    //for(ll p=2;p*p<maxn;p++)if(prime[p]==true)for(ll i=p*p;i<maxn;i+=p)prime[i]=false;
    string x,y;
    cin >> x >> y;
    int n = x.length();
    int m = y.length();
    x.pb('#');
    y.pb('#');
    vector<ll> suff1(n+1);
    suff1[n-1] = 1;
    for(int i=n-2;i>=0;i--){
    	int j;
    	for(j=i;j<n-1;j++){
    		if(x[j]==x[j+1]) break;
    	}
    	suff1[i] = j-i+1;
    }
	cout<<"-------\n";
	for(auto &vals: suff1){
		cout<<vals<<" ";
	}
	cout<<"\n-------\n";
    vector<ll> suff2(m+1);
    suff2[m-1] = 1;
    for(int i=m-2;i>=0;i--){
    	int j;
    	for(j=i;j<m-1;j++){
    		if(y[j]==y[j+1]) break;
    	}
    	suff2[i] = j-i+1;
    }
	for(auto &vals: suff2){
		cout<<vals<<" ";
	}
    for(int i=0;i<1005;i++)for(int j=0;j<1005;j++) dp[i][j][0]=dp[i][j][1]=0;
    for(int i=n-1;i>=0;i--){
    	for(int j=m-1;j>=0;j--){
    		dp[i][j][0] = (x[i]==x[i+1]?0:dp[i+1][j][0]) + (x[i]==y[j]?0:dp[i+1][j][1]) + (x[i]==y[j]?0:suff2[j]);
    		dp[i][j][0] %= mod;
    		dp[i][j][1] = (y[j]==y[j+1]?0:dp[i][j+1][1]) + (x[i]==y[j]?0:dp[i][j+1][0]) + (x[i]==y[j]?0:suff1[i]);
    		dp[i][j][1] %= mod;
    	}
    }
    ll ans=0;
    for(int i=0;i<n;i++){
    	for(int j=0;j<m;j++){
    		ans = (ans+dp[i][j][0] + dp[i][j][1])%mod;
    	}
    }
	cout<<endl;
    cout << ans;
    return 0;
}
