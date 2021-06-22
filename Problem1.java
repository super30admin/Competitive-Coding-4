// Time - O(NlogN) 
// Space - O(N)

class Solution {
    public boolean isBalanced(TreeNode root) {

        if(root == null) {

            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);


    }

    public int height(TreeNode root) {

        if(root == null) return -1;

        System.out.println(Math.max(height(root.left),height(root.right)));

        // Recursively obtain height of a tree
        return 1 + Math.max(height(root.left),height(root.right));



    }



} 