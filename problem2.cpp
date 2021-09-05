//Time Complexity - O(n)
//Space Complexity - O(1)
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;
        if(head->next==NULL)
            return true;
        while(fast!=NULL&&fast->next!=NULL){
            fast=fast->next->next;
            slow=slow->next;
        }
        ListNode* curr=slow->next;
        ListNode* prev=slow;
        ListNode* node=slow->next;
        prev->next=NULL;
        while(curr!=NULL){
            node=curr->next;
            curr->next=prev;
            prev=curr;
            curr=node;
        }
        ListNode* temp=head;
        while(prev!=NULL){
            if(temp->val!=prev->val)
                return false;
            temp=temp->next;
            prev=prev->next;
        }
        return true;
    }
};