"""
Problem: https://leetcode.com/problems/balanced-binary-tree/

Approach:

1. Use bottom up recursion to find if each note is height balanced and send True and the height to its parent
2. in the parent node check if botth children are height balanced


"""

# Time Complexity : O(N) where N is the no of nodes in the tree
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    
    def helper(self,root):
        if root==None:
            return (True,-1)
        
        isleftBalanced,leftHeight = self.helper(root.left)
        if not isleftBalanced:
            return False,0
        
        isRightBalanced, rightHeight = self.helper(root.right)
        if not isRightBalanced:
            return False,0
        
        return abs(leftHeight-rightHeight)<2 ,1+ max(leftHeight,rightHeight)
    
    def isBalanced(self, root: TreeNode) -> bool:
        return self.helper(root)[0]
        
        
        
        