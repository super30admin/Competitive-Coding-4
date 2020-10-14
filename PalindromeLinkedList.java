// Time Complexity : O(N) - As we traverse through every node in the LinkedList
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
         if(fast != null) { 
             slow = slow.next;
          }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode temp){
        if(temp == null) return null;
        ListNode p1 = null;
        ListNode p2 = temp;
        ListNode temp1;
        while(p2 != null){
            temp1 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp1;
        }
        return p1;
            
    }
    
}
// Your code here along with comments explaining your approach
