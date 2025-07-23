//Time Complexity: O(n) — each node is visited once during the DFS traversal.
//Space Complexity: O(h) — recursion stack space, where h is the height of the tree 

//Use DFS to compute the height of left and right subtrees for every node.
//If the height difference exceeds 1 or a subtree is already unbalanced, return -1.
//If all nodes are balanced, return true; otherwise, return false.

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightStatus = checkHeight(root);
        return heightStatus != -1;
    }

    public int checkHeight(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        // Traverse left subtree
        int leftHeight = checkHeight(currentNode.left);
        // Traverse right subtree
        int rightHeight = checkHeight(currentNode.right);

        // If either subtree is unbalanced or the height difference > 1, return -1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
