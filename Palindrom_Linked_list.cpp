// {Approach 1}
// Time Complexity : O(3n) == O(n) ...
//                          ..... first O(n) to copy the list, second O(n) to reseverse the list
//                                and thirsd O(n) to compare two lists 
// Space Complexity : O(n) ... copy of entire list is created
//
// {Approach 2}
// Time Complexity : O(3n) == O(n) ..... same as approach 1
// Space Complexity : O(1) ... Second half of the list is reversed in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : Given the head of a singly linked list, return true if it is a palindrome
 or false otherwise.
*/


/**
 * Approach 1 : Creating copy of linked list 
 * 
 * Entire list is copied first and new list is reversed
 * and then both lists are compared
 * 
*/

class Solution {
    bool flag = true;
public:
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return true;

        ListNode* head1 = new ListNode (head->val);
        ListNode* ptr1 = head1;
        ListNode* current = head->next;
        while(current != nullptr){
            ptr1->next = new ListNode(current->val);
            current = current->next;
            ptr1 = ptr1->next;
        }

        head1 = reverseList(head1);

        current = head;
        while(current != nullptr){
            if(current->val != head1->val){
                return false;
            }
            current = current->next;
            head1 = head1->next;
        }
        return true;
    }

    ListNode* reverseList(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* current = head;

        while(current!= nullptr){
            ListNode* temp = current->next;
            current->next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

};


/*
Approach 2 : Not using extra space

Middle of the list if found first, then second half of the list is reversed in place.
then fist half and reversed second half are compared to check if they are equal.
*/


class Solution {
    bool flag = true;
public:
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return true;
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }

        fast = slow->next;
        fast = reverseList(fast);

        slow->next = nullptr;
        slow = head;

        while(fast != nullptr){
            if(slow->val != fast->val){
                return false;
            }
            slow = slow->next;
            fast = fast->next;
        }
        return true;
        
    }

    ListNode* reverseList(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* current = head;

        while(current!= nullptr){
            ListNode* temp = current->next;
            current->next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

};