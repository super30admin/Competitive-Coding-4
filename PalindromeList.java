// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes

public class palindromeLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null)
            return true;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        
        ListNode prev = null;
        while(fast!=null){
            ListNode next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        fast = prev;
        while(slow!=null && fast!=null){
            if(slow.val!=fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}