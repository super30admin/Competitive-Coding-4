/*
 * #234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

 */

/*
 * Time Complexity: O (3N) = O (N) -> O (N) to find the mid, O (N) to reverse second half list, O (N) while traversing both lists to check for palindrome
 *
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding4;

import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
class ListNode5 {
	int val; // data
	ListNode5 next;
	ListNode5() {}
	ListNode5(int val) { this.val = val; }
	ListNode5(int val, ListNode5 next)
	{
		this.val = val; 
		this.next = next; 
	}
}

public class IsPalindrome {
	public boolean isPalindrome(ListNode5 head) {
        
        // #1. Base condition
        if(head == null){
            return true;
        }
        
        /************ Brute Force Approach ************/
        /*
         * Time Complexity: O (N) + O (N/2) = O (N) -> O (N) to traverse LL and copy elements into list, O (N/2) to traverse each pointer
         * 
         * Space Complexity: O (N) -> using extra space by creating a list to store LL elements
         */
        
        // #2. Create a list to copy LL elements
        List<Integer> list = new ArrayList<>();
        
        // #3. Traverse through LL and copy its elements into the list
        ListNode5 curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        
        // #4. Two pointers, one from start and other from end to compare values in a list
        int ptr1 = 0;
        int ptr2 = list.size()-1;
        
        while(ptr1 < ptr2){
            // If values are not equal, return false -> not a palindrome
        	// Here, we have to use ! and .equals() instead of != since we are comparing Integers not int
            if(!list.get(ptr1).equals(list.get(ptr2))){
                return false;
            }
            // Else, increment and decrement the pointers
            ptr1++;
            ptr2--;
        }
        //return true;  // LL is a palindrome, return true          
        
        /**************** Space Optimized Approach *****************/
        /*
         * Time Complexity: O (3N) = O (N) -> O (N) to find the mid, O (N) to reverse second half list, O (N) while traversing both lists to check for palindrome
         * 
         * Space Complexity: O (1) -> No extra space used
         * 
         */
     // # 1. Find the middle of a LL
        ListNode5 slow = head;
        ListNode5 fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // #2. Reverse the list after slow pointer
        ListNode5 h2 = reverseList(slow.next);
        
        // #3. Start with head of both lists and compare the node values until reversed list reaches null or node value becomes unequal, to check if LL is a palindrome
        // Store the result, don't just return it yet
        ListNode5 h1 = head;
        boolean result = true;
        
        while(result && h2 != null){
            if(h1.val != h2.val){
                result = false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        
        // #4. Restore the second half reversed list to original
        slow.next = reverseList(h2);
        
        // #5. Return the result, palindrome or not
        return result;
    }
    
	// Function to reverse the list after slow pointer
    public ListNode5 reverseList(ListNode5 curr){
        ListNode5 prev = null;
        ListNode5 temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
}


