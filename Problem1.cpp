//
// Created by shazm on 7/27/2019.
//

#include <iostream>
#include <algorithm>
#include <bits/stl_vector.h>

// Runtime: O(n)
// Space: O(n)
// Approach: Add all elements in the LinkedList to a vector. After adding to vector, traverse through the vector and if
// the index is even, add from the beginning else add from the end.

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head==NULL || head->next==NULL){
            return true;
        }
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast!=NULL && fast->next!= NULL){
            slow = slow->next;
            fast = fast->next->next;
        }

        fast = reverseLinkedList(slow->next);
        slow->next = NULL;
        slow = head;

        while(slow!=NULL && fast!=NULL){
            if((slow!=NULL && fast!=NULL) && slow->val != fast->val){
                return false;
            }
            if(slow!=NULL){slow = slow->next;}
            if(fast!=NULL){fast = fast->next;}
        }
        return true;
    }
private:
    ListNode* reverseLinkedList(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        while(curr!=NULL){
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};