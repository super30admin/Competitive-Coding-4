//Time Complexity-O(n)
//Space Complexity-O(1)
//Ran successfully on leetcode

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
        //base case
        if(head==NULL || head->next==NULL)
            return true;
        //finding middle of the linked list
        ListNode*slow=head;
        ListNode*fast=head;
        while(fast->next!=NULL && fast->next->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        //reverse from slow
        ListNode*last=reverse(slow);
        slow=head;
        //check palindrome
        while(slow!=NULL && last!=NULL)
        {
            if(slow->val!=last->val)
                return false;
            slow=slow->next;
            last=last->next;
        }
        return true;
    }
    ListNode*reverse(ListNode*mid)
    {
        //base case
        if(mid==NULL || mid->next==NULL)
            return mid;
        //logic
        ListNode*prev=NULL;
        ListNode*curr=mid;
        ListNode*fast=curr->next;
        while(fast!=NULL)
        {
            curr->next=prev;
            prev=curr;
            curr=fast;
            fast=fast->next;
        }
        curr->next=prev;
        return curr;
    }
};