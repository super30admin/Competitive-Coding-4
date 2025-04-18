// Time Complexity : O(n)
// Space Complexity : O(h), height of tree , worst case: O(n) for skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


/*Approach :
1. For each node find the height of its left subtree and right subtree using recursion
2. At each node check if the subtree is balanced, if not set flag to false
3. Each node returns the max height of its subtrees+1 to the parent node
*/

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
class HeightBalancedTree{
    boolean res=true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){

        if(root==null)
            return 0;

        int left=dfs(root.left);

        int right=dfs(root.right);

        if(Math.abs(left-right)>1)
            res=false;

        return Math.max(left,right)+1;
    }
}