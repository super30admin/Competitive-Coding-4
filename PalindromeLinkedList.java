// Time Complexity : O(n) — find middle, reverse half, single pass compare
// Space Complexity : O(1) 
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) Use fast/slow to find middle (slow = end of first half).
// 2) Reverse the second half starting at middle.next.
// 3) Compare first and reversed second halves node-by-node; if all equal -> true.


public class PalindromeLinkedList {
    public ListNode getMiddle(ListNode head){
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        ListNode firstHalfStart = head;
        while(secondHalfStart != null){
            if(secondHalfStart.val != firstHalfStart.val){
                return false;
            }

            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}
