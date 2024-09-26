//https://leetcode.com/problems/balanced-binary-tree
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


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
        int res = helper(root); // calling helper for root and getting height if tree is balanced
        //else returning -1 from helper
        
        return res == -1 ? false : true;
    }
    
    private int helper(TreeNode root)
    {
        //base
        if(root == null) // if we reach a null node
            return 0; // height is 0
        
        //logic
       
        int left = helper(root.left); // calling helper on root left and storing the return value in left
        int right = helper(root.right); // calling helper on root right and storing the return value in right
        
         if(left == -1 || right == -1 || Math.abs(left-right) > 1) // as bottom - up recursion so we check at any point we get the diff between left and right height as more than 1 
         // or if the previous left or right call returned -1, then it is not balances and needs to be propogated to the parent so return -1 
            return -1;
        
        return Math.max(left,right)+1; // to decide between left and right branches, we take max of the two branches ( as that would be the height of the node) and add one as height increased by 1 at each node
    }
}

//https://leetcode.com/problems/palindrome-linked-list
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
        
        if(head == null) // if list is empty
            return true;    // it is palindrome 
    
        ListNode slow = head;
        ListNode fast = head;
        
        //finding mid of list
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next; // moving slow by 1 step
            fast = fast.next.next; // moving fast by 2 steps
        }
        
        ListNode head2 = slow.next; // pointing head2 to starting of 2nd list
        slow.next = null; // breaking the link
        
        //finding reverse from the middle of the list and pointing it by head2
         head2 = reverse(head2);
      
        
        while(head2!=null && head!=null) // till either of list becomes null
        {
            if(head.val!=head2.val) // if values are not equal
                return false;
            
            head2 = head2.next; // move head2
            head = head.next; // move head
        }
            
           return true; 
      
    }
    
   
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null; // to keep track of prev
        ListNode curr = head; // keep track of current
       ListNode fast; // keep track of next element
        
        while(curr!=null) // till curr becomes null
        {
            fast= curr.next; // move fast
            curr.next = prev; // change the link of curr to point to prev
            prev = curr; // move prev to curr
            curr = fast; // move curr to fast
            
        }
        
        return prev; // curr becomes null and prev gives the start of list
    }
}