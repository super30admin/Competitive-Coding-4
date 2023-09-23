// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


/*

In this problem, to find if the linked list is a palindrome or not, we first find the middle 
element by using fast and slow pointers. after find it , we then reverse the linked list start from the element after
the middle element and break the connection resulting in 2 linked lists.Then we will compare both linked lists and check 
if each node's value is equal or not. Whenever it encouters unequal values, it will
return false.


*/


// Your code here along with comments explaining your approach


#include <iostream>
#include <vector>
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

        if(head->next == NULL){
            return true;
        }

        ListNode* slow = head;
        ListNode* fast = head;
        
        //find the mid

        while(fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
            

        }
         
         ListNode* prev = NULL;
         ListNode* curr = slow->next;
         ListNode* temp = curr->next;

         while(temp != NULL){
             curr->next = prev;
             prev = curr;
             curr = temp;
             temp = temp->next;
         }

         curr->next = prev;

         slow->next = NULL;

         fast = head;

         

         while(fast != NULL && curr != NULL){
             cout << fast->val << " " << curr->val ;
             if(fast->val==curr->val){
                
                fast= fast->next;
                curr=curr->next;


             }
             else{
                 
                 return false;
             }
         }

         return true;

    





        
    }
};