// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

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
        if(head == NULL){
            return true;
        }
        ListNode *firstHalfEnd = endOfFirstHalf(head);
        ListNode *secondHalfStart = reverseList(firstHalfEnd->next);
        
        ListNode *p1 = head;
        ListNode *p2 = secondHalfStart;
        
        bool result = true;
        while(result && p2!=NULL){
            if(p1->val != p2->val){
                result = false;
            }
            p1 = p1->next;
            p2 = p2->next;
        }
        firstHalfEnd->next = reverseList(secondHalfStart);
        return result;
    }
    ListNode* reverseList(ListNode* head){
        ListNode *prev = NULL;
        ListNode *curr = head;
        while(curr!=NULL){
            ListNode *nextTemp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    ListNode* endOfFirstHalf(ListNode* head){
        ListNode *fast = head;
        ListNode *slow = head;
        while(fast->next != NULL && fast->next->next!=NULL){
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow;
    }
};
