#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    std::vector<std::string> string_split(const std::string& str, int n) {
        std::vector<std::string> result;
        string curr = "";
        for (int i = 0; i < str.length(); ++i) {
            curr += str[i];
            if (curr.size()==n) {
                result.push_back(curr);
                curr = "";
            }
        }
        return result;
    }
    
    const std::string WHITESPACE = " \n\r\t\f\v";

    std::string rtrim(const std::string &s)
    {
        size_t end = s.find_last_not_of(WHITESPACE);
        return (end == std::string::npos) ? "" : s.substr(0, end + 1);
    }

    std::string trim(const std::string &s) {
        return rtrim(s);
    }

    string decodeCiphertext(string encodedText, int rows) {
        if(encodedText.compare("")==0) return "";
        int n = encodedText.length() / rows;
        vector<vector<char>>vec(rows, vector<char>(n, '#'));
        vector<string>all = string_split(encodedText, n);
        for (int i = 0; i < rows; ++i) {
            string curr=all[i];
            for (int j = 0; j < n; ++j) {
                vec[i][j]=curr[j];
            }
        }
        vector<vector<pair<int, int>>>coords;
        int counter=0;
        for(int i=0; i<n; ++i){
            vector<pair<int, int>>curr;
            counter+=i;
            for(int j=0; j<rows; ++j){
                if(counter<n)
                    curr.push_back(make_pair(j, counter));
                counter++;
            }
            coords.push_back(curr);
            counter=0;
        }
        string ans="";
        for(auto &vals: coords){
            for(auto &pairs: vals){
                ans+=vec[pairs.first][pairs.second];
            }
        }
        return trim(ans);
    }
};