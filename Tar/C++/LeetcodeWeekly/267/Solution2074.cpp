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

	ListNode* reverse(ListNode* head)
	{
		ListNode* prev = NULL;
		ListNode* curr = head;

		while (curr) {
			ListNode* next = curr->next;
			curr->next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	ListNode* reverseBetween(ListNode* head, int m, int n)
	{
		if (m == n)
			return head;
		ListNode* revs = NULL, *revs_prev = NULL;
		ListNode* revend = NULL, *revend_next = NULL;
		int i = 1;
		ListNode* curr = head;
		while (curr && i <= n) {
			if (i < m)
				revs_prev = curr;

			if (i == m)
				revs = curr;

			if (i == n) {
				revend = curr;
				revend_next = curr->next;
			}

			curr = curr->next;
			i++;
		}
		revend->next = NULL;
		revend = reverse(revs);
		if (revs_prev)
			revs_prev->next = revend;
		else
			head = revend;

		revs->next = revend_next;
		return head;
	}


	ListNode* reverseEvenLengthGroups(ListNode* head) {
		ListNode* tmp = head;
		vector<int>nums;
		while (tmp->next != nullptr) {
			nums.push_back(tmp->val);
			tmp = tmp->next;
		}
		nums.push_back(tmp->val);
		vector<pair<int, int>>tmp_;
		int i = 0;
		int ii = 1;
		int idx = 2;
		tmp_.push_back({i, i});
		while (i != nums.size() - 1) {
			i += idx;
			if (i >= nums.size()) {
				tmp_.push_back({i - ii, nums.size() - 1});
				break;
			}
			tmp_.push_back({i - ii, i});
			idx++;
			ii++;
		}
		for (auto &vals : tmp_) {
			if (abs(vals.first - vals.second) & 1) {
				reverseBetween(head, vals.first + 1, vals.second + 1);
			}
			//cout<<vals.first<<" "<<vals.second<<endl;
		}
		return head;
	}
};