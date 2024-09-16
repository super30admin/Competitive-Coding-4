public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next==null) return true;
        ListNode firstHalfEnd = firstHalfList(head);
        ListNode secondHalf = reverse(firstHalfEnd.next);

        ListNode start = head;
        ListNode end = secondHalf;
        boolean result = true;
        while (result && end != null) {
            if (start.val != end.val) result = false;
            start = start.next;
            end = end.next;
        }
        return result;
    }
    private ListNode firstHalfList(ListNode curr){
        ListNode slow=curr;
        ListNode fast=curr;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}
