# Time Complexity : O(n) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the height of left and right subtree and recursively check for every node.

class Solution:
    def heightofBT(self, root):
        if(root==None):
            return 0
        lh=self.heightofBT(root.left)
        rh=self.heightofBT(root.right)
        
        if(lh>rh):
            return lh+1
        else:
            return rh+1
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if(root==None):
            return True
        
        lh=self.heightofBT(root.left)
        
        rh=self.heightofBT(root.right)
        left_bal=self.isBalanced(root.left)
        right_bal=self.isBalanced(root.right)
        height_diff = abs(lh - rh)
        return height_diff <= 1 and left_bal and right_bal