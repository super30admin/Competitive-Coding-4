//Brute force-- expensive method
//public class HeightBalanced {
//    public boolean isBalanced(TreeNode root) {
//        if (root==null) return true;
//        if(Math.abs(height(root.left)-height(root.right))>1)return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//
//    }
//    private int height(TreeNode root){
//        if(root==null) return 0;
//        return Math.max(height(root.left),height(root.right)) + 1;
//    }
//}

//Optimized
public class HeightBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return height(root)!=-1;

    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1) return -1;
        if(left==-1||right==-1) return -1;
        return Math.max(left,right) + 1;
    }
}
