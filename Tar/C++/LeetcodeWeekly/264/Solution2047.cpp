#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void tokenize(string const &str, const char delim, vector<string> &out) 
    { 
        stringstream ss(str); 
        string s; 
        while (getline(ss, s, delim)) { 
            out.push_back(s); 
        } 
    }

    int countValidWords(string sentence) {
        vector<string>curr;
        tokenize(sentence, ' ', curr);
        int ans=0;
        for(int x=0; x<curr.size(); ++x){
            string vals=curr[x];
            if(vals[0]=='!'||vals[0]=='-'||vals[vals.length()-1]=='-'||isspace(vals[0])){
                continue;
            }
            cout<<vals<<endl;
            for(int i=0; i<vals.length(); ++i){
                if(isdigit(vals[i])){
                    continue;
                }
                else if(vals[vals.length()-1]=='!'){
                    if(x!=curr.size()-1){
                        continue;
                    }
                }
                else if(vals[i]=='-'){
                    bool flag=false;
                    for(int j=0; j<i; ++j){
                        if(isdigit(vals[j])){
                            flag=true;
                            break;
                        }
                    }
                    for(int j=i+1;j<vals.length()-1; ++j){
                        if(isdigit(vals[j])){
                            flag=true;
                            break;
                        }
                    }
                    if(flag) continue;
                }
            }   
            ans++;
        }
        return ans;
    }
};

int main(){
    Solution obj;
    string sentence="cat and  dog";
    obj.countValidWords(sentence);
}