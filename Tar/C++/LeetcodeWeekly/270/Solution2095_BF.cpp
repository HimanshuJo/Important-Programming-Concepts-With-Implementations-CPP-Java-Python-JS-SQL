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
        ListNode* temp2=head;
        vector<int>szVec;
        while(temp2){
            szVec.push_back(temp2->val);
            temp2=temp2->next;
        }
        if(szVec.size()==1)
            return nullptr;
        vector<int>temp;
        int sz=szVec.size()/2;
        int cnt=0;
        ListNode* dummy1=new ListNode();
        while(cnt!=sz){
            temp.push_back(head->val);
            head=head->next;
            cnt++;
        }
        head=head->next;
        while(head){
            temp.push_back(head->val);
            head=head->next;
        }
        int n=temp.size();
        cnt=0;
        ListNode* dummy2=dummy1;
        dummy1->val=temp[0];
        for(int i=1; i<n; ++i){
            dummy1->next=new ListNode();
            dummy1->next->val=temp[i];
            dummy1=dummy1->next;
        }

        return dummy2;
    }
};