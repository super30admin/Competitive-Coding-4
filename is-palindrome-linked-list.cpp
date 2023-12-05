/*
Use two pointers (slow and fast) to find the middle of the linked list.
Reverse the second half of the linked list.
Compare the reversed second half with the first half for palindrome checking.
Time Complexity: O(N), where N is the number of nodes in the linked list. 
We traverse the list twice - once to find the middle and once to compare values.
Space Complexity: O(1), as we use a constant amount of extra space for pointers and do not use additional data structures.*/
#include<bits/stdc++.h>
using namespace std;
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
        if(!head ||!head->next)return true;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast && fast->next){
            slow=slow->next;
            fast=fast->next->next;
        }
        slow=reverseLinkedList(slow);
        while(slow){
            if(slow->val!=head->val)return false;
            head=head->next;
            slow=slow->next;
        }
        return true;
    }
private:
    ListNode* reverseLinkedList(ListNode* head){
        ListNode* prev=nullptr, *curr=head, *next=nullptr;
        while(curr){
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
};
