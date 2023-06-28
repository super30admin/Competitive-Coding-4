public class BalancedBinaryTreeTopDownRecursion {


    // TOP-DOWN RECURSION

        public boolean isBalanced(TreeNode root) {

            //null case
            if(root == null) return true;

            // check difference of heights of children of root
            if(Math.abs(height(root.left) - height(root.right)) > 1) return false;

            // check if subtrees at children of root are height balanced
            return isBalanced(root.left) && isBalanced(root.right); //call from top-down

        }

        private int height(TreeNode root) {

            // base case
            if(root == null) return 0;

            //logic
            return Math.max(height(root.right), height(root.left)) + 1;
        }


}

/* Time Complexity = O(nlogn) - for a node at depth p, height(node) is called d times,

Space Complexity = O(n) i.e. O(H) - recursive stack */

