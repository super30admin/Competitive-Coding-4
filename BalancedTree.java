// Time Complexity : depth O(n) and we are doint it O(n) times hence O(n^2) in worst case 
// Space Complexity :O(n) since we are doing isbalanced of left and right 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// top down approach
class Solution {
    // top down approach
    // here we use helper function depth to calculate depth of that root
    // so if our height of left and right subtree differ by more than 1 and if
    // either of the root subtrees are not balanced then return false
    // else return true

    // top down because we ar starting from root and going all the way to the leaf
    // (while checking subtrees are isbalanced or not)

    // in this approach we are checking depth of each and every node in the subtrees
    // non optimal
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int m = depth(root.left);
        int n = depth(root.right);

        if (Math.abs(m - n) > 1 || !isBalanced(root.left) || !isBalanced(root.right))
            return false;
        return true;

    }

    private int depth(TreeNode root) {

        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

// Time Complexity : In this bottom up approach, each node in the tree only need
// to be accessed once. so, O(N)
// Space Complexity :O(n) where n is the height .. since it has a call stack
// till the end is reached
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// bottom up approach
// a dfs approach will be not to check each and every child.. rather to only
// check if positive value is returned if -1 is returned then straightaway
// return -1 till the root(start collapsing)
// -1 will be returned if at any point bigheight-smallheight>1
// if not then Max(leftheight,rightheight)+1 can be returned.

// here in bottom up we can see that initially root.left is checked completely
// if it has any (isBalanced is false in one of its subtree) then return -1
// straightaway
// do similarly for the root.right.. then see if current node is balanced or not
// if yes return max leftHeight, rightHeight + 1;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) == -1 ? false : true;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);

    }

}