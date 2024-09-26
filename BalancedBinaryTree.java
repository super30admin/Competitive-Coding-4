import javax.swing.tree.TreeNode;
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
//balanced tree is abs(left height - right height) <= 1
public class BalancedBinaryTree {

    class Solution {

        //calculate height of tree
        private int height(TreeNode root){
            if(root == null) return -1;
            int height = 1+ Math.max(height(root.left), height(root.right));

            return height;
        }


        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;

            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }


}
