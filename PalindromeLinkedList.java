import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode firstListHead) {
        // Moving fast and slow pointers to find the mid
        ListNode slow = firstListHead;
        ListNode fast = firstListHead;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
        }

        // Reverse the list from mid using prev pointer
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Compare the two lists to see if they are matching
        ListNode secondListHead = prev;
        while(firstListHead != null && secondListHead != null){
            if(firstListHead.val != secondListHead.val) return false;
            firstListHead = firstListHead.next;
            secondListHead = secondListHead.next;
        }
        return true;
    }
}
