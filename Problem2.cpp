// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Palindrome Linked List

#include<vector>
#include<iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        
        if(head == NULL || head->next == NULL)
            return true;
        
        // Find the middle of the list
        
        ListNode *fast = head;
        ListNode *slow = head;
        
        while(fast->next != NULL && fast->next->next != NULL){
            fast = fast->next->next;
            slow = slow->next;      // left-half if even and middle if odd
        }
        
        slow->next = reverseList(slow->next);
        slow = slow->next;
        
        fast = head;        // don't want to lose head
        
        while(slow != NULL){
            
            if(fast->val != slow->val)
                return false;
            
            fast = fast->next;
            slow = slow->next;
        }
        
        return true;
    }
    
    ListNode* reverseList(ListNode* head){
        ListNode *next = NULL;
        ListNode *prev = NULL;
        
        while(head != NULL){
            next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
};