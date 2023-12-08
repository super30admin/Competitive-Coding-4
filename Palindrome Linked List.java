// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
            if(fast!= null)
            slow = slow.next;
            slow = reverse(slow);
            fast = head;
            while(slow!= null)
            {
                if(fast.val!= slow.val)
                return false;

                fast = fast.next;
                slow= slow.next;

            }
            return true;
        
    }
    public ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        while(node!= null)
        {
            ListNode temp = node.next;
            node.next = prev;
            prev= node;
            node = temp;

        }
        return prev;
    }
}