// Time Complexity : O(3n/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// By Using FLoyd's Algorithm, slow and fast pointers are iterated to find the midpoint of the linked list.
// Return the fast pointer to head and reverse the linked list from the slow pointer to the end.
// No compare every node of slow and fast pointers which is iterating in opposite directions.
// if both values are not equal, return false as it has to be the same if it is palindrome.

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
        if(head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        slow = reverse(slow);

        while(slow!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow){
        ListNode prev = null, curr = slow, next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
