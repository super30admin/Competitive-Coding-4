
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
    
    ListNode* middle( ListNode* head ){
        ListNode* slow = head;
        ListNode* fast  = head;
        while( fast->next != nullptr && fast->next->next != nullptr ){
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    
    ListNode* nextlinkedlist( ListNode* midnext){
        
        ListNode* current = midnext;
        ListNode *prev = nullptr;
        ListNode *next = nullptr;
 
        while (current != nullptr) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
       // find middle 
       if ( head == nullptr || head->next == nullptr ){
           return true;
       }
       ListNode* mid = middle( head );
       ListNode* midnext = mid->next;
       mid->next = nullptr;
       ListNode* head2 = nextlinkedlist( midnext );
       while( head != nullptr && head2 != nullptr ){
           if( head->val != head2->val ) {
               return false;
           }
           head=head->next;
           head2=head2->next;
       }
       return true;
    }
};
