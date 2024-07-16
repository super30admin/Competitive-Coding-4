// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;  // Empty list or single element list is a palindrome
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the midpoint of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode secondHalfHead = reverse(slow);

        // Compare the first and the reversed second half
        ListNode firstHalfHead = head;
        while (secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true;

    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node ;
        while(curr != null){
            ListNode temp = curr.next ;
            curr.next = prev;
            prev = curr ;
            curr = temp;
        }
        return prev;

    }
}

//-----------------------------------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    public boolean isBalanced(TreeNode root) {
        if(root == null ) return true;
        
        int left_height = helper(root.left);
        int right_height = helper(root.right);

        return Math.abs(left_height - right_height) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int helper(TreeNode node){
        if(node == null) return 0;

        else{
            return 1+ Math.max(helper(node.left),helper(node.right));
        }

    }
}

//---------------------------
