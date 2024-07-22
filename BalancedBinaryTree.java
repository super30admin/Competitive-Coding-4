public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        //null check
        if(root == null) return true;

        //if height is returned as -1, it is not balanced
        //any height other than -1 means the tree is balanced
        return height(root) != -1;
    }

    static int height(TreeNode root) { //O(n) T.C, O(1) S.C
        //base
        if(root == null) return 0;

        //recurse
        int leftHeight = height(root.left); //recursively find height of left child
        int rightHeight = height(root.right); //recursively find height of right child

        //logic
        //if the difference between heights of both children is > 1 (by definition)
        if(Math.abs(leftHeight - rightHeight) > 1 ||
                leftHeight == -1 || rightHeight == -1) { //or if either of the children is already not a balanced tree
            return -1; //return -1 to parent call instead of providing actual height as it is not a balanced tree.
        }

        return Math.max(leftHeight, rightHeight) + 1; //else, provide actual height
        //calculated as max between heights of both children, + 1 level to that for this node.
    }

    public static void main(String[] args) {
        // Construct the sample tree
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        // Check if the tree is balanced
        boolean isBalanced = isBalanced(root);

        // Print the result
        System.out.println("Is the tree balanced? " + isBalanced);
    }
}