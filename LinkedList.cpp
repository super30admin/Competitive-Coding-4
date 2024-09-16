"""
Intuition: Palindrome = both halfs are mirror images.
Reverse the second half and compare it with the first half
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(1)
#####################################################################
"""
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
        if (head == NULL or head->next == NULL ) {
            return true;
        }
        ListNode *slow = head;
        ListNode *fast = head;
        
        while (fast->next != NULL and fast->next->next != NULL){
            
            fast = fast->next->next;
            slow = slow->next;
        }
        fast = getReverseLL(slow->next);
        slow = head;
        
        while (fast != NULL){
            
            if (fast->val != slow->val){
                return false;        
            }
            fast = fast->next;
            slow = slow->next;
        }
        return true;
    }
    ListNode* getReverseLL(ListNode* head){
        
        ListNode *prev = NULL;
        ListNode *curr = head;
        ListNode *fast = head->next;
        while (fast != NULL){
            
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
 
    }
};