https://leetcode.com/problems/palindrome-linked-list/description/

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        //Pointers to find the mid for the list
        ListNode slow = head;
        ListNode fast = head;
//Lopp to find the mid of the list
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

//Reverse the second hald of the list
        ListNode prev = slow.next;
        ListNode curr = slow.next.next;
        ListNode temp = curr;
        prev.next = null;
        while(curr!=null){
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        slow.next = null;
        slow = head;


//Get two pointers at both the ends of the list and start combining the two lists
        while(prev!=null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }
}