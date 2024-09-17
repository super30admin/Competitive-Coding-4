// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    // Function to reverse the linked list
    ListNode* reverseList(ListNode* head) {
        
        if(head == NULL)
            return head;
        
        ListNode* prev = head;
        ListNode* curr = head->next;
        ListNode* next;
        
        while(curr)
        {
            next = curr->next;
            
            curr->next = prev;
            
            prev = curr;
            
            curr = next;
        }
        
        head->next = NULL;
        
        return prev;
    }
    
    // Palindrome Check function
    bool isPalindrome(ListNode* head) {
        
        if(head == NULL)
            return true;
        
        if(head->next == NULL)
            return true;
        
        ListNode* mid = head;
        ListNode* last = head;
        
        // Find the middle pointer
        while(mid && last->next)
        {
            mid = mid->next;
            last = last->next;
            
            if(last->next)
                last = last->next;
            else
                break;
        }            

        // Reverse the second half of the linked list        
        ListNode* last = reverseList(mid);
        ListNode* curr=head;

        // Compare the first and last pointer
        // Move towards the middle
        while(last!=NULL){
            if(last->val!=curr->val){
                return false;
            }
            curr = curr->next;
            last = rev->next;
        }
        return true;
    }
};