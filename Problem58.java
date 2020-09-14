//Time Complexity: O(n)
//Space Complexity: O(n) with recursive stack
//Did it run on leetcode: yes
//Problems faced any: No


public class Problem58 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        //the subtrees should also be balanced
        return Math.abs(dfs(root.left) - dfs(root.right))<2 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;

        //we should return max height of left or right
        return Math.max(dfs(root.right), dfs(root.left)) + 1;

    }
}