// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head == NULL){
            return true;
        }
        ListNode* start = head;
        ListNode* end = head;
        while(end->next != NULL && end->next->next != NULL){
            start = start->next;
            end = end->next->next;
        }
        start->next = reverseList(start->next);
        start = start->next;
        while(start != NULL){
            if(start->val != head->val)
                return false;
            start = start->next;
            head = head->next;
        }
        return true;
    }
    
    ListNode* reverseList(ListNode* head){
        if(head == NULL || head->next == NULL){
            return head;
        }
        ListNode* node = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return node;
    }
};
