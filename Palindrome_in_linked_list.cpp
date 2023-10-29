class Solution {
private:
    ListNode* reverse(ListNode* curr){
        if(curr==NULL) return NULL;
        ListNode* prev = NULL;
        while(curr!=NULL){
            ListNode* temp =curr->next;
            curr->next= prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
public:
    bool isPalindrome(ListNode* head) {
        if(head->next==NULL)return true;
        if(head->next->next==NULL){
            if(head->val!=head->next->val)return false;
            else return true;
        }
        ListNode*slow=head;
        ListNode*fast=head;
        while(fast->next!=NULL && fast->next->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = reverse(slow->next);
        slow->next = NULL;
        slow = head;
        while(fast!=NULL){
            if(fast->val!=slow->val)return false;
            slow = slow->next;
            fast = fast->next;
        }
        return true;
    }
};

