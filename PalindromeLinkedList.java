/**
 * PalindromeLinkedList
 */
public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while(head != null && head2 != null){
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        //if(head != null || head2 != null) return false;
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head;
        while(prev.next != null){
            curr = prev.next;
            prev.next = curr.next;
            curr.next = head;
            head = curr;
        }
        return head;
    }
    
}