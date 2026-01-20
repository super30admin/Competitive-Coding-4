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
 //Identify mid point
 //Reverse second half
 //Travel first and second halfs. Compare values at every step
 //TC: O(n/2)+O(n/2)+O(n/2); SC:O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=reverse(slow.next);

        slow.next=null;

        ListNode curr=head;

        while(fast!=null){
            if(fast.val!=curr.val){
                return false;
            }

            fast=fast.next;
            curr=curr.next;
        }

        return true;




    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;

        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }

        return prev;
    }
}
