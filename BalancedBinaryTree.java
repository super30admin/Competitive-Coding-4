//Time Complexity: O(n)
//Space Complexity: O(1)
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return maxHeight(root)!=-1;
    }

    public int maxHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int right = maxHeight(root.right) ;
        int left = maxHeight(root.left) ;
        if(Math.abs(left-right)>1){
            return -1;
        }
        if(left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
}
