/*
 * Space complexity: O(1) only constant extra space is used here
 * Time complexity: O(N) traversal of all nodes.
 * 
 * */
class Solution {
    public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { 
    	// odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while(head!=null){
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;    
    }
    //head node would be set to null & prev node will be pointing to last node here now, so return prev
    return prev;
    }
}
