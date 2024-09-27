package s30.trees;

// ALGO
//get left subtree height and right subtree height recursively
// return false if they differ by more than 1


// Time Complexity O(n) Traverse through the all nodes of tree
// Space Complexity O(h) recursive stack
public class BalancedBinaryTree {

    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {

        isBalancedRec(root);

        return isBalanced;
    }

    private int isBalancedRec(TreeNode node){
        if(node == null) return 0;

        int left = isBalancedRec(node.left);
        int right=0;

        if(isBalanced) { right = isBalancedRec(node.right);}

        if(Math.abs(right - left) > 1) isBalanced = false;

        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {

    }
}
