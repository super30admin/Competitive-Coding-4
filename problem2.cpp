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
        
        
    ListNode* fast = head;
    ListNode* slow = head;
        
        while(fast !=NULL && fast->next != NULL) {
            
            fast = fast->next->next;
            slow = slow->next;
        }
        
        ListNode* curr = slow;
       // slow->next = NULL;
        ListNode* prev = NULL;
       
        ListNode*next = NULL;
        
        while(curr !=NULL){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
      ListNode* head2 = prev;
        
        while(head != NULL && head2 != NULL) {
            
            if(head->val != head2->val) {
                return false;
            }
            head = head->next;
            head2 = head2->next;
        }
        
        return true;
        
    }
};