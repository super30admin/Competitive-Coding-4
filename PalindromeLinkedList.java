// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1. Use slow and fast pointers to find the middle of linked list and split into two linked lists.
// 2. Reverse the linked list after middle node.
// 3. Now traverse one node at a time both first linked list(from starting node to middle) and 
//    second linked list(reversed linked list from middle to last node) and check the values .
//    If the values are different at any of iteration return false , else if both lists are traversed return true;
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
        //reversing second list
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
