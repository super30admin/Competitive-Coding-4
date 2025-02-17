// Time Complexity : O(n) where n is the number of nodes in the linked list
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 1. Find the mid of the linked list
// 2. Reverse the second half of the linked list
// 3. Compare the first half and the reversed second half of the linked list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }

        // finding the mid
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid of linkedList
        ListNode secHead = slow.next;


        // reverse the second half
        ListNode newLinkedList = reverse(secHead);

        slow.next = null;

        // comparing two linked lists
        while(newLinkedList != null){
            if(head.val != newLinkedList.val){
                return false;
            }
            head = head.next;
            newLinkedList = newLinkedList.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
