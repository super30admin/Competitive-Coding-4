// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class LinkedListPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        
    public static boolean isPalindrome(ListNode head) {
        // Base case
        if (head == null || head.next == null) return true;
    
        // Find the mid point of the given linked list. 
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        ListNode part1 = head;

        // Reverse the second part of the Linked List
        ListNode part2 = reverseList(slow.next);
    
        // If the Linked List is of odd length, length of first half list is greater than length of second half.
        // If the Linked List is of even length, length of first half list is equal to the length of second half.
        boolean result = true;

        // Add a check to see wether the second half of the list is reached to end. 
        while (result && part2 != null) {

            // At any pair of node, if we find that the values are in equal then return false.
            if (part1.val != part2.val){
                result = false;
                break;
            }
            part1 = part1.next;
            part2 = part2.next;
        }
        return result;
    }
    
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, fast=curr.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }

    public static ListNode generateLinkedList(int[] nums){
        ListNode head = null, prev = null;
        for(int i = nums.length-1; i>=0; i--){
            head = new ListNode(nums[i], prev);
            prev = head;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(generateLinkedList(new int[]{1,2,3,2,1})));
        System.out.println(isPalindrome(generateLinkedList(new int[]{1,2,3,4,4,3,2,1})));
        System.out.println(isPalindrome(generateLinkedList(new int[]{4,5})));
        System.out.println(isPalindrome(generateLinkedList(new int[]{4})));
    }
}
