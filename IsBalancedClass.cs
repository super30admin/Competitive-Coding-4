/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution
{
    bool isValid = true;
    public bool IsBalanced(TreeNode root)
    {
        GetHeight(root);
        return isValid;
    }

    public int GetHeight(TreeNode root)
    {    //root = null
        //base case
        if (root == null)
        {
            return 0;
        }

        //logic
        int leftHeight = 1 + GetHeight(root.left);
        int rightHeight = 1 + GetHeight(root.right);

        isValid = isValid && Math.Abs(leftHeight - rightHeight) <= 1;
        return leftHeight <= rightHeight ? rightHeight : leftHeight;
    }

}