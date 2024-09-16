class Solution {
    private:
    ListNode* reverse(ListNode* node){
        if(!node)
            return node;
        ListNode* curr = node;
        ListNode* temp = node->next;
        
        while(node->next){
            node->next = temp->next;
            temp->next = curr;
            curr = temp;
            temp = node->next;
        }
        
        return curr;
    }
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        ListNode* headR = reverse(slow->next);
        slow->next = NULL;
        
        fast = headR;
        slow = head;
        while(fast){
            if(fast->val != slow->val)
                return false;
            slow = slow->next;
            fast = fast->next;
        }
        return true;
    }
};