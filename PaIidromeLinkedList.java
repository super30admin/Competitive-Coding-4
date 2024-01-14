/*
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
    recursion stack space
* 
*/

public class PaIidromeLinkedList {
    private ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null)
            return head;
        
        ListNode reversedHead = reverse(head.next);

        head.next.next = head;

        head.next = null;

        return reversedHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);

        ListNode reversedHead = reverse(middle);

        ListNode head1 = head;

        while(reversedHead != null){
            if(head1.val != reversedHead.val)
                return false;
            
            head1 = head1.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }
}
