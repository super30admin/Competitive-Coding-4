// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // finding mid
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;
        // reversing the list, from address mid +1
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // comparing main list with reversed list
        while(head != null && prev != null) {
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
    // 21->11
    // 21

//     private ListNode reverse(ListNode startNode) {
//         if(startNode == null || startNode.next == null) return startNode;
//         ListNode rev = reverse(startNode.next);
//         //pop()
//         startNode.next.next = startNode;
//         startNode.next = null;
//         return rev;
//     }
}

