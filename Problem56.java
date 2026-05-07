// Time Complexity : O(N)
// Space Complexity : O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow.next);
        slow.next = null;
        slow = head;
        fast = reverseHead;

        while(slow!=null && fast!=null)
        {
            if(slow.val!=fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

      return true;
    }

    public ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode curr = node;

        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
            return prev;
    }

}