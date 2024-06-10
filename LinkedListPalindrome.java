/***
 Approach - Reversing 2nd half of the linked list
 1. Declare two pointers- fast and slow, Move fast 2 steps at a time and slow at one step at a time. Once fast or fast.next becomes null, stop the loop. slow will be pointing to the mid of the linked list.
 2. Reverse the linked list after the mid element. Then make fast points to start of list and slow to start of reversed list.
 3. Keep checking if value at slow and fast are same, move to next pointer, else return false.

 TC - O(n)
 SC - O(1)
 */

class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;

        //find mid of the linked list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the list after the mid position

        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Reset slow and fast pointers
        slow = prev;
        fast = head;

        while(slow != null) {

            if(slow.val != fast.val)
                return false;

            slow = slow.next;
            fast = fast.next;

        }

        return true;


    }
}