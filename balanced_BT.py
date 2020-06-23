# Time Complexity : Add - O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Calculate heigh for each node, I have defined a function getHeight that does that
2. Now I traverse again through all the nodes recusrively while also checking teh difference of left child's height
   and right child's height
'''

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        if self.isBalanced(root.left) and self.isBalanced(root.right) and \
        abs(self._getHeight(root.left) - self._getHeight(root.right)) <= 1:
            return True
        
        return False
        
        
    def _getHeight(self,root):
        
        if root is None:
            return -1
        
        return max(self._getHeight(root.left), self._getHeight(root.right))+1