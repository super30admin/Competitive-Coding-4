// Time - O(N)
// Space - O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;

        ListNode firstHalfEnd = findFirstHalfEnd(head);
        ListNode secondHalfReversed = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfReversed;
        boolean result = true;


        // compare both list if odd then middle element hits null still it is palindrome
        while(result && p2 != null) {

            if(p1.val != p2.val) result =  false;
            p1 = p1.next;
            p2 = p2.next;

        }

        // Restore the list and return the result
        firstHalfEnd.next = reverseList(secondHalfReversed);

        return result;


    }

    // find the middle element
    public ListNode findFirstHalfEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }


    // reverse list code
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;

        while(fast != null) {

            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;

        }

        curr.next = prev;
        return curr;

    }

}