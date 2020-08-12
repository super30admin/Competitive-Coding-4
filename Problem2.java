// Time Complexity :O(n)
//       n: number of nodes
//   Worst Case we compute height of all the subtree and compare heights
// Space Complexity : O(h) = O(n)
//      h: height of the tree
//      n: number of nodes
//    Worst Case entire tree is skewed
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: Using DFS
// 1. Find height of left and right sub tree recursively.
// 2. If either is -1 return -1.
// 3. Else check if both branch have differnece less than equal to 1.
// 4. Return max of left, right else -1;
class Problem2 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
   
    /** is tree balanced */
    public boolean isBalanced(TreeNode root) {
            // check if height is equal or greater than 0
            return (dfsTreeHeight(root) > -1);
    }
    
    /** find dfs height */
    public int dfsTreeHeight(TreeNode root){
        // base case reached leaf node
        if(root == null)
            return 0;
        else{
            
            // get height of left subt tree
            int left = dfsTreeHeight(root.left);
            // get height of right subt tree
            int right = dfsTreeHeight(root.right);

            // if either of them is not balanced
            if(left == -1 || right == -1)
                return -1;
            // both branch are balanced
            else if(Math.abs(left-right) <= 1)
                return Math.max(left, right) +1;
            // not balanced
            else
                return -1;
        }
    }
}