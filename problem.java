import java.util.List;

public class problem {
    public boolean isPalindrome(ListNode head){
        if(head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode h = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = h;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        h = prev;
        while(head != null && h != null){
            if(head.val != h.val ) return false;

            head = head.next;
            h = h.next;
        }

        return true;
    }
}


//time complexity O(n)
//space complexity O(1)