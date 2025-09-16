// Problem - Palindrome linked list
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Explaination
// 1. We first use the the fast and slow pointer technique to find the middle
// 2. Then we reverse te second part of the list starting from slow
// 3.We reset the curr pointer to head and now navigate curr and prev and check
// if their values are equal
// 4. If not we return false otherwise we return true
#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
  bool isPalindrome(ListNode *head) {
    ListNode *slow = head;
    ListNode *fast = head->next;
    while (fast && fast->next) {
      slow = slow->next;
      fast = fast->next->next;
    }
    ListNode *prev = nullptr;
    ListNode *curr = slow;
    while (curr) {
      ListNode *temp = curr->next;
      curr->next = prev;
      prev = curr;
      curr = temp;
    }
    curr = head;
    while (curr && prev) {
      if (curr->val != prev->val) {
        return false;
      }
      curr = curr->next;
      prev = prev->next;
    }

    return true;
  }
};
