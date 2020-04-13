// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public class ListNode {
        int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
     
        // edge case
        if(head==null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        
        //get the middle
        while(fast.next!=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast= fast.next.next;
        }
        ListNode curr = reverseList(slow.next);
        
        //Compare
        while(curr!=null)
        {
            if(head.val != curr.val)
                return false;
            else{
                head=head.next;
                curr = curr.next;
            }
        }
        return true;
        
    }
    private ListNode reverseList(ListNode root)
    {
        
        ListNode prev = null;
        while(root!=null)
        {
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root= temp;
        }
     
        return prev;
        
    }
}