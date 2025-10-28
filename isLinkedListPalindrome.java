// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : The approach is to find the mid if the linkedList and reverse the second part of the LinkedList so that we can compare head with mid + 1 node
//until end of the linkedList. If we find unequal values- we return false which means it's not a palindrome.

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; //move fast by 2
            slow = slow.next;// move slow by 1 so that slow will be mid
        }
        if(fast != null){
            slow = slow.next;//odd length case
        }
        while (slow != null) { //reverse the second part of array
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode p1 = head;

        while (prev != null) { //compare head and mid+1 nodes
            if (p1.val != prev.val) { //not equal means not a palindrome
                return false;
            } else { //if equal increment ahead
                p1 = p1.next;
                prev = prev.next;
            }
        }
        return true;
    }
}