// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Find the middle of the linked list using fast and slow pointer method
// Reverse the secong half od the linked list
// check the given linked list and the reversed list for their values, if they do not match return false;
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
        ListNode* reverse(ListNode* head){
            ListNode* curr=head;
            ListNode* temp=NULL;
            ListNode* prev=NULL;
            while(curr != NULL){
                temp = curr->next;
                curr->next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
        bool isPalindrome(ListNode* head) {
            ListNode* fast=head;
            ListNode* slow=head;
            while(fast->next != NULL && fast->next->next != NULL){
                fast = fast->next->next;
                slow = slow->next;
            }
            //slow->next = NULL;
            ListNode* h2 = reverse(slow->next);
            ListNode* h1 = head;
            while(h2 != NULL){
                if(h1->val != h2->val) return false;
                h1 = h1->next;
                h2 = h2->next;
            }
            return true;
    
        }
    };