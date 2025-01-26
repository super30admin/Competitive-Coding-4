// In this problem, we can do one thing is that put all the elements of linkedlist in array, and then use two pointers, one at start and
// one at end. Check if equal, increment start pointer and decrement end pointer. All values match then it is a palindrome. But problem
// in this approach is that, it takes up extra (array) space. 
// And it is a singly linked list so we cannot directly have pointer at end node, we just have next pointers in single direction.
// So, we can find the mid of the linked list using slow and fast pointers, then reverse the linked list from mid to end and then keep 
// two pointers, one at head and one at the start of reversed LL, then compare if equal or not.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isPalindrome(ListNode head) {
        // Base case if head is null or head.next is null meaning only one element, then
        // it is palindrome
        if (head == null || head.next == null) {
            return true;
        }
        // To find the mid of LL
        // Declare slow and fast pointers both starting at head
        ListNode slow = head;
        ListNode fast = head;
        // Go on until fast not null and fast.next not null (In case of even and odd it
        // will be different, either fast will be at null or fast will be at end node)
        while (fast != null && fast.next != null) {
            // Increment slow by 1 and fast by 2
            slow = slow.next;
            fast = fast.next.next;
        }
        // After finding the mid of LL, i.e slow pointer node now, reverse the second
        // half of LL, i.e. from mid to end
        // To reverse, declare 2 pointers, prev which is null and curr which is the mid
        // of LL(i.e. slow)
        ListNode prev = null;
        // Go until you reach the end of LL
        while (slow != null) {
            // Store the slow.next value in tmp
            ListNode tmp = slow.next;
            // Update slow.next to prev
            slow.next = prev;
            // Then increment both pointers(prev to slow and slow to slow.next(which was
            // stored in tmp))
            prev = slow;
            slow = tmp;
        }
        // Then two pointers, one at head
        ListNode left = head;
        // Other at the start of reversed LL, which is at prev now
        ListNode right = prev;
        // Loop for half LL
        while (right != null) {
            // Check if both value are not equal
            if (left.val != right.val) {
                // It is not palindrome, return false
                return false;
            }
            // Otherwise increment pointers
            left = left.next;
            right = right.next;
        }
        // If the loop ended without returning false, then it is a palindrome, so return
        // true
        return true;

    }
}