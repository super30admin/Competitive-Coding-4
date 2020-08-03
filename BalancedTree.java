//Time Complexity:O(n)
//Space Complexity:O(height)
/*Approach
-comparing height of left subtree and right subtree at each node and if it
is greater than 1 returning false and if it is less recursively going to its left and right
 */

public class BalancedTree {
    public static class TreeNode {
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
        //base
        if(root == null)return true;
        if(Math.abs(height(root.left)- height(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    private int height(TreeNode root){
        if(root == null)return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left=  new TreeNode(1);
        root.right=  new TreeNode(2);

        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(8);
        //root.left.left.left = new TreeNode(7);
        BalancedTree obj = new BalancedTree();
        System.out.println(obj.isBalanced(root));
    }
}