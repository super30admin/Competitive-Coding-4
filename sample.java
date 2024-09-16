// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Reach the mid of the linkedList. Reverse the second half
// Compare first half with reversed second half.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null)
            return true;
        
        if(head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = reversae(slow.next);
        slow.next = null;
        slow = head;
        while(fast != null){
            if(fast.val != slow.val){
                return false;
            } 
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    private ListNode reversae(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = node.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
        
    }
}

// ============================Balanced Binary Tree======================
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// // Your code here along with comments explaining your approach
// Check whether left sub tree is balanced, Check if right sub tree is balanced.
// Calculate height of each nodes and compare with its right and left nodes. If the difference is greater than 1 return false.
// Note - the difference between Depth(Bottom to top) and Height(Top to bottom) of a tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && 
            Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    
    private int height(TreeNode root){
        //base
        if(root == null)
            return 0;
        else
        //logic
            return Math.max(height(root.left), height(root.right))+1;
    }
}
