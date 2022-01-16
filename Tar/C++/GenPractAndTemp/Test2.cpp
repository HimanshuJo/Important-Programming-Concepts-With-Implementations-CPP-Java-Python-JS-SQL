class Solution {
public:
    bool possibleToStamp(vector<vector<int>>& grid, int stampHeight, int stampWidth) {
        int rws=grid.size()-1;
        int cols=grid[0].size()-1;
        stampHeight--;
        stampWidth--;
        for(int i=0; i<rws; ++i){
            for(int j=0; j<cols; ++j){
                if(grid[i][j]==0){
                    vector<vector<int>>tmpgrd=grid;
                    //cout<<"i, j "<<i<<" "<<j<<endl;
                    if(i+stampHeight<=rws&&j+stampWidth<=cols){
                        bool flag_=false;
                        for(int x=i; x<=i+stampHeight; ++x){
                            for(int y=j; y<=j+stampWidth; ++y){
                                //cout<<"x, y: "<<x<<" "<<y<<endl;
                                if(grid[x][y]!=1) grid[x][y]+=2;
                                else{
                                    flag_=true;
                                    grid.clear();
                                    grid=tmpgrd;
                                    break;
                                };
                            }
                            if(flag_) break;
                        }
                    } 
                    if(i-stampHeight>=0&&j+stampWidth<=cols){
                        bool flag_=false;
                        for(int x=i; x>=i-stampHeight; --x){
                            for(int y=j; y<=j+stampWidth; ++y){
                               if(grid[x][y]!=1) grid[x][y]+=2;
                                else{
                                    flag_=true;
                                    grid.clear();
                                    grid=tmpgrd;
                                    break;
                                };
                            }
                            if(flag_) break;
                        }
                    } 
                    if(i-stampHeight>=0&&j-stampWidth>=0){
                        bool flag_=false;
                        for(int x=i; x>=i-stampHeight; --x){
                            for(int y=j; y>=j-stampWidth; --y){
                                if(grid[x][y]!=1) grid[x][y]++;
                                else{
                                    flag_=true;
                                    grid.clear();
                                    grid=tmpgrd;
                                    break;
                                }
                                if(flag_) break;
                            }
                        }
                    } 
                    if(i+stampHeight<=rws&&j-stampWidth>=0){
                        bool flag_=false;
                        for(int x=i; x<=i+stampHeight; ++x){
                            for(int y=j; y>=j-stampWidth; --y){
                                if(grid[x][y]!=1) grid[x][y]+=2;
                                else{
                                    flag_=true;
                                    grid.clear();
                                    grid=tmpgrd;
                                    break;
                                };
                            }
                            if(flag_) break;
                        }
                    }
                }
                //cout<<"-------\n";
            }
        }
        bool flag=false;
        for(int i=0; i<=rws; ++i){
            for(int j=0; j<=cols; ++j){
                cout<<grid[i][j]<<" ";
                /*if(grid[i][j]==0){
                    flag=true;
                    break;
                }*/
            }
            cout<<endl;
        }
        if(!flag) return true;
        return false;
    }
};