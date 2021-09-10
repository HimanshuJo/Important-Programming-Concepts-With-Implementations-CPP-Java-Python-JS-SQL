#include <algorithm>
#include <string>
#include <iostream>
#include <cctype>

using namespace std;

int main()
{
    string str1 = " Te x t with som e   spaces ";
    str1.erase(remove(str1.begin(), str1.end(), ' '),
               str1.end());
    cout << str1 << '\n';

    string str2 = " Te xt\n with\tsome \t  whitespaces\n \n ";
    str2.erase(remove_if(str2.begin(),
                         str2.end(),
                         [](unsigned char x)
                         { return std::isspace(x); }),
               str2.end());
    cout << str2 << '\n';

    return 0;
}