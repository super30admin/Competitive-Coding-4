import javax.swing.tree.TreeNode;

//Idea is to calculate left and right subtree at each nodes and
//maintain a global flag to mark if the balanced tree rule doesnot follow at 
//any node.

//Time Complexity: O(n)
//Space Complexity: O(n)
public class balancedtree {
        boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int leftheight = 1+helper(root.left);
        int rightheight = 1+helper(root.right);

        if(Math.abs(leftheight-rightheight)>1)
        {
            this.flag = false;
        }
        return Math.max(leftheight,rightheight);
    }
}
