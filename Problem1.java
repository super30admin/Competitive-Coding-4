// Time Complexity : O(n/2) + O(n/2) + O(n/2) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I first calculate the mid of the linked list.
After calculating the mid, I reversed the 2nd part of the linked list and broke the first linked list,
Then I set 2 pointer on each head and traversed together to find if they are palindrome or not
*/

public class Problem1 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedNode = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(slow != null && reversedNode != null) {
            if(reversedNode.val != slow.val) {
                return false;
            }

            reversedNode = reversedNode.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
