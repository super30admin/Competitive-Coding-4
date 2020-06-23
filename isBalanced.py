#110. Balanced Binary Tree
# Time Complexity : O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        left = self.height(root.left)
        right = self.height(root.right)
        
        if abs( left - right) > 1:
            return False
        
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def height(self,root):
        if not root:
            return 0
        return max(self.height(root.left),self.height(root.right)) + 1