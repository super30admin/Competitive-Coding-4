//Time Complexity : O(n)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
        //edge case
        if(head == nullptr) return true;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        ListNode* head2 = slow->next;
        slow->next = nullptr;
        
        ListNode* previousNode = nullptr;
        ListNode* currentNode = head2;
        ListNode* nextNode;
        while(currentNode != nullptr) {
            nextNode = currentNode->next;
            currentNode->next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head2 = previousNode;
        while(head != nullptr && head2 != nullptr) {
            if(head->val != head2->val) return false;
            else {
                head = head->next;
                head2 = head2->next;
            }
        }
        return true;
    }
};
