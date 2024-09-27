// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next== null) return true;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = helper(slow);
       
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    private ListNode helper(ListNode head){
        ListNode cur = head, prev = null ;
          
        while(cur != null){
           ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
