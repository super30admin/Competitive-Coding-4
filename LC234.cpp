// Time Complexity O(n)
// Space complexity O(1)

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
    ListNode* reverse(ListNode* head) {
        if (head == nullptr) {
            return head;
        }

        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr != nullptr){
            ListNode* cache = curr->next;
            curr->next = prev;
            prev = curr;
            curr = cache;
        }
        return prev;

    }

public:
    bool isPalindrome(ListNode* head) {
        if (head == nullptr) {
            return true;
        }

        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* original = head;
        ListNode* reversed = reverse(slow);
        while (reversed != nullptr) {
            if (reversed->val != original->val) {
                return false;
            }
            original = original->next;
            reversed = reversed->next;
        }
        return true;
    }
};