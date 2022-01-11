class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        int n=matrix.size();
        set<int>temp1; // col mat
        set<int>temp2;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                temp1.insert(matrix[i][j]);
                temp2.insert(matrix[j][i]);
            }
            for(int x=1; x<=n; ++x){
                auto it=temp1.find(x);
                if(it==temp1.end()) return false;
                auto it2=temp2.find(x);
                if(it2==temp2.end()) return false;
            }
            temp1.clear();
            temp2.clear();
        }
        return true;
    }
};