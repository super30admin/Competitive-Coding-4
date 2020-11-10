package S30.CompetitiveCoding_4;

/*
Time Complexity : Put: O(n),
Space Complexity : O(h), O(n) is tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class CheckIfBinaryTreeIsHeightBalanced {

    class TreeNode {
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

    class Pair{
        int height;
        boolean result;

        public Pair(int ht, boolean result){
            this.height = ht;
            this.result = result;
        }
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;
        Pair finalResult = helper(root);
        return finalResult.result;
    }

    public Pair helper(TreeNode root){

        //base
        if(root == null) return new Pair(0,true);

        //logic
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        if(left.result == false || right.result == false) return new Pair(height,false);
        if(Math.abs(left.height - right.height) > 1) return new Pair(height,false);
        return new Pair(height,true);
    }
}
