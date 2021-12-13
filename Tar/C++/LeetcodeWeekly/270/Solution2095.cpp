/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    ListNode* deleteMiddle(ListNode* head) {
        ListNode* temp1=head;
        ListNode* temp2=head;
        vector<int>szVec;
        while(temp2){
            szVec.push_back(temp2->val);
            temp2=temp2->next;
        }
        if(szVec.size()==1)
            return nullptr;
        if(szVec.size()==2){
            head->next=nullptr;
            return head;
        }
        int sz=szVec.size()/2;
        int cnt=0;
        while(cnt!=sz-1){
            head=head->next;
            cnt++;
        }
        ListNode* temp_=head->next->next;
        head->next->next=nullptr;
        head->next=temp_;
        return temp1;
    }
};