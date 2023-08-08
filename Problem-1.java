// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Solution: Palindrome Linked List
// Have slow and fast pointer and get the mid, reverse list from mod to end. We will have spit 2 lists now.
// compare nodes of both lists now from starting and return false if anywhere corrosponding node val is not equal
class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);
        slow.next=null;
        slow = head;
        fast = reversed;

        while(slow.next!=null){
            if(fast.val!=slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
        
    }

    private ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}