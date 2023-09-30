// Time Complexity : O(n)
// Space Complexity : O(n) // recursive stack
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/palindrome-linked-list/submissions/1062739503/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Create a stack, add the values into the stack after traversing the linked list
 * Traverse the linked list again, pop each element from stack and check with the data in the linked list
 * If all the data matches, return true else return false.
 */
import java.util.*;
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        boolean result = true;
        Stack<Integer> stack = new Stack<Integer>();
 
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
 
        while (head != null) {
            int i = stack.pop();
            if (head.val == i) {
                result = true;
            }
            else {
                result = false;
                break;
            }
            head = head.next;
        }
        return result;
    }
}