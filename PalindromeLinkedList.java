/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // TC - O(n), SC - O(1)
 
 // We find the mid point node in linked list and reverse it from that point. Iterate till reversedList is not null, check the val of head and revlist is same, if not return false
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revList = reverse(slow);
        while(revList != null){
            if(head.val != revList.val){
                return false;
            }
            revList = revList.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode newHead = new ListNode(head.val);
            newHead.next = prev;
            prev = newHead;
            head = head.next;
        }
        return prev;
    }
}