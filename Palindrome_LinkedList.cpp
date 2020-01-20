Time Complexity-O(n)
Space Complexity-O(1)
Did the code run on Leetcode? yes

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head==NULL || head->next==NULL)
        {
            return true;
        }
        ListNode* slow=head;
        ListNode* fast=head->next;
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* a=slow->next;
        slow->next=NULL;
        slow=head;
        ListNode* b=NULL;
        ListNode* c=NULL;
        while(a!=NULL)
        {
            b=a->next;
            a->next=c;
            c=a;
            a=b;
        }
        while(c!=NULL)
        {
            if(slow->val!=c->val)
            {
                return false;
            }
            slow=slow->next;
            c=c->next;
        }
        return true;
    }
};