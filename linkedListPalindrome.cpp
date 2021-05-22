// Time Complexity :O(N) where n is the number of nodes in the linked list
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    bool isPalindrome(ListNode* head) {
        ListNode *dummy = new ListNode(-1, head);
        if(!head->next) return true;
        ListNode *slow = dummy;
        ListNode *fast = dummy;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode *curr = slow->next;
        slow->next = nullptr;
        ListNode *nex = curr->next;
        ListNode *prev = nullptr;
        while(curr){
            curr->next = prev;
            prev = curr;
            curr = nex;
            if(nex)
                nex = nex->next;
        }
        curr = prev;
        while(curr){
            if(curr->val != head->val)
                return false;
            curr=curr->next;
            head = head->next;
        }
        return true;
    }
};