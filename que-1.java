// Time Complexity :O(n)
// Space Complexity :O(1)
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
        if(head == null) return true;
        ListNode fast = head;
        ListNode p1 = head;
        ListNode slow = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        ListNode p2 =reverse(slow);
        boolean result = true;
        while(result && p2 != null){
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            p2=p2.next;
        }
        slow = reverse(slow);
        return result;
        
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = null;
        ListNode temp = head;
        while(temp!=null){
            prev=curr;
            curr = temp;
            temp = temp.next;
            curr.next = prev;
        }
        return curr;
    }
}