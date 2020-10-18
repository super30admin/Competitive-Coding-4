/*

This is a recursive DFS solution.
TC: O(N)
SC: O(N) 
1. Check if left and right subtrees are balanced recursively.
2. Also, check if current node is balanced. 

*/

public class HeightBalancedTree {
    
    public boolean heightbalance(TreeNode root){

        if(root == null) return true;
        int diff = helper(root, 0);
        return diff == -1 ? false : true;
    }

    private int helper(TreeNode node, int level){
        if(node == null) return 0;

        int left = helper(node.left, level + 1);
        if(left == -1) return -1;
        int right = helper(node.right, level + 1);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;  
    }

}

class TreeNode{

    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}
