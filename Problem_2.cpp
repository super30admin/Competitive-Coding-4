/*
Time Complexity:
O(N) as we are traversing the linked list to get the mid point.
After that we are reversing the linked list which is half of the
original linked list that will take N/2 and then we are comparing the
values which again is N/2. So, the overall complexity will be O(N)
*/

/*
Space Complexity:
The space complexity is O(1) as we are not creating any extra space.*/


/*
Approach:
This problem can be solved by taking the reverse of the second half of the linked list.
Because we know that in palindrome if we reverse the second from the mid it becomes same
as the first half.

So if list is of odd nodes then when we compare the two lists from the starting, one of the lists
will end before than the other one and if till that point all of the nodes have same value then it is 
a palindrome. Because in the longer list only one node will be left and we know that in odd length
palindromes the centre element is different.

But if we have even length and both the lists have the same value for each node then also it is a palindrome.

Except of these two cases the list can never be a palindrome.
*/

// The code ran perfectly on leetcode.

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head == NULL) return true;
        ListNode *slow = head;
        ListNode *fast = head;
        
        //getting the mid of the linked list
        while(fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        //ListNode* mid = slow;

        //initializing the node next to slow as the head of the second list
        ListNode* sHead= slow->next;

        //ending the first part of the list with NULL
        slow->next = NULL;

        //reversing the second list
        ListNode *curr= sHead;
        ListNode *prev= NULL;
        ListNode * temp;
        while(curr != NULL){
            temp = curr->next;
            curr->next = prev;
            prev= curr;
            curr= temp;
        }

        //after reversing we need to initialize the head to the previous
        sHead = prev;
        
        while(head && sHead){
            if(head->val != sHead->val) return false;
            else{
                head= head->next;
                sHead= sHead->next;
            }
        }
        return true;
    }
};