#include<bits/stdc++.h>
using namespace std;

int main(){
    int t=1;
    while (t--){
        int N, M;
        cin>>N>>M;
        vector<int>sArr;
        vector<int>tArr;
        vector<int>rArr;
        int start=1;
        for (int i=0; i<N; ++i){
            int tm;
            cin>>tm;
            sArr.push_back(tm);
        }
        for (int i=0; i<M; ++i){
            int tm;
            cin>>tm;
            tArr.push_back(tm);
        }
        if (N==M&&sArr[0]==tArr[0]&&N==1){
            cout<<1;
        } else {
            int index=0;
            int ans=0;
            bool flag=false;
            while (true){
                if (sArr[0]==tArr[index]){
                    rArr.push_back(sArr[0]);
                    index++;    
                } else {
                    vector<int>cpy(sArr.begin(), sArr.end());
                    rotate(cpy.begin(), cpy.begin()+start, cpy.end());
                    if (cpy[0]==tArr[index]){
                        ans++;
                        rArr.push_back(cpy[0]);
                        index++;
                        sArr.clear();
                        sArr=cpy;
                    } else {
                        cpy.clear();
                        cpy=sArr;
                        rotate(cpy.begin(), cpy.begin()+cpy.size()-start, cpy.end());
                        if (cpy[0]==tArr[index]){
                            ans++;
                            rArr.push_back(cpy[0]);
                            index++;
                            sArr.clear();
                            sArr=cpy;
                        } else {
                            cpy.clear();
                            cpy=sArr;
                            rotate(cpy.begin(), cpy.begin()+start, cpy.end());
                            int prev=cpy[0];
                            while (true){
                                start++;
                                rotate(cpy.begin(), cpy.begin()+start, cpy.end());
                                if (cpy[0]!=prev){
                                    break;
                                }
                                if (start==N&&cpy[0]==prev){
                                    cout<<-1;
                                    continue;
                                }
                                if (start==N&&cpy[0]!=prev){
                                    break;
                                }
                            }
                            ans++;
                            rArr.push_back(cpy[0]);
                            index++;
                            sArr.clear();
                            sArr=cpy;
                        }
                    }
                }
                ans++;
                if (index==M){
                    break;
                }
            }
            if (!flag)
                cout<<ans<<"\n";
        }
    }
}