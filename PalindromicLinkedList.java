package CompetitiveCoding4;

import LinkedList1.ListNode;

public class PalindromicLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.print(slow.val);
        ListNode rev = reverse(slow.next);
        // System.out.print(rev.val);
        slow = head;
        fast = rev;
        while(fast != null){
            if(slow.val != fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;

    }
    private ListNode reverse(ListNode head){
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            // prev = curr;
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
