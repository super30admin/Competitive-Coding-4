//time complexity:O(n)
//space complexity:O(h)
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

public class TreeBalance {

        public boolean isBalanced(TreeNode root)
        {
            if(root==null)
            {
                return true;
            }
            int h=height(root);
            if(h==-1)
            {
                return false;
            }
            return true;
        }
        public int height(TreeNode root)
        {

            if(root==null)
            {
                return (0);
            }
            int lefth=height(root.left);
            int righth=height(root.right);

            if((Math.abs(lefth-righth) > 1) )
            {
                return -1;
            }
            if(lefth==-1 || righth==-1)
            {
                return -1;
            }
            return Math.max(lefth,righth)+1;
        }
    public static void main(String[] args) {
        TreeBalance tree = new TreeBalance();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(tree.isBalanced(root));
    }
    }

