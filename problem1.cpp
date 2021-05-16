/*
Time complexity - O(N)
Space complexity - O(1)
*/

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
        if (!head || !head->next) return true;
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode *right = reverse(slow->next);
        ListNode *left = head;
        while (right){
            if (left->val != right->val) return false;
            left = left->next;
            right = right->next;
        }
        return true;
    }
    
private:
    ListNode* reverse(ListNode* head){
        ListNode *prev = NULL, *curr = head, *fast = head->next;
        while(fast){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
};