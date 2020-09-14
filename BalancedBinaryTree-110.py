# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

# 1. Check height for a node
# 2. All nodes of the tree should be balanced
class Solution(object):
    def checkHeight(self, root):
        if root is None:
            return 0
        return 1 + max(self.checkHeight(root.left), self.checkHeight(root.right))
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        
        left = self.checkHeight(root.left)
        right = self.checkHeight(root.right)
        
        height = abs(left-right)
        
        if height < 2 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        return False
