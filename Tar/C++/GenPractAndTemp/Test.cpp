class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int>combNums=nums;
        for(auto &vals: nums)
            combNums.push_back(vals);
        unordered_multimap<int, vector<int>>mp;
        stack<int>stk;
        int n=combNums.size();
        for(int i=0; i<n; ++i){
            while(!stk.empty()&&combNums[i]>stk.top()){
                mp.insert(pair<int, vector<int>>(stk.top(), {combNums[i], i}));
                stk.pop();
            }
            stk.push(combNums[i]);
        }
        auto it=mp.begin();
        while(it!=mp.end()){
            if((*it).second[1]>=n/2){
                it=mp.erase(it);
            } else it++;
        }
        for(auto &entries: mp){
            cout<<entries.first<<" : ";
            for(auto &vals: entries.second)
                cout<<vals<<" ";
            cout<<endl;
        }
        vector<int>res;
        int i=0;
        cout<<endl;
        for(auto &vals: nums){
            auto it=mp.find(vals);
            if(it!=mp.end()) cout<<(*it).second[0]<<endl;
            if(it!=mp.end()){
                int num=(*it).second[0];
                res.push_back(num);
            } else res.push_back(-1);
        }
        return res;
    }
};