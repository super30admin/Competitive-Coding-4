/*
This solution uses a bottom up recursion to get the answer. Starting from the leaf nodes, the height
of every node is calculated, and at the same time there is a check to determine whether the height 
 of the left and right subtree at that node is balanced. We are able to do this because, we utilize
 the logic to calculate height at each node using the maximum height of its left and right subtrees.
 If the heights are not balanced, instead of checking further we simply return false.
 
 Did this code run on leetcode: yes
*/
class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(h)
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        int result = countHeight(root);
        
        return result != -1;
        
    }
    
    private int countHeight(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);
        
        //Checking the difference between the heights
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        
        //If there is already -1 returned from an already executed recursive function call, we return -1
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}