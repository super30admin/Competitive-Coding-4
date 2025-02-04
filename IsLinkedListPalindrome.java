// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : This uses O(n) space,
// there exists an O(1) space approach - reverse the second half of the list
// and compare elements in the first and second halves sequentially

import java.util.Stack;

/*
 * Find the middle of the list using slow/fast pointer. Push elements until middle into stack.
 * Once middle is found, pop elements from the stack and compare as we iterate till the end.
 * A discrepancy at any point means the list is not a palindrome.
 */
public class IsLinkedListPalindrome {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // if fast is null, the count was even
        // if it is not null, the count was odd (hence we skip one element)
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }

}
