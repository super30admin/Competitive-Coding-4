
//Time Complexity functions: O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
/*
 * Using slow and fast pointer find the middle node. Make slow.next as null. Reverse the second half of list and make it another list. Compare
 * from the head of the two lists. If not equal return false. 
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next=null;
        slow=head;
        while(fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;


    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode tmp=head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        }
        return prev;
    }
}