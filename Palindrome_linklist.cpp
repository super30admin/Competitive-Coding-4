//Time O(n)
//Space O(1)
//Leetcode yes
//Issue seen: none
class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* prev= NULL;
        ListNode* curr = head;

        while(curr){
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        slow->next = NULL;
        fast = reverse(fast);
        slow = head;

        while(slow && fast){
           if(slow->val != fast->val){
            return false;
           }
           slow = slow->next;
           fast = fast->next;
        }
       
        return true;
    }
};
