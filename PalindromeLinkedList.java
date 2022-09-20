public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // null check
        if(head==null || head.next==null) return true;
        
        // Declare slow and fast
        ListNode slow = head;
        ListNode fast = head;
        // finding the midpoint
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        while(head!=null&& head2!=null){
            if(head.val!=head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}


// Time Complexity - O(n)
// Space Complexity - O(1)
