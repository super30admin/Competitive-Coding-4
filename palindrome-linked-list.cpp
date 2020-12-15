//Time - O(n)
//Space - O(1)

class Solution {
public:
    ListNode* reverseLinkedList(ListNode* head){
        ListNode* prev = NULL, *next = head;
        
        while(next!=NULL){
            next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
        if(head==NULL || head->next == NULL) return true;
         
        ListNode *s = head,*f = head;
        
        while(f != NULL && f->next != NULL && f->next->next != NULL){
            s = s->next;
            f = f->next->next;
        }
        
        f = reverseLinkedList(s->next);
        s = head;
        
        while(f!=NULL && s!=NULL){
            if(f->val != s->val) return false;
            f = f->next;
            s = s->next;
        }
        
        return true;
        
    }
};