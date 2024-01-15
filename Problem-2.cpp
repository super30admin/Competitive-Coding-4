// Time Complexity : O(n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Traverse till middle of LL, reverse the second half 
// start comparing the reversed part from the beginning.

// 234. Palindrome Linked List

#include <bits/stdc++.h>
using namespace std;

 // Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

class Solution {
public:

    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        while(curr!=NULL){
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
        while(fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        slow->next = reverse(slow->next);
        slow = slow->next;
        while(slow!=NULL){
            if(head->val != slow->val){
                return false;
            }
            slow=slow->next;
            head=head->next;
        }
        return true;
    }
};