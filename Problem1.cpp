// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        if(head == NULL || head->next == NULL) return true; // edge case
        ListNode* fast = head->next; 
        ListNode* slow = head;
        while(fast!=NULL && fast->next!=NULL){
            fast = fast->next->next;  // getting mid point of linkedlist
            slow = slow->next;
        }
        fast = slow->next;
        slow->next = NULL;
        // reversing link list
        ListNode* prev = NULL;
        ListNode* curr = fast;
        ListNode* faster = fast->next;
        while(curr!=NULL){
            curr->next = prev;
            prev = curr;
            curr = faster;
            if(faster!=NULL) faster = faster->next;
        }
        fast = prev;
        
        while(fast!=NULL){
            if(head->val != fast->val) return false;  // checking the 2 parts 
            fast = fast->next;
            head = head->next;
            
        }
        return true;  // if all match return true
    }
};
    

// int main(){
    
//     return 0;
// }