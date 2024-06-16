/*
    LC - 234. Palindrome Linked List
    TC - O(n)
    SC - O(1)
    Approach - 
        Find the middle of LL. 
        Reverse the second half of LL.
        check the val from both ends of LL and verify if it is palindrome.
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow!=null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        while(prev!=null) {
            if(prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}