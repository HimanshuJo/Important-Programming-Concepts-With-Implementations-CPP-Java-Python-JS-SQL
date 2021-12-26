class Solution {
public:
    
    bool isPalindrome(string word){
        int n=word.length();
        for(int i=0; i<n/2; ++i){
            if(word[i]!=word[n-i-1]) return false;
        }
        return true;
    }
    
    string firstPalindrome(vector<string>& words) {
        for(auto &vals: words){
            if(isPalindrome(vals)) return vals;
        }
        return "";
    }
};