/*

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
Odd and even length of the list compare values not nodes.


// Your code here along with comments explaining your approach
Find the midpoint using slow and fast pointer
Reverse from slow if even else reverse from slow->next if odd
compare their values until reverse reaches null

*/



#include<iostream>

using namespace std;


//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reversed(ListNode* node){
        ListNode* prev {NULL};
        ListNode* slow{node};
        ListNode* fast{node->next};
        while(fast!= NULL){
            slow->next = prev;
            prev = slow;
            slow = fast;
            fast = fast->next;
        }
        slow->next = prev;
        return slow;
    }
    bool isPalindrome(ListNode* head) {
        ListNode* slow {head};
        ListNode* fast {head};
        if(head == NULL) return false;
        if(head->next == NULL) return true;
        while(fast!= NULL && fast->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }

        if(fast == NULL){
            fast = reversed(slow);
        }
        else if(fast->next == NULL){
            fast = reversed(slow->next);
        }
        slow->next = NULL;
        while(fast!=NULL){
            if(fast->val!=head->val) return false;
            fast = fast->next;
            head = head->next;
        }
        return true;
    }
};