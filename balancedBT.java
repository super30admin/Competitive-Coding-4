// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 1;
        }
        
        int lh = height(node.left);
        if (lh == -1) {
            return -1;
        }
        
        int rh = height(node.right);
        if (rh == -1) {
            return -1;
        }
        
        if (Math.abs(lh-rh) > 1) {
            return -1;
        }
        
        return 1 + Math.max(lh,rh);
    }
}