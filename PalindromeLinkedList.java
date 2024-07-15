// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

        ListNode slow = head;
        ListNode fast = head;

        // Middle of the linked list

        while(fast!=null && fast.next!= null) {
            slow = slow.next; // it wiil contain middle element.
            fast = fast.next.next;
        }

        // reverse second half of the linked list

        System.out.println(slow.val);

        slow = reverse(slow);
        System.out.println(slow.val);


        fast = head;

        // check if linked list is palindrome


        while(slow != null){
            System.out.println(slow.val);
            System.out.println(fast.val);
            if(slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            }
            else {
                return false;
            }
        }

        return true;

    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;

    }

}