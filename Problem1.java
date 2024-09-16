/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
 LeetCode Submitted : YES
 Time Complexity : O(N)
 Space Complexity : O(1)
 
 The idea is to use fast and slow pointer and then use position of slow.next to reverse the list.
 **/
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        
        if(head == null || head.next == null)
            return true;
        
        while(slow != null){
            length = length + 1;
            slow   = slow.next; 
        }
        slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        
        ListNode revNode = reverseList(slow.next);
        slow = head;
        
        
        while(revNode != null){
            //System.out.println(slow.val);
            //System.out.println(revNode.val);
            if(revNode.val == slow.val){
                slow    = slow.next;
                revNode = revNode.next;
                length = length - 2;
                //continue;
            }   
            else
                return false;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = node.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        return curr;
    }
}
