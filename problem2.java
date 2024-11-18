public class problem2 {
// Time Complexity : O(n), where n is the number of nodes in the linked list.
// The list is traversed twice: once to find the middle and once to compare both halves.
// Space Complexity : O(1), because we are using only a few pointers for manipulation,
// and no extra space proportional to the input size is required.

    // Did this code successfully run on Leetcode : Yes
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public boolean isPalindrome(ListNode head) {

        ListNode fast= head;
        ListNode slow= head;

        while(fast!= null && fast.next!=null)
        {
            fast = fast.next.next;
            slow= slow.next;
        }

        slow= reversed(slow);
        fast = head;

        while(slow!=null)
        {
            if(slow.val!= fast.val)
            {
                return false;
            }
            slow= slow.next;
            fast= fast.next;
        }
        return true;
    }
    public  ListNode reversed(ListNode head)
    {
        ListNode prev= null;
        ListNode next= head;

        while(head!=null)
        {
            next= head.next;
            head.next= prev;
            prev= head;
            head= next;
        }
        return prev;

    }
}
