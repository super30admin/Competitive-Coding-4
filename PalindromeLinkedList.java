//TC: O(n)
//SC: O(1)
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode newHead = new ListNode();
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        newHead = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = newHead;
        ListNode temp = curr.next;
        while(temp != null) {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;
        while(head != null && curr != null) {
            if(head.val != curr.val) return false;
            else{
                head = head.next;
                curr = curr.next;
            }
        }
        return true;
    }
}
