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
// Time complexity = O(n) // all nodes worst case.
// space complexity = O(h) if recursive stack is included else O(1)
// h can be log(n) or n (worst case.)
class BalancedBinaryTree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root== null) {
            return flag;
        }
        helper(root);
        return flag;
    }
    
    // Intuition
    // all the left nodes are first covered. by helper(root.left)
    // then you hit null at leftmost.
    // you return 0. (Ignore the flag at this point)
    // move towards right nodes. 
    // you get your null there too or say a node , and the length now is 1 for right.
    // you have returned back to the parent.
    // so the leaf nodes are considered, then the parents. but the root is never null at least in the stack.
    // then check whether the left -right >1, if so, then unequal tree.
    // else we know the length of the subtree is 1+ max of whatever is the height of any tree.
    // then we again return back to the caller in the stack.
    // that gets the max value (int left)
    // continue to the right node. (int right now)
    private int helper(TreeNode root) {
        if(root == null || !flag ) {
            return 0;
        }
        int left = helper(root.left);
        // stack.pop() with the parent value.
        int right = helper(root.right);
        // stack.pop() with the parent value.
        if(Math.abs(left-right)>1) {
            flag = false;
        }
        return 1+ Math.max(left,right);
    }
}