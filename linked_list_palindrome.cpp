// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

//Approach: 
//1. We will use the slow and fast pointer approach to find the middle of the linked list.
//2. We will reverse the second half of the linked list.
//3. We will compare the first half and the reversed second half of the linked list.

class Solution {
    public:
        bool isPalindrome(ListNode* head) {
            ListNode* slow = head;
            ListNode* fast = head; 
            while(fast -> next != nullptr && fast -> next -> next != nullptr){
                slow = slow -> next;
                fast = fast -> next -> next;
            }
            ListNode* temp;
            ListNode* curr = slow -> next;
            ListNode* prev = nullptr;
            
            while(curr != nullptr){
                temp = curr -> next;
                curr -> next = prev;
                prev= curr;
                curr = temp;    
            }
            slow -> next = nullptr;
            ListNode* first = head;
            while(first != nullptr && prev != nullptr){
                if(first -> val != prev -> val){return false;}
                else{
                    first = first -> next;
                    prev = prev -> next;
                }
            }
            return true;
        }
    };