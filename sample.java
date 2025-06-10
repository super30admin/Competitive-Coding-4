// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find middle of linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode secondHalf = reverseList(slow.next);

        // Compare first half with reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list
        slow.next = reverseList(secondHalf);

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }}//

Height Balanced
Binary Tree
    //

    // Time Complexity : O(n) where n is the number of nodes in the tree
    // Space Complexity : O(h) where h is the height of the tree (due to recursion
    // stack)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    // Definition for a binary tree node
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // Get height of left subtree
            int leftHeight = getHeight(node.left);
            if (leftHeight == -1) {
                return -1;
            }

            // Get height of right subtree
            int rightHeight = getHeight(node.right);
            if (rightHeight == -1) {
                return -1;
            }

            // Check if current node is balanced
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            // Return height of current node
            return Math.max(leftHeight, rightHeight) + 1;
        }
}
