// Time Complexity : O(N) where N=number of nodes in the tree
// Space Complexity : O(1) space, but O(H) for reucursion stack where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Keep doing recursion and send the level
2. When it's the last element return the max height of its two childs
3. Compare the heights at each level to see the difference
4. If the differnce is greator than 1 return false
*/


// Your code here along with comments explaining your approach
class Solution {
    boolean isLevelBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        treeLevel(root, 1);
        return isLevelBalanced;
    }
    
    public int treeLevel(TreeNode root, int height) {
        int leftHeight = height; int rightHeight = height;
        if(isLevelBalanced) {  
            if(root.left==null && root.right==null) return height;
            if(root.left!=null)
                leftHeight = treeLevel(root.left, height+1);
            if(root.right!=null)
                rightHeight = treeLevel(root.right, height+1);
            if(Math.abs(leftHeight - rightHeight) > 1)
                isLevelBalanced = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
