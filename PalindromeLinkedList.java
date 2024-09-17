public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now slow holds the middle node

        slow = reverse(slow); // Reversing the linked list from middle
        fast = head;

//         System.out.println(slow.val);
//         System.out.println(fast.val);

        while(slow != null){

            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null || head == null){
            return head;
        }

        ListNode lastNode = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return lastNode;
    }
}
