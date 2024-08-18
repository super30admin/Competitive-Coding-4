// Problem 234. Palindrome Linked List
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // base
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        ListNode first = head;
        boolean isPalindrome = true;
        while(second != null){
            if(first.val != second.val){
                isPalindrome = false;
            }
            first = first.next;
            second = second.next;
        }
        return isPalindrome;
    }
    private ListNode reverseList(ListNode head){
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
}