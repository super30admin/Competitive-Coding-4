//Time Complexity O(n)
//Space Complexity O(1)
//Leetcode tested

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;

        ListNode l1 = head;
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        ListNode l2 = reverse(slow);
        return merge(l1,l2);
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while (current!=null){
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public boolean merge(ListNode l1, ListNode l2){
        while (l1!=null && l2!=null){
            if(l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1 == null && l2 == null) return true;
        if(l1 == null){
            if(l2.next == null) return true;
            else return false;
        }
        if(l2 == null){
            if(l1.next == null) return true;
            else return false;
        }
        return true;
    }

}
