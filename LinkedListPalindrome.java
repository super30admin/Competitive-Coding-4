// Time Complexity : O(n) traverses through all nodes of list
// Space Complexity : O(1) not using any additional space except for constant nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LinkedListPalindrome {

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;


        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            //System.out.println("slowP" + slowP.val);
            fast = fast.next.next;
            //System.out.println("fastP" + fastP.val);
        }

        fast = reversedList(slow.next);

        slow = head;

        while(fast != null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reversedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;

        return curr;
}
