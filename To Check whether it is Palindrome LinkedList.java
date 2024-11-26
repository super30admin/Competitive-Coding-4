// Time complexity 0(n)
// space complexity 0(n)
// Code sucessfully executed in leetcode

class Solution {
    public boolean isPalindrome(ListNode head) {
        //base case
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;   
        }
         // if (fast != null) { 
         //     slow = slow.next;
         // }
        ListNode Center = reverseList(slow);
        // compare 1st half of list to 2nd half
        ListNode Front = head;
        while (Center != null) {
            if (Center.val != Front.val) {
                return false;
            }
            Front = Front.next;
            Center = Center.next;
        }
        return true;
    }
    // Reversing List
     private ListNode reverseList(ListNode head) {
        // edge case
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;
        while(fast!=null){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        return current;      
    }
}