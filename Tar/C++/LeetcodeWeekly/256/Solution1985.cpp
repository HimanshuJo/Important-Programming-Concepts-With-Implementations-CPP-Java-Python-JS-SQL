#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string kthLargestNumber(vector<string>& nums, int k) {
        multimap<long long, string, greater <int>>res;
        long long mxLen=1;
        long long currMx=0;
        for (int i=0; i<nums.size(); ++i){
            string curr=nums[i];
            long long index=curr.length();
            long long tnMulp=10*index;
            index*=tnMulp;
            long long sm=0;
            for (int j=0; j<curr.length(); ++j){
                int currNm=curr[j]-'0';
                sm+=currNm*index;
                cout<<"sm: "<<sm<<endl;
                index/=10;
            }
            if (curr.length()>mxLen){
                mxLen=curr.length();
                long long ln=curr.length();
                long long tnMulp_=10*ln;
                while (tnMulp_>=10){
                    sm*=9*ln*tnMulp_;
                    tnMulp_/=10;
                }
            }
            currMx=max(sm, currMx);
            mxLen=max(mxLen, index);
            // if (curr.length()>1){
            //     long long ln=curr.length();
            //     long long tnMulp_=10*ln;
            //     while (tnMulp_>=10){
            //         sm*=100*ln*tnMulp_;
            //         tnMulp_/=10;
            //     }
            // }
            cout<<"-------"<<endl;
            res.insert(pair<int, string>(sm, curr));
        }
        int counter=0;
        string fn="";
        map<long long,string>::iterator it;
        for (it=res.begin() ; it!=res.end() ; it++){
            cout<<(*it).first<<" "<<(*it).second<<" ";
            // if (counter==k-1){
            //     fn=(*it).second;
            //     break;
            // }
            counter++;
            cout<<endl;
        }
        cout<<fn;
        return fn;
    }
};

int main(){
    Solution obj;
    vector<string>nums={"233","97"};
    int k=1;
    obj.kthLargestNumber(nums, k);
}