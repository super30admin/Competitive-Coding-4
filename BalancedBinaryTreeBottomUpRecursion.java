public class BalancedBinaryTreeBottomUpRecursion {

    //BOTTOM-UP

        public boolean isBalanced(TreeNode root) {

            //
            if(root == null) return true;

            //
            return height(root) != -1;
        }

        private int height(TreeNode root) { // O(n)

            //base
            if(root == null) return 0;

            //logic
            int leftH = height(root.left);
            int rightH = height(root.right);

            if(Math.abs(leftH - rightH) > 1) return -1;

            if(leftH == -1 || rightH == -1) return -1;

            return Math.max(leftH, rightH) + 1;
        }
}

/* Time Complexity = O(n) - traverses all nodes from bottom up -
for every subtree, height is only calculated once

Space Complexity = O(n) - return stack O(H)
*/