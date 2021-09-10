#include<bits/stdc++.h>
using namespace std;

int main(){
  multiset<set<int>>s;
  set<int>s1={1,2};
  set<int>s2={1,2};
  set<int>s3={1,2};
  //set<int>s4={3, 4};
  s.insert(s1);
  s.insert(s2);
  s.insert(s3);
  //s.insert(s4);
  int sz=s.size();
  bool flag=false;
  bool flag2=false;
  while (true){
    if (s.empty()){
      flag=true;
      break;
    }
    if (flag2||flag){
      break;
    }
    for (int i=0; i<sz-1; ++i){
      set<int>curr=*next(s.begin(),i);
      set<int>nxt=*next(s.begin(),i+1);
      int currBeg=*next(curr.begin(),0);
      int nxtBeg=*next(nxt.begin(),0);
      if (currBeg!=nxtBeg){
        flag2=true;
        break;
      }
      if (s.empty()){
        flag=true;
        break;
      }
      int len=min(curr.size(), nxt.size());
      for (int x=0; x<len; ++x){
        int eleCurr=*next(curr.begin(),x);
        int eleNxt=*next(nxt.begin(),x);
        if (eleCurr==eleNxt){
          curr.erase(eleCurr);
          nxt.erase(eleNxt);
        } else{
          break;
        }
        if (s.empty()){
          flag=true;
          break;
        }
      }
    }
  }
  if (flag){
    cout<<"YES";
  } else {
    cout<<"NO";
  }
}