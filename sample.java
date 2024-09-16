// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode current = head2;
        ListNode temp;
        
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        ListNode head1 = head;
        head2 = prev;
        
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    
    }
}

// Time Complexity : O(N * h)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    boolean result;
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        result = true;
        
        result = isBalanced(root.left) && isBalanced(root.right) && Math.abs(findHeight(root.left) - findHeight(root.right)) < 2;
        
        return result;
        
    }
    
    private int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = Math.max(findHeight(root.left),findHeight(root.right)) + 1;
        return height;
    }
}

