// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Find height of each node starting from the leaves
 */

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
class TreeInfo{
    int height;
    boolean balanced;
    TreeInfo(int height,boolean balanced){
        this.height=height;
        this.balanced=balanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanced(root).balanced;
    }

    public TreeInfo balanced(TreeNode root){
        if(root==null){
            return new TreeInfo(-1,true);
        }

        TreeInfo left=balanced(root.left);
        if(!left.balanced){
            return new TreeInfo(-1,false);
        }
        TreeInfo right=balanced(root.right);
        if(!right.balanced){
            return new TreeInfo(-1,false);
        }

        if(Math.abs(left.height-right.height)<2){
            return new TreeInfo(1+Math.max(left.height,right.height),true);
        }

        return new TreeInfo(-1,false);

    }
}
