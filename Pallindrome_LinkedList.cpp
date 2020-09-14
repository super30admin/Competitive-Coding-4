// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
          if (head == NULL || head->next == NULL)
            return true;
        
       ListNode*  slow = head;
        ListNode*  fast = head;
        
        // mid
        while (fast->next &&  fast->next->next){
            
            slow = slow->next;
            fast = fast->next->next;
        }
          ListNode* point1 = head;
 
        //reverse
        
        ListNode* prev = NULL;  
        ListNode* next = NULL; 
        ListNode* curr = slow->next;
        // reverse
      while(curr != NULL){
           next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
            
        }
        slow = prev;
        
       
        
        // check palindrome
        while (point1!= NULL && slow!=NULL){
            
            if (point1->val == slow->val){
                point1 = point1->next;
                slow = slow->next;
                }
            else
                return false;
            
        
    }
        return true;
    }
};