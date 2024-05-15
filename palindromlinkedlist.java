// Time Complexity : O(n) --> n/2(find middle) + n/2 (reverse) + n/2 (compare)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // edge cases
        if(head==null || head.next==null)
            return true;
        
        ListNode traverse_1=head;
        ListNode traverse_2=head;
        // find the middle
        
        while(traverse_2!=null)
        {
            traverse_1=traverse_1.next;
            if(traverse_2.next==null)
                traverse_2=null;
            else
                traverse_2=traverse_2.next.next;
        }
        
        // reverse the LL
        ListNode dummy=null;

        while(traverse_1!=null)
        {
            ListNode temp=traverse_1.next;
            traverse_1.next=dummy;
            dummy=traverse_1;
            traverse_1=temp;
        }
        
        // compare
        ListNode traverse=head;
        while(dummy!=null)
        {
            if(traverse.val!=dummy.val)
                return false;
            
            traverse=traverse.next;
            dummy=dummy.next;
        }
        
        return true;
    }
}