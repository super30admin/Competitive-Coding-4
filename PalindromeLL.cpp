// time: O(n)
// space: O(1)

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
        if(head -> next == NULL) {
            return true;
        }
        // middle ele
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast->next != NULL && fast->next->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        slow->next = NULL;
        slow = head;
        // reverse second half
        ListNode *pre = NULL;
        ListNode *post = fast->next;
        while(post != NULL) {
            fast->next = pre;
            pre = fast;
            fast = post;
            post = post->next;

        }
        fast->next = pre;
        // check palindrome
        while(fast != NULL) {
            if(slow->val != fast->val) {
                return false;
            }
            slow = slow->next;
            fast = fast->next;
        }
        return true;
    }
};