// 234. Palindrome Linked List
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
first finds the midpoint of the list using the slow and fast pointer technique, 
then reverses the second half of the list. Finally, iterates through both halves 
simultaneously, comparing corresponding elements to determine if the list is a palindrome.

*/

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head==NULL || head->next==NULL){
            return true;
        }
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast->next !=NULL && fast->next->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        fast = slow->next;
        slow->next = NULL;
        fast = reverseList(fast);
        slow->next = fast;
        while(fast!=NULL)
        {
            if(fast->val != head->val)
                return false;
            fast = fast->next;
            head = head->next;
        }
        return true;
    }
    ListNode* reverseList(ListNode* fast)
    {
        if(fast == NULL || fast->next==NULL)
            return fast;
        ListNode *p = NULL,*c = fast,*n = fast->next;
        while(n!=NULL)
        {
            c->next=p;
            p=c;
            c=n;
            n=n->next;
        }
        c->next=p;
        return c;
    }
};
