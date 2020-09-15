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
 //T : O(n)
 //S : O(1)
class Solution {
public:
    ListNode* findMid(ListNode* head){
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while(curr){
            ListNode* x = new ListNode(curr->val);
            x->next = prev;
            prev = x;
            curr = curr->next;
        }
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
        if(!head) return true;
        ListNode* firstHalf = findMid(head);
        ListNode* secondHalf = reverse(firstHalf->next);
        firstHalf->next = nullptr;
        while(secondHalf){
            if(head->val != secondHalf->val) return false;
            head = head->next;
            secondHalf = secondHalf->next;
        }
        return true;
    }
};