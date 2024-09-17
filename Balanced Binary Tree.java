/*
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            True
        
        self.flag = True
        self.height(root, 0)
        
        return self.flag
    
    def height(self, root, h):
        if root is None or self.flag is False:
            return h-1
        
        left = self.height(root.left, h+1)
        right = self.height(root.right, h+1)
        
        if abs(left -right ) > 1:
            self.flag = False
        
        
        return max(left, right)
*/
// Time Complexity : O(n) where n is no of nodes in tree
// Space Complexity : O(h) where h is height of tree which would be n in left skewed or right skewed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I calculated left and right height and then subtracted to calculat
// difference

class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        flag = true;
        height(root, 0);
        return flag;
    }
    
    private int height(TreeNode root, int heigth){
        if (root == null)
            return heigth - 1;
        
        int left = height(root.left, heigth + 1);
        int right = height(root.right, heigth + 1);
        
        if (Math.abs(left - right) > 1){
            flag = false;
            return heigth - 1;
        } 
        else{
            return Math.max(left, right);
        }
        
    }
}

        