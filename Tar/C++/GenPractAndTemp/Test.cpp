#include <bits/stdc++.h>
#include<regex>
using namespace std;

int main()
{
    string s = "   1 sdasd s    adasd    ";
    cout<<s.length()<<endl;
    s=regex_replace(s, regex("^ +"), "");
    cout<<s.length()<<endl;
    s=regex_replace(s, regex(" +$"), " ");
    cout<<s<<" "<<s.length()<<endl;
}