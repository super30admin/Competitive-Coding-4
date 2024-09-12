//Definition for a binary tree node.
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

public class BalancedBinaryTree {
        boolean result = true;
        public boolean isBalanced(TreeNode root) {
            int height = helper(root,result);
            return result;
        }

        private int helper(TreeNode root, boolean r){
            if(root==null)
                return 0;
            int left = helper(root.left,result);
            int right = helper(root.right,result);

            if(Math.abs(left-right) > 1){
                result = false;
            }

            return 1+ Math.max(left,right);
        }
        public static void main(String[] args){
            BalancedBinaryTree  tree = new BalancedBinaryTree();
            TreeNode root;
            root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.right = new TreeNode(5);
            root.left.right.right = new TreeNode(5);
            root.left.right.right = new TreeNode(5);
            System.out.print(tree.isBalanced(root));
        }
}
