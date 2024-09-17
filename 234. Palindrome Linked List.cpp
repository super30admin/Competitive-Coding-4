/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Time Complexity = O(N)
 Space Complexity = O(1)
 Where N is the number of nodes in the linked list.
 */

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head->next;                        //since we need to stop at the middle element and if number of nodes is even then we need to stop at the first middle element thats why we have taken fast=head->next, if we took fast=head then slow would have pointed at the second middile element which we dont want, since we want to split the LL in half.
        while(fast!=NULL && fast->next!=NULL)
        {
            fast=fast->next->next;
            slow=slow->next;
        }
        ListNode* newhead = slow->next;
        slow->next=NULL;
        ListNode* prev = NULL;
        ListNode* curr = newhead;
        ListNode* next;
        while(curr!=NULL)
        {
            next=curr->next;
            curr->next = prev;
            prev = curr;
            curr=next;
        }
        newhead = prev;
        while(head!=NULL && newhead!=NULL)
        {
            if(head->val!=newhead->val)
                return false;
            else
            {
                head=head->next;
                newhead=newhead->next;
            }
        }
        return true;
    }
};
