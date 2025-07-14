// Time Complexity: O(n)
//   - One pass to find the middle (O(n/2))
//   - One pass to reverse the second half (O(n/2))
//   - One pass to compare both halves (O(n/2))
//   - Total: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Use the fast and slow pointer technique to find the middle of the linked list
// - Reverse the second half of the list starting from the midpoint
// - Re-initialize `slow` to head, and use `fast` to iterate through the reversed half
// - Compare nodes one-by-one from the beginning and reversed half
// - If all values match, it's a palindrome; otherwise, return false

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
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Now slow is in the middle and fast is at the end
        //Reverse that list
        fast = reverse(slow);
        slow = head;
        //Loop one by one if we reach end that means its palindrome
        while(fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}