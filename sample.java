//problem 1
// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
        ListNode fast,slow;
        fast=slow=head;
        // going to the middle
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        // reversing
        ListNode prev,next,cur;
        prev=null;
cur=slow;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

        }
        //check 
        ListNode temp=head;
        while(prev!=null)
        {
            if(prev.val!=temp.val) return false;
            temp=temp.next;
            prev=prev.next;
        }
return true;
        

    }
}

//problem 1
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
    int height(TreeNode node)
    {
        if(node==null) return 0;
        int left=height(node.left);
        if(left==-1) return -1;
        int right=height(node.right);
        if(right==-1) return -1;
        
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
       
        int isBal=height(root);
        if(isBal==-1) return false;
        return true;
    }
}