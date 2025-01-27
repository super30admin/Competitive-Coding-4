// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :YES -> from where to reverse the ll

public class Problem2 {
    boolean isPalindromeOrNot;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        isPalindromeOrNot = true;
        findIsPalindrome(head);
        return isPalindromeOrNot;
    }

    private void findIsPalindrome(ListNode head){
        //with 2 pts we'll find the mid from where we can split the ll into 2 half's
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //now slow is at the point where the 1st ll should end , means the 2nd start from slow.next
        ListNode head2 = slow.next;
        slow.next = null;
        //reverse the 2nd ll
        head2 = reverseList(head2);
        //now loop until any of the ptr is null
        while(head != null && head2 != null){
            if(head.val != head2.val){
                isPalindromeOrNot = false;
            }
            head = head.next;
            head2 = head2.next;
        }
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev= null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
