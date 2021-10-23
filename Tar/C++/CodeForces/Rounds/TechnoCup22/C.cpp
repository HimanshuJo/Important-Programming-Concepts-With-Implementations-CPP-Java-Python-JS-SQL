#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, m;
    cin>>n>>m;  
    vector<vector<string>>grd;
    for(int i=0; i<n; ++i){
        vector<string>tmp;
        string in;
        cin>>in;
        tmp.push_back(in);
        grd.push_back(tmp);
    }
    vector<vector<string>>sm;
    vector<int>res;
    int q;
    cin>>q;
    for(int i=0; i<q; ++i){
        int x1, x2;
        cin>>x1>>x2;
        int l1=x1;
        int len=x2;
        l1--;
        len--;
        for(int i=0; i<grd.size(); ++i){
            string curr=grd[i][0];
            int idx=0;
            bool flag=false;
            int dotPre=0;
            int dotPost=0;
            int dotAl=0;
            for(int i=l1; i<=len; ++i){
                if(curr[i]=='X'){
                    idx=i;
                    flag=true;
                    break;
                }
            }
            if(flag){
                for(int i=l1; i<idx; ++i){
                    if(curr[i]=='.'){
                        dotPre++;
                    }
                }
                if(idx<=len-1){
                    for(int i=idx+1; i<=len; ++i){
                        if(curr[i]=='.'){
                            dotPost++;
                        }
                    }
                }
            } else{
                for(int i=l1; i<=len; ++i){
                    if(curr[i]=='.'){
                        dotAl++;
                    }
                }
            }
            vector<string>tmp;
            tmp.push_back(to_string(dotPre)+" "+to_string(dotPost)+" "+to_string(dotAl));
            sm.push_back(tmp);
        }
        bool flag_=false;
        for(auto &vals: sm){
            // for(auto &val: vals){
            //     cout<<val<<endl;
            // }
            vector<string>curr_=vals;
            //cout<<curr_[0][2]<<endl;
            int toChk=curr_[0][2]-'0';
            //cout<<toChk<<endl;
            if(!flag_){
                if(toChk>=1){
                    flag_=true;
                    res.push_back(0);
                }
            }
        }
        if(!flag_) res.push_back(1);
        sm.clear();
        //cout<<"\n-------"<<endl;
    }
    for(auto&vals: res){
        //cout<<vals<<" ";
        if(vals==0){
            cout<<"No\n";
        } else{
            cout<<"Yes\n";
        }
    }
}