// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        if(head == null){
            return true;
        }

        ListNode node = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = reverseList(slow);

        slow = head;
        fast = middle;

        while(slow != middle && fast.next != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode temp = null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
