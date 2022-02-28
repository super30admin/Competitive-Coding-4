/*
Time Complexity: O(N*(H))
Space Complexity: O(N)
Run on Leetcode: yes

Approach:
1. find out the depth of the tree recursively
2. Then measure difference between the left height and right height and then based on the difference return boolean
 */
public class BalancedTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBalancedTree(TreeNode root){
        if(root == null){
            return true;
        }

        int leftH = calculateHeight(root.left, 0);
        int rightH = calculateHeight(root.right, 0);

        if(Math.abs(leftH-rightH)>1){
            return false;
        }

        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public static int calculateHeight(TreeNode root, int height){
        if(root == null){
            return 0;
        }

        int maxHeight = Math.max(calculateHeight(root.left, height)+1, calculateHeight(root.right, height)+1);

        return maxHeight;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalancedTree(root));
    }

}
