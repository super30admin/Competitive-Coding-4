//Time Complexity=O(n)
//Space Complexity=O(1)
public class PalindromeCheck {
    private ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;

        while(fast!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }

        return true;
    }
}
