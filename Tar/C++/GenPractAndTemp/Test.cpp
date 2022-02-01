#include <cstring>
#include <string>
#include <iostream>
#include<vector>
#include<algorithm>
#include<unordered_set>

using namespace std;

const char *low_alpha = "qwertyuiopasdfghjklzxcvbnm";

int main()
{
    unordered_set<int>combs{2, 1, 0, 3, 4};
    unordered_set<int>::iterator iter = combs.begin();
    int sz=combs.size();
    std::advance(iter, 3);
    int mid=*iter;
    cout<<mid<<endl;
}