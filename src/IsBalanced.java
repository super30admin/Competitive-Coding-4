//TC O(n)
// SC O(1)
public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return findHeight(root) != -1;
        }

        private int findHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
