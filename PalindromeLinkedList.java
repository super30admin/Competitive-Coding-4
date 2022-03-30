/**
 * Time complexity is O(n) 
 * space complexity is O(n)
 */
class Solution {
    ListNode headIter;
    public boolean isPalindrome(ListNode head) {
        headIter = head;
        return helper(head);
    }
    
    private boolean helper(ListNode head) {
        if(head == null) {
            return true;
        }
        if(!helper(head.next)) {
            return false;
        }
        if(head.val != headIter.val) {
            return false;
        }
        headIter = headIter.next;
        return true;
    }
    class ListNode {
        ListNode next;
        int val;
    }
}