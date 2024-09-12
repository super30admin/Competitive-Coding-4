// Time Complexity : O(N)
// Space Complexity : O(N)
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
    private ListNode reverseLL(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
            
    }
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = reverseLL(slow);
        System.out.println(ptr1.val);
        System.out.println(ptr2.val);
        
        while(ptr1!=null && ptr2 != null){
            if(ptr1.val!=ptr2.val){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
        
    }
}
