public class BalancedBinaryTree {

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
    public boolean isBalanced(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        int diff=treeHeight(root);
        if(diff==-1)
            return false;      
        return true;
    }
    public static int treeHeight(TreeNode node){
        if(node==null)
            return 0;
        int leftHeight=1,rightHeight=1;
        
        if(node.left!=null)
            leftHeight=treeHeight(node.left);
        
        if(node.right!=null)
            rightHeight=treeHeight(node.right);
        
        if(leftHeight==-1 || rightHeight==-1)
            return -1;
        leftHeight++;
        rightHeight++;
        int diff=Integer.max(leftHeight,rightHeight)-Integer.min(leftHeight,rightHeight);
        if(diff==1 || diff==0)
            return Integer.max(leftHeight,rightHeight);
        return -1;
        
    }
}
