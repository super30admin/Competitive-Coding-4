// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next!=NULL && fast->next->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        slow->next = reverseList(slow->next);
        slow = slow->next;
        ListNode *temp = head;
        while(slow!=NULL){
            if(temp->val != slow->val){
                return false;
            }
            temp = temp->next;
            slow = slow->next;
        }
        return true;
        
    }
    
    ListNode* reverseList(ListNode* head){
        ListNode* prev = NULL;
        ListNode* next = NULL;
        while(head!=NULL){
            next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
};